package com.github.easyrhyme.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.github.easyrhyme.bean.RhymeWord;
import com.github.easyrhyme.dao.RhymeWordDao;
import com.github.easyrhyme.util.RhymeWordUtils;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

@Service
public class RhymeQueryService implements ResourceLoaderAware {

    private static Logger logger = LoggerFactory.getLogger(RhymeQueryService.class);
    
    private ResourceLoader resourceLoader;
    
    private Map<String, List<String>> rhymeMapping = Maps.newHashMap();
    
    private static final String SEP = ",";
    
    @Resource
    private RhymeWordDao rhymeWordDao;
    
    @PostConstruct
    public void init() throws Exception {
        buildRhymeMappings();
    }
    
    /**
     * 从 押韵配置 构造 每个 韵母到 韵脚集 映射: a->(a,ia,ua), ia->(a,ia,ua), ua->(a,ia,ua)
     * */
    private void buildRhymeMappings() throws Exception {
        ClassPathResource clusterResource = (ClassPathResource) resourceLoader.getResource("classpath:rhyme_cluster.txt");
        
        File clusterFile = clusterResource.getFile();
        List<String> lines = FileUtils.readLines(clusterFile);
        for (String line: lines) {
            String[] vowels = StringUtils.split(StringUtils.trim(line), SEP);
            for (String vowel : vowels) {
                List<String> cluster = rhymeMapping.get(vowel);
                cluster = (cluster == null) ? Lists.<String>newArrayList(vowels) : cluster;
                rhymeMapping.put(vowel, cluster);
            }
        }
        
        logger.info("rhymeMapping={}", rhymeMapping);
    }

    /**
     * 单韵 查询
     * */
    public List<RhymeWord> singleQuery(String q, int limit, int offset) throws Exception {
        String keyVowel = getKeyVowel(q);
        Preconditions.checkArgument(StringUtils.isNotBlank(keyVowel), "singleQuery keyVowel cannot be blank");
        
        List<String> cluster = rhymeMapping.get(keyVowel);
        if (CollectionUtils.isEmpty(cluster)) {
            return Lists.newArrayList();
        }
        
        List<RhymeWord> words = rhymeWordDao.querySingle(cluster, limit, offset, q);
        return words;
    }

    private String getKeyVowel(String q) throws Exception {
        String pinyin = PinyinHelper.convertToPinyinString(q, ",", PinyinFormat.WITHOUT_TONE);
        String[] pys = StringUtils.split(pinyin, SEP);
        String last = pys[pys.length - 1];
        return RhymeWordUtils.getVowel(last);
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * 单韵 查询
     * 1 求 倒数两个字的 韵母
     * 3 sql 查询按freq 排序输出
     * */
    public List<RhymeWord> doubleQuery(String q, int limit, int offset) throws Exception {
        Pair<String, String> pair = getKeyVowelPair(q);
        List<String> firsts = rhymeMapping.get(pair.getLeft());
        List<String> seconds = rhymeMapping.get(pair.getRight());
        
        List<RhymeWord> words = rhymeWordDao.queryDouble(firsts, seconds, limit, offset, q);
        return words;
    }

    private Pair<String, String> getKeyVowelPair(String q) throws Exception {
        Preconditions.checkArgument(q.length() > 1, "双韵查询词长度必须大于1");
        String pinyin = PinyinHelper.convertToPinyinString(q, ",", PinyinFormat.WITHOUT_TONE);
        String[] pys = StringUtils.split(pinyin, SEP);
        String last = pys[pys.length - 1];
        String secondLast = pys[pys.length - 2];
        return Pair.of(RhymeWordUtils.getVowel(last), RhymeWordUtils.getVowel(secondLast));
    }

    /**
     * 多韵(3个及以上) 查询
     * */
    public List<RhymeWord> multiQuery(String q, int limit, int offset) throws Exception {
        List<String> vowels = getKeyVowels(q, 3);
        List<String> firsts = rhymeMapping.get(vowels.get(0));
        List<String> seconds = rhymeMapping.get(vowels.get(1));
        List<String> thirds = rhymeMapping.get(vowels.get(2));
        
        List<RhymeWord> words = rhymeWordDao.queryMulti(firsts, seconds, thirds, limit, offset, q);
        return words;
    }

    private List<String> getKeyVowels(String q, int number) throws Exception {
        Preconditions.checkArgument(q.length() >= number, "多韵查询词长度必须大于等于参数 number");
        List<String> r = Lists.newArrayList();
        
        String pinyin = PinyinHelper.convertToPinyinString(q, ",", PinyinFormat.WITHOUT_TONE);
        String[] pys = StringUtils.split(pinyin, SEP);
        
        for (int i = 1; i <= number; i++) {
            String py = pys[pys.length - i];
            r.add(RhymeWordUtils.getVowel(py));
        }
        return r;
    }

}

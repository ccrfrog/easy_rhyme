package com.github.easyrhyme.test.data;

import java.io.File;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.wltea.analyzer.lucene.IKAnalyzer;

import com.github.easyrhyme.bean.RhymeWord;
import com.github.easyrhyme.dao.RhymeWordDao;
import com.github.easyrhyme.util.RhymeWordUtils;
import com.github.easyrhyme.util.TableNameUtils;
import com.google.common.collect.Lists;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-test.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
public class LoadDataLocalTest {

    private static Logger logger = LoggerFactory.getLogger(LoadDataLocalTest.class);
    
    @Resource
    private RhymeWordDao rhymeWordDao;
    
    private Analyzer analyzer = new IKAnalyzer(true);
    
    /**
     * 从本机 lyric 目录读取 文本文件
     * 分词，求拼音和韵母后 写入数据库
     * */
    @Test
    public void test() throws Exception {
        File lyricDir = new File("src\\test\\resources\\lyric");
        File[] files = lyricDir.listFiles();
        
        for (File f: files) {
            processOneFile(f);
        }
    }

    private void processOneFile(File f) throws Exception {
        System.out.println(f.getName());
        String txt = FileUtils.readFileToString(f, Charset.defaultCharset());
        List<String> words = getWords(txt);
        
        for (String word : words) {
            RhymeWord rw = RhymeWordUtils.getRhymeWordFromLexeme(word);
            int inserted = rhymeWordDao.upsert(rw, TableNameUtils.getTableName(rw));
            logger.info("rhymeWordDao.upsert, word={}, inserted={}", rw.toString(), inserted);
        }
        
    }

    private List<String> getWords(String txt) throws Exception {
        List<String> words = Lists.newArrayList();
        
        TokenStream ts = analyzer.tokenStream("myfield", new StringReader(txt));
        // 获取词元位置属性
        OffsetAttribute offset = ts.addAttribute(OffsetAttribute.class);
        // 获取词元文本属性
        CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
        // 获取词元文本属性
        TypeAttribute type = ts.addAttribute(TypeAttribute.class);

        // 重置TokenStream（重置StringReader）
        ts.reset();
        // 迭代获取分词结果
        while (ts.incrementToken()) {
            words.add(term.toString());
        }
        // 关闭TokenStream（关闭StringReader）
        ts.end(); // Perform end-of-stream operations, e.g. set the final offset.
        ts.close();
        return words;
    }

}

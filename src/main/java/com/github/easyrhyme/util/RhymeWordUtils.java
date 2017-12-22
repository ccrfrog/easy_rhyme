package com.github.easyrhyme.util;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.easyrhyme.bean.RhymeWord;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

public class RhymeWordUtils {
    
    /**
     * 用于从 pinyin 得到韵母
     * 因为zh是 z 的前缀，必须放在前边
     * */
    public static List<String> ALL_CONSONANT = Lists.newArrayList("zh", "ch", "sh", "b", "p", "m", "f", "d", "t", "n", "l", "g", 
            "k", "h", "j", "q", "x", "r", "z", "c", "s", "y", "w"); 

    private static Logger logger = LoggerFactory.getLogger(RhymeWordUtils.class);
    
    private static final String SEP = ",";
    
    /**
     * 从文本词语 得到填充了 韵母的 RhymeWord 实例
     * */
    public static RhymeWord getRhymeWordFromLexeme(String word) {
        try {
            // 得到拼音
            String py = PinyinHelper.convertToPinyinString(StringUtils.trim(word), SEP, PinyinFormat.WITHOUT_TONE);
            String[] pys = StringUtils.split(py, SEP);
            
            // 去掉声母
            List<String> vowels = getVowels(pys);
            
            // 创建 RhymeWord
            RhymeWord rw = getRhymeWord(word, vowels);
            return rw;
        } catch (PinyinException e) {
            logger.error("getRhymeWordFromLexeme exception, word={}", word, e);
        }
        return null;
    }

    private static RhymeWord getRhymeWord(String lexeme, List<String> vowels) {
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(vowels), "vowels cannot be empty");
        
        // 倒数取最多 7 个韵母
        int len = vowels.size();
        String first = vowels.get(len - 1);
        String second = (len - 2 < 0) ? "" : vowels.get(len - 2);
        String third = (len - 3 < 0) ? "" : vowels.get(len - 3);
        String fourth = (len - 4 < 0) ? "" : vowels.get(len - 4);
        String fifth = (len - 5 < 0) ? "" : vowels.get(len - 5);
        String sixth = (len - 6 < 0) ? "" : vowels.get(len - 6);
        String seventh = (len - 7 < 0) ? "" : vowels.get(len - 7);
        
        Date now = new Date();
        RhymeWord rw = RhymeWord.builder(lexeme, first).second(second).third(third).fourth(fourth).fifth(fifth)
                .sixth(sixth).seventh(seventh).createTime(now).updateTime(now).build();
        return rw;
    }

    public static List<String> getVowels(String[] pys) {
        List<String> vowels = Lists.newArrayList();
        for (String py : pys) {
            String vo = "";
            for (String consonant : ALL_CONSONANT) {
                if (!py.startsWith(consonant)) {
                    continue;
                }
                vo = StringUtils.replaceFirst(py, consonant, "");
                vowels.add(vo);
                break;
            }
            if (StringUtils.isBlank(vo)) {
                vowels.add(py);// 零声母 pinyin
            }
        }
        return vowels;
    }
    
    public static String getVowel(String py) {
        String vo = StringUtils.EMPTY;
        for (String consonant : ALL_CONSONANT) {
            if (!py.startsWith(consonant)) {
                continue;
            }
            vo = StringUtils.replaceFirst(py, consonant, "");
            return vo;
        }
        if (StringUtils.isBlank(vo)) {
            return py;
        }
        return vo;
    }
    
}

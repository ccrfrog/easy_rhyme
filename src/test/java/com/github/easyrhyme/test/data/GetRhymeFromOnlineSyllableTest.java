package com.github.easyrhyme.test.data;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Sets;


public class GetRhymeFromOnlineSyllableTest {

    /**
     * http://xh.5156edu.com/pinyi.html
     * 从400+ 音节得到 无重复的 韵母
     * */
    @Test
    public void test() {
        Multimap<String, String> mm = MultimapBuilder.hashKeys().arrayListValues().build();
        
        mm.putAll("", Lists.newArrayList("a", "ai", "an", "ang", "ao"));
        
        mm.putAll("b", Lists.newArrayList("ba", "bai", "ban", "bang", "bao", "bei", "ben", "beng", 
                "bi", "bian", "biao", "bie", "bin", "bing", "bo", "bu"));
        
        mm.putAll("c", Lists.newArrayList("ca", "cai", "can", "cang", "cao", "ce", "cen", "ceng", 
                "ci", "cong", "cou", "cu", "cuan", "cui", "cun", "cuo"));
        
        mm.putAll("ch", Lists.newArrayList("cha", "chai", "chan", "chang", "chao", "che", "chen", "cheng", 
                "chi", "chong", "chou", "chu", "chua", "chuai", "chuan", "chuang", "chui", "chun", "chuo"));
        
        mm.putAll("d", Lists.newArrayList("da", "dai", "dan", "dang", "dao", "de", "den", "dei", "deng", 
                "di", "dia", "dian", "diao", "die", "ding", "diu", "dong", "dou", "du", "duan", "dui", "dun", "duo"));
        
        mm.putAll("", Lists.newArrayList("e", "ei", "en", "eng", "er"));
        
        mm.putAll("f", Lists.newArrayList("fa", "fan", "fang", "fei", "fen", "feng", "fo", "fou", "fu"));
        
        mm.putAll("g", Lists.newArrayList("ga", "gai", "gan", "gang", "gao", "ge", "gei", "gen", "geng", "gong", 
                "gou", "gu", "gua", "guai", "guan", "guang", "gui", "gun", "guo"));
        
        mm.putAll("h", Lists.newArrayList("ha", "hai", "han", "hang", "hao", "he", "hei", "hen", "heng", "hong", 
                "hou", "hu", "hua", "huai", "huan", "huang", "hui", "hun", "huo"));
        
        mm.putAll("j", Lists.newArrayList("ji", "jia", "jian", "jiang", "jiao", "jie", "jin", "jing", "jiong", 
                "jiu", "ju", "juan", "jue", "jun"));
        
        mm.putAll("k", Lists.newArrayList("ka", "kai", "kan", "kang", "kao", "ke", "ken", "keng", "kong", "kou", 
                "ku", "kua", "kuai", "kuan", "kuang", "kui", "kun", "kuo"));
        
        mm.putAll("l", Lists.newArrayList("la", "lai", "lan", "lang", "lao", "le", "lei", "leng", "li", "lia", "lian", 
                "liang", "liao", "lie", "lin", "ling", "liu", "long", "lou", "lu", "lv", "luan", "lue", "lun", "luo"));
        
        mm.putAll("m", Lists.newArrayList("ma", "mai", "man", "mang", "mao", "me", "mei", "men", "meng", 
                "mi", "mian", "miao", "mie", "min", "ming", "miu", "mo", "mou", "mu"));
        
        mm.putAll("n", Lists.newArrayList("na", "nai", "nan", "nang", "nao", "ne", "nei", "nen", "neng", "ni", 
                "nian", "niang", "niao", "nie", "nin", "ning", "niu", "nong", "nou", "nu", "nv", "nuan", "nve", "nuo"));
        
        mm.putAll("", Lists.newArrayList("o", "ou"));
        
        mm.putAll("p", Lists.newArrayList("pa", "pai", "pan", "pang", "pao", "pei", "pen", "peng", "pi", "pian", 
                "piao", "pie", "pin", "ping", "po", "pou", "pu"));
        
        mm.putAll("q", Lists.newArrayList("qi", "qia", "qian", "qiang", "qiao", "qie", "qin", "qing", "qiong", 
                "qiu", "qu", "quan", "que", "qun"));
        
        mm.putAll("r", Lists.newArrayList("ran", "rang", "rao", "re", "ren", "reng", "ri", "rong", "rou", 
                "ru", "ruan", "rui", "run", "ruo"));
        
        mm.putAll("s", Lists.newArrayList("sa", "sai", "san", "sang", "sao", "se", "sen", "seng", 
                "si", "song", "sou", "su", "suan", "sui", "sun", "suo"));
        
        mm.putAll("sh", Lists.newArrayList("sha", "shai", "shan", "shang", "shao", "she", 
                "shei", "shen", "sheng", "shi", "shou", "shu", "shua", "shuai", "shuan", "shuang", "shui", "shun", "shuo"));
        
        mm.putAll("t", Lists.newArrayList("ta", "tai", "tan", "tang", "tao", "te", "teng", "ti", 
                "tian", "tiao", "tie", "ting", "tong", "tou", "tu", "tuan", "tui", "tun", "tuo"));
        
        mm.putAll("w", Lists.newArrayList("wa", "wai", "wan", "wang", "wei", "wen", "weng", "wo", "wu"));
        
        mm.putAll("x", Lists.newArrayList("xi", "xia", "xian", "xiang", "xiao", "xie", "xin", 
                "xing", "xiong", "xiu", "xu", "xuan", "xue", "xun"));
        
        mm.putAll("y", Lists.newArrayList("ya", "yan", "yang", "yao", "ye", "yi", "yin", 
                "ying", "yo", "yong", "you", "yu", "yuan", "yue", "yun"));
        
        mm.putAll("z", Lists.newArrayList("za", "zai", "zan", "zang", "zao", "ze", "zei", 
                "zen", "zeng", "zi", "zong", "zou", "zu", "zuan", "zui", "zun", "zuo"));
        
        mm.putAll("zh", Lists.newArrayList("zha", "zhai", "zhan", "zhang", "zhao", "zhe", "zhei", "zhen", "zheng", "zhi", "zhong", "zhou", 
                "zhu", "zhua", "zhuai", "zhuan", "zhuang", "zhui", "zhun", "zhuo"));
        
        Set<String> vowelSet = Sets.newHashSet();
        
        Map<String, Collection<String>> map = mm.asMap();
        for (Map.Entry<String, Collection<String>> e : map.entrySet() ) {
            if (StringUtils.isBlank(e.getKey())) {
                vowelSet.addAll(e.getValue());
            } else {
                String consonant = e.getKey();
                System.out.println(e.getValue());
                for (String v : e.getValue()) {
                    v = StringUtils.replaceFirst(v, consonant, "");
                    vowelSet.add(v);
                }
            }
        }
        
        List<String> list = Lists.newArrayList();
        list.addAll(vowelSet);
        
        Comparator<String> cmpt = new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }};
        Collections.sort(list, cmpt);
        
        System.out.println(list);
        
    }

}

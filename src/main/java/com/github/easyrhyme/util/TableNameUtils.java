package com.github.easyrhyme.util;

import java.util.List;

import com.github.easyrhyme.bean.RhymeWord;
import com.google.common.collect.Lists;

public class TableNameUtils {
    
    private static String PREFIX = "rhyme_";

    public static String getTableName(RhymeWord rw) {
        return PREFIX + rw.getFirst();
    }

    public static List<String> getTableNames(List<String> cluster) {
        List<String> names = Lists.newArrayList();
        for (String vowel : cluster) {
            names.add(PREFIX + vowel);
        }
        return names;
    }

}

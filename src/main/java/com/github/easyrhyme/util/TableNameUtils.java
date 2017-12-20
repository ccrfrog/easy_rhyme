package com.github.easyrhyme.util;

import com.github.easyrhyme.bean.RhymeWord;

public class TableNameUtils {

    public static String getTableName(RhymeWord rw) {
        return "rhyme_" + rw.getFirst();
    }

}

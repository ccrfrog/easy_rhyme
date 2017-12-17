/*
 * $Id$
 *
 * Copyright (c) 2012 Qunar.com. All Rights Reserved.
 */
package com.github.easyrhyme.test.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;


public class GenCreateSqlTest {

    private String dropSql = "DROP TABLE IF EXISTS `rhyme_%s`; \n";
    private String createSql = "CREATE TABLE `rhyme_%s` LIKE rhyme_template; \n";
    
    List<String> vowels = Lists.newArrayList("a","e","i","o","u","ua","ue","ui","ia",
            "un","uo","ie","ei","in","ou","ai","en","iu","an","er","ao","ve",
            "iao","ian","ang","uai","eng","ing","uan","ong","iang","iong","uang");
    
    /**
     * 对每一个韵母创建一个表
     * */
    @Test
    public void test() throws Exception {
        File f = new File("src\\test\\resources\\sql\\create_vowel_tables.sql");
        BufferedWriter createFile = new BufferedWriter(new FileWriter(f));
        createFile.write("set names utf8mb4; \n");
        createFile.write("use easy_rhyme; \n");
        
        for (String v : vowels) {
            String one = String.format(dropSql, v);
            createFile.write(one);
            
            one = String.format(createSql, v);
            createFile.write(one);
        }

        createFile.close();
    }

}

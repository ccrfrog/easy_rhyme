package com.github.easyrhyme.test.util;

import static org.junit.Assert.*;


import org.junit.Test;

import com.github.easyrhyme.util.RhymeWordUtils;


public class RhymeWordUtilsTest {

    @Test
    public void test() {
        String[] pys = new String[3];
        pys[0] = "chuang";
        pys[1] = "wai";
        pys[2] = "ai";
        System.out.println(RhymeWordUtils.getVowels(pys));
    }

}

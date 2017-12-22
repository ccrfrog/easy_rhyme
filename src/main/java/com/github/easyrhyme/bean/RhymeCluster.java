package com.github.easyrhyme.bean;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * 一个 RhymeCluster 表示一个韵脚集，比如  a,ia,ua
 * */
public class RhymeCluster {

    private List<String> cluster = Lists.newArrayList();
    
    public void add(String... vs) {
        for (String vowel : vs) {
            cluster.add(vowel);
        }
    }

    public static RhymeCluster create(String... vs) {
        RhymeCluster rc = new RhymeCluster();
        rc.add(vs);
        return rc;
    }
    
}

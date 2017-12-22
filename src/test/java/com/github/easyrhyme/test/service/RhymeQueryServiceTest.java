package com.github.easyrhyme.test.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.github.easyrhyme.bean.RhymeWord;
import com.github.easyrhyme.service.RhymeQueryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-test.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
public class RhymeQueryServiceTest {
    
    @Resource
    private RhymeQueryService sut;

    @Test @Ignore
    public void test() throws Exception {
        List<RhymeWord> words = sut.singleQuery("永远", 10, 0);
        System.out.println(words);
    }
    
    @Test @Ignore
    public void testQueryDouble() throws Exception {
        List<RhymeWord> words = sut.doubleQuery("夏天", 10, 0);
        System.out.println(words);
    }
    
    @Test 
    public void testMulti() throws Exception {
        List<RhymeWord> words = sut.multiQuery("天线院", 10, 0);
        System.out.println(words);
    }

}

package com.github.easyrhyme.test.service;

import java.util.List;

import javax.annotation.Resource;

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

    @Test
    public void test() throws Exception {
        List<RhymeWord> words = sut.singleQuery("中间", 10, 0);
        System.out.println(words);
    }

}

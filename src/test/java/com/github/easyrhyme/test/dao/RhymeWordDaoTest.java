package com.github.easyrhyme.test.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.github.easyrhyme.bean.RhymeWord;
import com.github.easyrhyme.dao.RhymeWordDao;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/applicationContext-test.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
public class RhymeWordDaoTest {

    @Resource
    private RhymeWordDao dao;
    
    @Test
    public void testUpsert() {
        RhymeWord word = RhymeWord.builder("蓝天", "ian").build();
        int inserted = dao.upsert(word, "rhyme_ian");
        System.out.println(inserted);
    }

}

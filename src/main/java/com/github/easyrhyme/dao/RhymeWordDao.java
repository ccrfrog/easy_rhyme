package com.github.easyrhyme.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.github.easyrhyme.bean.RhymeWord;

@Repository
public interface RhymeWordDao {
    
    /**
     * upsert 插入一条记录，当 与 uniq_lexeme 约束冲突时 更新 freq 值 freq += 1
     * */
    public int upsert(@Param("bean") RhymeWord word, @Param("tableName") String tableName);

    /**
     * 单韵查询
     * */
    public List<RhymeWord> querySingle(@Param("firsts") List<String> firsts, 
            @Param("limit") int limit, @Param("offset") int offset, @Param("orig") String orig);

    /**
     * 双韵查询
     * */
    public List<RhymeWord> queryDouble(@Param("firsts") List<String> firsts, @Param("seconds") List<String> seconds, 
            @Param("limit") int limit, @Param("offset") int offset, @Param("orig") String orig);


    /**
     * 多韵
     * */
    public List<RhymeWord> queryMulti(@Param("firsts") List<String> firsts, @Param("seconds") List<String> seconds,
            @Param("thirds") List<String> thirds,
            @Param("limit") int limit, @Param("offset") int offset, @Param("orig") String orig);    
    
    
    
}

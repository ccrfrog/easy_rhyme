package com.github.easyrhyme.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.github.easyrhyme.bean.RhymeWord;

@Repository
public interface RhymeWordDao {
    
    /**
     * upsert 插入一条记录，当 与 uniq_lexeme 约束冲突时 更新 freq 值 freq += 1
     * */
    public int upsert(@Param("bean") RhymeWord word, @Param("tableName") String tableName);
    
    
//    public RhymeWord query
}

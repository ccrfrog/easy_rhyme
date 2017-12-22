package com.github.easyrhyme.bean.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class RhymeWordVo {
    
    private Long id;
    
    private String lexeme;
    
    private String pos;
    
    private String language;

    
    public Long getId() {
        return id;
    }

    
    public String getLexeme() {
        return lexeme;
    }

    
    public String getPos() {
        return pos;
    }

    
    public String getLanguage() {
        return language;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    
    public void setPos(String pos) {
        this.pos = pos;
    }

    
    public void setLanguage(String language) {
        this.language = language;
    }
    
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
}

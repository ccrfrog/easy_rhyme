package com.github.easyrhyme.bean;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;


/**
 * 与表 rhyme_template 记录对应
 * */
public class RhymeWord {

    private Long id;
    
    private String lexeme;
    
    private int freq;
    
    private double score;
    
    private String pos;
    
    private String language;
    
    private String first;
    
    private String second;
    
    private String third;
    
    private String fourth;
    
    private String fifth;
    
    private String sixth;
    
    private String seventh;
    
    private Date createTime;
    
    private Date updateTime;

    public RhymeWord() {}
    
    public Long getId() {
        return id;
    }

    
    public String getLexeme() {
        return lexeme;
    }

    
    public int getFreq() {
        return freq;
    }

    
    public String getPos() {
        return pos;
    }

    
    public String getLanguage() {
        return language;
    }

    
    public String getFirst() {
        return first;
    }

    
    public String getSecond() {
        return second;
    }

    
    public String getThird() {
        return third;
    }

    
    public String getFourth() {
        return fourth;
    }

    
    public String getFifth() {
        return fifth;
    }

    
    public String getSixth() {
        return sixth;
    }

    
    public String getSeventh() {
        return seventh;
    }

    
    public Date getCreateTime() {
        return createTime;
    }

    
    public Date getUpdateTime() {
        return updateTime;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }

    
    public void setFreq(int freq) {
        this.freq = freq;
    }

    
    public void setPos(String pos) {
        this.pos = pos;
    }

    
    public void setLanguage(String language) {
        this.language = language;
    }

    
    public void setFirst(String first) {
        this.first = first;
    }

    
    public void setSecond(String second) {
        this.second = second;
    }

    
    public void setThird(String third) {
        this.third = third;
    }

    
    public void setFourth(String fourth) {
        this.fourth = fourth;
    }

    
    public void setFifth(String fifth) {
        this.fifth = fifth;
    }

    
    public void setSixth(String sixth) {
        this.sixth = sixth;
    }

    
    public void setSeventh(String seventh) {
        this.seventh = seventh;
    }

    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    
    public double getScore() {
        return score;
    }


    
    public void setScore(double score) {
        this.score = score;
    }
    
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
    public static RhymeWordBuilder builder(String lexeme, String first) {
        return new RhymeWordBuilder(lexeme, first);
    }
    
    private RhymeWord(RhymeWordBuilder builder) {
        this.lexeme = builder.lexeme;
        this.first = builder.first;
        
        this.freq = builder.freq;
        this.score = builder.score;
        this.pos = builder.pos;
        this.language = builder.language;
        this.second = builder.second;
        this.third = builder.third;
        this.fourth = builder.fourth;
        this.fifth = builder.fifth;
        this.sixth = builder.sixth;
        this.seventh = builder.seventh;
        this.createTime = builder.createTime;
        this.updateTime = builder.updateTime;
    }
    
    public static class RhymeWordBuilder {
        // required
        private String lexeme;
        private String first;
        
        // optional
        private int freq = 1;
        private double score = 1.0;
        private String pos = "";
        private String language = "CN";
        private String second = "";
        private String third = "";
        private String fourth = "";
        private String fifth = "";
        private String sixth = "";
        private String seventh = "";
        private Date createTime = new Date();
        private Date updateTime = new Date();
        
        public RhymeWord build() {
            return new RhymeWord(this);
        }
        
        public RhymeWordBuilder(String lexeme, String first) {
            this.lexeme = lexeme;
            this.first = first;
        }

        public RhymeWordBuilder updateTime(Date updateTime) {
            this.updateTime = updateTime;
            return this;
        }
        
        public RhymeWordBuilder createTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }
        
        public RhymeWordBuilder freq(int freq) {
            this.freq = freq;
            return this;
        }
        
        public RhymeWordBuilder score(double score) {
            this.score = score;
            return this;
        }
        
        public RhymeWordBuilder second(String second) {
            this.second = second;
            return this;
        }
        
        public RhymeWordBuilder third(String third) {
            this.third = third;
            return this;
        }
        
        public RhymeWordBuilder fourth(String fourth) {
            this.fourth = fourth;
            return this;
        }
        
        public RhymeWordBuilder fifth(String fifth) {
            this.fifth = fifth;
            return this;
        }
        
        public RhymeWordBuilder sixth(String sixth) {
            this.sixth = sixth;
            return this;
        }
        
        public RhymeWordBuilder seventh(String seventh) {
            this.seventh = seventh;
            return this;
        }
    }
    
}

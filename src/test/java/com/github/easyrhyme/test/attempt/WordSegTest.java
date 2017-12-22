package com.github.easyrhyme.test.attempt;

import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;


//--------------------- Change Logs----------------------
// <p>@author dengziqiang Initial Created at 2017年12月14日<p>
//-------------------------------------------------------
public class WordSegTest {
    
    
    @Test
    public void testLyrics() throws Exception {
        // 构建IK分词器，使用smart分词模式
        Analyzer analyzer = new IKAnalyzer(true);

        // 获取Lucene的TokenStream对象
        TokenStream ts = null;
        ts = analyzer.tokenStream("myfield",
                new StringReader("在水里 在火里 我的爱不偏不倚 就算时光倒回去 我也追到石器世纪 在风里 在雨里 你的雨伞吹翻过去 我绝对毫不犹豫 为你披上我的外衣 是你让我看透生命这东西 四个字 坚持到底 如果没有你 我的生活回到一片狼藉"));
        // 获取词元位置属性
        OffsetAttribute offset = ts.addAttribute(OffsetAttribute.class);
        // 获取词元文本属性
        CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
        // 获取词元文本属性
        TypeAttribute type = ts.addAttribute(TypeAttribute.class);

        // 重置TokenStream（重置StringReader）
        ts.reset();
        // 迭代获取分词结果
        while (ts.incrementToken()) {
            System.out.println(
                    offset.startOffset() + " - " + offset.endOffset() + " : " + term.toString() + " | " + type.type());
        }
        // 关闭TokenStream（关闭StringReader）
        ts.end(); // Perform end-of-stream operations, e.g. set the final offset.
        
        
    }
    
    @Test
    public void testIKAnalyzer() throws Exception {
        // 构建IK分词器，使用smart分词模式
        Analyzer analyzer = new IKAnalyzer(true);

        // 获取Lucene的TokenStream对象
        TokenStream ts = null;
        ts = analyzer.tokenStream("myfield",
                new StringReader("菁菁者莪，在彼中阿。既见君子，乐且有仪。 菁菁者莪，在彼中沚。既见君子，我心则喜。 菁菁者莪，在彼中陵。既见君子，锡我百朋。 泛泛杨舟，载沉载浮。既见君子，我心则休。"));
        // 获取词元位置属性
        OffsetAttribute offset = ts.addAttribute(OffsetAttribute.class);
        // 获取词元文本属性
        CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);
        // 获取词元文本属性
        TypeAttribute type = ts.addAttribute(TypeAttribute.class);

        // 重置TokenStream（重置StringReader）
        ts.reset();
        // 迭代获取分词结果
        while (ts.incrementToken()) {
            System.out.println(
                    offset.startOffset() + " - " + offset.endOffset() + " : " + term.toString() + " | " + type.type());
        }
        // 关闭TokenStream（关闭StringReader）
        ts.end(); // Perform end-of-stream operations, e.g. set the final offset.
        
        
    }
    

}

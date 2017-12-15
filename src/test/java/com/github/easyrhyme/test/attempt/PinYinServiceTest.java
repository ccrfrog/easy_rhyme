package com.github.easyrhyme.test.attempt;

import org.junit.Test;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;



//--------------------- Change Logs----------------------
// <p>@author dengziqiang Initial Created at 2017年12月15日<p>
//-------------------------------------------------------
public class PinYinServiceTest {

    @Test
    public void test() throws PinyinException {
        System.out.println(PinyinHelper.convertToPinyinString("携程旅行网 押韵 查询app 核武器 歌舞伎 寒武纪 大十烂儿", ",", PinyinFormat.WITHOUT_TONE));
        
    }

}

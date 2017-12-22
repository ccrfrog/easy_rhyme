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
        System.out.println(PinyinHelper.convertToPinyinString("绝学 good job", ",", PinyinFormat.WITHOUT_TONE));
        
    }

}

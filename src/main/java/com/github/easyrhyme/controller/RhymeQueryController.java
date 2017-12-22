package com.github.easyrhyme.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.easyrhyme.bean.RhymeWord;
import com.github.easyrhyme.bean.vo.RhymeWordVo;
import com.github.easyrhyme.service.RhymeQueryService;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;


@Controller
@RequestMapping("/query")
public class RhymeQueryController extends AbstractController {
    
    private static Logger logger = LoggerFactory.getLogger(RhymeQueryController.class);
    
    @Resource
    private RhymeQueryService rhymeQueryService;
    
    @ResponseBody
    @RequestMapping("/single.json")
    public Map<String, Object> singleQuery(@RequestParam("q") String q,
            @RequestParam(value = "limit", defaultValue = "30") int limit,
            @RequestParam(value = "offset", defaultValue = "0") int offset) throws Exception {
        
        logger.info("singleQuery, q={}, limit={}, offset={}", q, limit, offset);
        Preconditions.checkArgument(limit <= 100, "limit 必须小于100");
        // q 必须是中文字符
        
        List<RhymeWordVo> vos = convertToVo(rhymeQueryService.singleQuery(q, limit, offset));
        return dataJson(vos);
    }
    
    @ResponseBody
    @RequestMapping("/multi.json")
    public Map<String, Object> multiQuery(@RequestParam("q") String q) {
        
        return null;
    }
    
    private List<RhymeWordVo> convertToVo(List<RhymeWord> words) {
        List<RhymeWordVo> r = Lists.newArrayList();
        if (CollectionUtils.isEmpty(words)) {
            return r;
        }
        for (RhymeWord word : words) {
            RhymeWordVo vo = new RhymeWordVo();
            vo.setId(word.getId());
            vo.setLanguage(word.getLanguage());
            vo.setLexeme(word.getLexeme());
            vo.setPos(word.getPos());
            r.add(vo);
        }
        
        return r;
    }
    
}

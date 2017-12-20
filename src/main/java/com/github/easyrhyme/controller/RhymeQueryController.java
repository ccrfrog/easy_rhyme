package com.github.easyrhyme.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.easyrhyme.bean.RhymeWord;
import com.github.easyrhyme.service.RhymeQueryService;


@Controller
@RequestMapping("/query")
public class RhymeQueryController extends AbstractController {
    
    private static Logger logger = LoggerFactory.getLogger(RhymeQueryController.class);
    
    @Resource
    private RhymeQueryService rhymeQueryService;
    
    @ResponseBody
    @RequestMapping("/single.json")
    public Map<String, Object> singleQuery(@RequestParam("q") String q) {
        logger.info("q={}", q);
        return dataJson(RhymeWord.builder("蓝天", "ian").build());
    }
    
    @ResponseBody
    @RequestMapping("/multi.json")
    public Map<String, Object> multiQuery(@RequestParam("q") String q) {
        return null;
    }
    

}

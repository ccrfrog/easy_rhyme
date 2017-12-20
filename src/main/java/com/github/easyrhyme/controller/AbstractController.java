package com.github.easyrhyme.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AbstractController {

    protected final Logger logger = LoggerFactory.getLogger(AbstractController.class);

    protected static final String DEFAULT_PAGE = "1";

    protected static final int DEFAULT_PAGE_SIZE = 30;

    protected static final int DEFULT_SUGGEST_SIZE = 10;

    protected static final String START = "0";

    protected static final String LIMIT = "20";

    private Map<String, Object> data(Object... data) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        if (data.length % 2 != 0) {
            throw new IllegalArgumentException("parameter count must be even");
        }
        for (int i = 0; i < data.length; i += 2) {
            map.put(String.valueOf(data[i]), data[i + 1]);
        }
        return map;
    }

    protected Map<String, Object> dataJson(Object data) {
        return data("ver", 1, "ret", true, "data", data);
    }

    protected Map<String, Object> errorJson(Object message) {
        return data("ver", 1, "ret", false, "errmsg", message);
    }

    protected Map<String, Object> dataFormJson(Object data) {
        return data("ver", 1, "ret", true, "data", data, "success", true);
    }

    protected Map<String, Object> errorFormJson(Object message) {
        return data("ver", 1, "ret", false, "errmsg", message, "success", false);
    }

    protected Map<String, Object> errorJson(Object message, Object errcode) {
        return data("ver", 1, "ret", false, "errmsg", message, "errcode", errcode);
    }
    
}

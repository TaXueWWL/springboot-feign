package com.snowalker.springboot.feignclient.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.snowalker.springboot.feignclient.entity.DemoResp;
import com.snowalker.springboot.feignclient.entity.ResponseData;
import com.snowalker.springboot.feignclient.integration.FeignClientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author snowalker
 * @version 1.0
 * @date 2019/7/24 16:44
 * @className FeignDemoController
 * @desc
 */
@Controller
@RequestMapping("/demo")
public class FeignDemoController {

    @Autowired
    FeignClientProxy feignClientProxy;

    @RequestMapping(value = "feign")
    @ResponseBody
    public String testFeign(@RequestParam(name = "name") String name) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ResponseData<DemoResp> respResponseBody = feignClientProxy.invoke(name);
        return "调用结果:" + objectMapper.writeValueAsString(respResponseBody);

    }
}

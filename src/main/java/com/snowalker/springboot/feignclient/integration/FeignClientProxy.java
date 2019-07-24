package com.snowalker.springboot.feignclient.integration;

import com.snowalker.springboot.feignclient.entity.DemoResp;
import com.snowalker.springboot.feignclient.entity.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author snowalker
 * @version 1.0
 * @date 2019/7/24 16:39
 * @className FeignClient
 * @desc
 */
@FeignClient(name = "feignClientProxy",url = "http://wuwenliang.net/samples/")
public interface FeignClientProxy {

    @RequestMapping(value = "/snowalker.json", method = RequestMethod.GET)
    @ResponseBody
    ResponseData<DemoResp> invoke(@RequestParam(value="name") String name);

    /**
     * 容错处理类，当调用失败时 返回空字符串
     */
    @Component
    class DefaultFallback implements FeignClientProxy {
        @Override
        public ResponseData<DemoResp> invoke(@RequestParam(value="snowalker") String name){
            return new ResponseData<DemoResp>().setCode("40004").setDesc("服务异常").setData(null);
        }
    }
}

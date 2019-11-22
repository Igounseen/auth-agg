package com.swx.auth.order.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shiwenxiang
 * @date 2019/11/22
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @GetMapping(value = "/num")
    public JSONObject getOrder(Long id) {
        log.info("---getOrder---");
        JSONObject json = new JSONObject();
        json.put("order", "" + id);
        return json;
    }

}

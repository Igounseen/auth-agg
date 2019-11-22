package com.swx.auth.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author shiwenxiang
 * @date 2019/11/22
 */

@FeignClient(value = "auth-order")
public interface OrderClient {

    @GetMapping(value = "/auth-order/order/num")
    Object getOrder(@RequestHeader(name = "json-token") String jsonToken);

}

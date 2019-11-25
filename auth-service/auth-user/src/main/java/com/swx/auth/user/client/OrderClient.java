package com.swx.auth.user.client;

import com.swx.auth.user.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * @author shiwenxiang
 * @date 2019/11/22
 */

@FeignClient(value = "auth-order", configuration = FeignConfiguration.class)
public interface OrderClient {

    @GetMapping(value = "/auth-order/order/num")
    Object getOrder();

}

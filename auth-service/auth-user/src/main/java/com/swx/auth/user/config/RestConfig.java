package com.swx.auth.user.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiwenxiang
 * @date 2019/11/22
 */
@Configuration
public class RestConfig {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
  //      restTemplate.getMessageConverters().add(new CustomerMappingJackson2HttpMessageConverter());
        return restTemplate;
    }
//
//    public class CustomerMappingJackson2HttpMessageConverter extends MappingJackson2HttpMessageConverter {
//        public CustomerMappingJackson2HttpMessageConverter() {
//            List<MediaType> mediaTypes = new ArrayList<>();
//            mediaTypes.add(MediaType.TEXT_PLAIN);
//            mediaTypes.add(MediaType.TEXT_HTML);
//            setSupportedMediaTypes(mediaTypes);
//        }
//    }

}

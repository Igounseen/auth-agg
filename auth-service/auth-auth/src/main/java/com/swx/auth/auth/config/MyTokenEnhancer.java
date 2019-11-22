package com.swx.auth.auth.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.swx.auth.auth.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shiwenxiang
 * @date 2019/11/20
 */
@Slf4j
public class MyTokenEnhancer implements TokenEnhancer {

    private List<TokenEnhancer> delegates = Collections.emptyList();

    public void setTokenEnhancers(List<TokenEnhancer> delegates) {
        this.delegates = delegates;
    }

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        OAuth2AccessToken result = accessToken;
        for (TokenEnhancer enhancer : delegates) {
            result = enhancer.enhance(result, authentication);
        }
        Map<String, Object> map = new HashMap<>(16);
        User user = (User) authentication.getPrincipal();
        UserDto userDto = JSONObject.parseObject(user.getUsername(), UserDto.class);
        map.put("id", userDto.getId());
        map.put("username", userDto.getUsername());
        ((DefaultOAuth2AccessToken) result).setAdditionalInformation(map);
        return result;
    }

}

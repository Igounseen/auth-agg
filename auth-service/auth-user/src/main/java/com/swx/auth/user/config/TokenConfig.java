package com.swx.auth.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author shiwenxiang
 * @date 2019/11/13
 */
@Configuration
public class TokenConfig {

    /**
     * 对称密钥
     */
    private String SIGN_KEY = "sign123";

    /**
     * 令牌存储策略
     *
     * @return
     */
    @Bean
    public TokenStore tokenStore() {
        // 生成JWT令牌
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        // 对称密钥，资源服务器使用该密钥来认证
        converter.setSigningKey(SIGN_KEY);
        return converter;
    }

}

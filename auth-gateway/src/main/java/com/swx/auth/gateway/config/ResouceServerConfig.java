package com.swx.auth.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author shiwenxiang
 * @date 2019/11/18
 */
@Configuration
public class ResouceServerConfig {

    public static final String RESOURCE_ID = "res1";
    public static final String RESOURCE_ID2 = "res2";

    @Configuration
    @EnableResourceServer
    public static class AuthServerConfig extends ResourceServerConfigurerAdapter {

        @Autowired
        private TokenStore tokenStore;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources
                    .tokenStore(tokenStore)
                    .resourceId(RESOURCE_ID)
                    .stateless(true);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/auth-auth/**").permitAll();
        }
    }


    @Configuration
    @EnableResourceServer
    public static class UserServerConfig extends ResourceServerConfigurerAdapter {

        @Autowired
        private TokenStore tokenStore;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
            resources
                    // 资源ID
                    .resourceId(RESOURCE_ID2)
                    .tokenStore(tokenStore)
                    .stateless(true);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/auth-user/register/**").permitAll()
                    .antMatchers("/auth-user/**").authenticated();

        }
    }
}
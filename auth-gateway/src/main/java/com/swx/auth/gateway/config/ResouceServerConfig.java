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

    public static final String RESOURCE_USER = "user";
    public static final String RESOURCE_BUSINESS = "business";

    @Configuration
    @EnableResourceServer
    public static class AuthServerConfig extends ResourceServerConfigurerAdapter {

        @Autowired
        private TokenStore tokenStore;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources
                    .tokenStore(tokenStore)
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
                    .resourceId(RESOURCE_USER)
                    .tokenStore(tokenStore)
                    .stateless(true);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                    .antMatchers("/auth-user/register/**", "/auth-user/error").permitAll()
                    .antMatchers("/auth-user/**").authenticated();

        }


        @Configuration
        @EnableResourceServer
        public static class OrderServerConfig extends ResourceServerConfigurerAdapter {

            @Autowired
            private TokenStore tokenStore;

            @Override
            public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
                resources
                        // 资源ID
                        .tokenStore(tokenStore)
                        .stateless(true);
            }

            @Override
            public void configure(HttpSecurity http) throws Exception {
                http
                        .authorizeRequests()
                        .antMatchers("/auth-order/**").authenticated();
            }

        }
    }
}
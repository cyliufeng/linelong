package com.linelong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class LineLongCorsFilterConfiguration {

    @Bean
    public CorsFilter corsFilter(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //配置可以跨域访问的地址
        corsConfiguration.addAllowedOrigin("http://manage.linelong.cn");
        //允许携带cookie
        corsConfiguration.setAllowCredentials(true);
        //允许所有方式跨域
        corsConfiguration.addAllowedMethod("*");
        //携带的头信息
        corsConfiguration.addAllowedHeader("*");
        //配置源
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        // /**拦截所有路径
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

}

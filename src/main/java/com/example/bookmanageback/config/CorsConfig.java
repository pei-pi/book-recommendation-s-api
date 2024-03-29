package com.example.bookmanageback.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")  //允许跨域访问的路径
                .allowedOrigins("http://localhost:9528","http://127.0.0.1:5173","http://localhost:8080","http://192.168.0.100:8080/") //允许跨域访问的源
                .allowedMethods("POST","GET","PUT","OPTIONS","DELETE")
                .maxAge(168000)  //预检间隔时间
                .allowedHeaders("*")  //允许头部设置
                .allowCredentials(true);  //是否发送cookie
    }
}

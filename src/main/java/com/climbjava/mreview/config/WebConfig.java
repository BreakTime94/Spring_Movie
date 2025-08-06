//package com.climbjava.mreview.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//  // 1. Swagger 정적 리소스를 직접 매핑
//  @Override
//  public void addResourceHandlers(ResourceHandlerRegistry registry) {
//    registry.addResourceHandler("/swag")  // swagger-ui 내 js/css/img
//            .addResourceLocations("classpath:/META-INF/resources/webjars/swagger-ui/5.21.0/");
//
//    registry.addResourceHandler("/swag")  // swagger-ui가 내부적으로 사용하는 공통 js/css
//            .addResourceLocations("classpath:/META-INF/resources/webjars/");
//
//  }
//
//  // 2. /swag → forward:/swagger-ui/index.html (주소 유지)
//  @Override
//  public void addViewControllers(ViewControllerRegistry registry) {
//    registry.addViewController("/swag")
//            .setViewName("forward:/swagger-ui/5.21.0/index.html");
//  }
//}
//

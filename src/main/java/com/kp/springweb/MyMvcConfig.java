package com.kp.springweb;

import com.kp.springweb.converter.MyHttpMessageConvertor;
import com.kp.springweb.interceptors.DemoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan("com.kp.springweb")/*扫描基础包*/
public class MyMvcConfig implements WebMvcConfigurer {
    /*配置能解析jsp的类*/
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/classes/views/");/*页面文件存放位置*/
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    /*配置静态资源处理*/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");//类路径
        System.out.println("==============11=");
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
        System.out.println("=============22=");
    }

    /*配置拦截器*/
    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }

    /*注册拦截器*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor()).excludePathPatterns("/assets/**", "/static/**");
    }

    //快捷控制器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/home").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/toUpload").setViewName("upload");//WEB-INF/classes/views下面的
        registry.addViewController("/converter").setViewName("converter");
    }

    /*//解决路径中.后面内容不识别问题
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false);
    }*/
    /*配置上传文件解析器*/
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxInMemorySize(10240000);//上传文件大小 1mb
        return resolver;
    }

    //注册消息转换器
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(myHttpMessageConvertor());
    }

    @Bean
    public MyHttpMessageConvertor myHttpMessageConvertor() {
        return new MyHttpMessageConvertor();
    }
}

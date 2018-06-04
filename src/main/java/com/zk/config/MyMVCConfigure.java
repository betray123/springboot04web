package com.zk.config;

import com.zk.component.LoginHandlerInterceptor;
import com.zk.component.MylocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * Created by zk on 18/6/3.
 */


//使用WebMvcConfigurerAdapter可以扩展springmvc功能
//@EnableWebMvc    用来解除springboot对springmvc的默认配置
@Configuration
public class MyMVCConfigure extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        //浏览器发送  /zk请求,请求重定向到success
        registry.addRedirectViewController("/zk","success");
    }

    //所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean //将组件注入容器
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/dashboard.html").setViewName("dashboard");
            }

            //注册拦截器组件
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                super.addInterceptors(registry);
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/index.html","/user/login");
            }
        };
        return adapter;
    }

    //将自己写的国际化配置类加入容器
    @Bean
    public LocaleResolver localeResolver(){
        return new MylocaleResolver();
    }
}

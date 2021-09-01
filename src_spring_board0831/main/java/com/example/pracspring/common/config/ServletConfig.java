package com.example.pracspring.common.config;

import com.example.pracspring.common.converter.StringToLocalDateTimeConverter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc//스프링 프레임워크에서 사용하면 여러 Config 값을 알아서 세팅해 줌
public class ServletConfig implements WebMvcConfigurer {

    @Override//localdatetime 쓰기 위해 추가
   public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToLocalDateTimeConverter());
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        registry.viewResolver(bean);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        //"/resources/**" webapp 밑에 있는 resources 폴더는 스프링으로 영향 주지 않겠다: 여기에 이미지 넣기
    }

}

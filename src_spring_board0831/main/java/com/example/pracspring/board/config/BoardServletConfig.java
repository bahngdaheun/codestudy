package com.example.pracspring.board.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@ComponentScan(basePackages = "com.example.pracspring.board.controller")
public class BoardServletConfig implements WebMvcConfigurer {


}

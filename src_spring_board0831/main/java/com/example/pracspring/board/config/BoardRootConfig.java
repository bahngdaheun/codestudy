package com.example.pracspring.board.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//객체 생성
@MapperScan(basePackages = "com.example.pracspring.board.mapper")
@ComponentScan(basePackages = "com.example.pracspring.board.service")
public class BoardRootConfig {

}

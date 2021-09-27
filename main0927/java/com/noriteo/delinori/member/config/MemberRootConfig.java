package com.noriteo.delinori.member.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.noriteo.delinori.member.mapper")
@ComponentScan(basePackages = "com.noriteo.delinori.member.service")
public class MemberRootConfig {
}

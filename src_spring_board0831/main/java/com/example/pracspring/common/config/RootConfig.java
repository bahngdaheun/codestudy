package com.example.pracspring.common.config;

import com.example.pracspring.board.config.BoardRootConfig;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.*;
import org.mybatis.spring.SqlSessionFactoryBean;//spring과 mybatis 연결을 쉽게 해 주는 도구
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ArrayList;

@Configuration//자바 소스를 빈(객체)으로 만들어주는 기능
@Import(BoardRootConfig.class)//WebConfig에 쓰는 대신에 여기 적으면 좀 더 편함
//동시에 같이 로딩함
public class RootConfig {

    @Bean//책 92쪽보다 훨씬 간편하게 MyBatis 설정함
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        //sqlsessionfactory는 mybatis거임: sqlsessionfactorybean이 도와줌
        //mapper 세팅도 어노테이션만 추가하면 됨
        SqlSessionFactoryBean sqlSessionFactoryBean =new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

        return sqlSessionFactoryBean.getObject();
    }

    @Bean//(destroyMethod = "close"): 커넥션 풀을 종료하는 것으로 안전하게 하려면 하는 게 좋음
    //싱글톤이라 한 번밖에 로딩 안 함, 예전에 enum 쓰던 것
    public DataSource dataSource() {//DB와 연결
        HikariConfig config=new HikariConfig();//커넥션 풀
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/bit08db");
        config.setUsername("practiceuser");
        config.setPassword("practiceuser");

        HikariDataSource dataSource=new HikariDataSource(config);
        return dataSource;
    }

    @Bean(name = "names")//소스 코드가 없어서 어노테이션 못 쓰고 직접 빈 생성, 메소드 이름과 맞춰서 name 설정
    public ArrayList<String> names(){//메소드 이름을 명사로 적어야 함
        ArrayList<String> list=new ArrayList<>();
        list.add("AAA");
        list.add("BBB");
        list.add("CCC");
        return list;
    }
}

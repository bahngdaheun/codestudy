package com.example.pracspring.common.config;

import com.example.pracspring.board.config.BoardRootConfig;
import com.example.pracspring.board.config.BoardServletConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Log4j2
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
//web.xml 대신 사용하는 것
    @Override
    protected Class<?>[] getRootConfigClasses() {//루트 설정
        log.info("1----------");//정상적으로 동작하면 설정 파일이 로딩이 될 거고 그럼 로그가 찍힐 것
        log.info("1----------");
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {//서블릿 설정
        log.info("2----------");
        log.info("2----------");
        return new Class[]{ServletConfig.class, BoardServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {//프론트 컨트롤러
        return new String[]{"/"};
        //처음 접속하면 모두 프론트 컨트롤러로 들어오게 할 건데 아직 프론트 컨트롤러가 없어서 주소 미완성
    }

    @Override
    protected Filter[] getServletFilters() {//필터의 배열 반환
        //get 방식은 처리가 안 될 수 있음, post 방식에 적용
        CharacterEncodingFilter utf8filter=new CharacterEncodingFilter();
        utf8filter.setEncoding("UTF-8");
        utf8filter.setForceEncoding(true);

        return new Filter[]{utf8filter};
    }
}

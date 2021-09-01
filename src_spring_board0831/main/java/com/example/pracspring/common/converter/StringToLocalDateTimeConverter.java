package com.example.pracspring.common.converter;

import lombok.extern.log4j.Log4j2;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@Log4j2
public class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {

    @Override
    public LocalDateTime convert(String source) {

        log.info("-----------");
        log.info("convert: "+source);

        Pattern pattern=Pattern.compile("^((19|20)\\d\\d)?([- /.])?(0[1-9]|1[012])([- /.])?(0[1-9]|[12][0-9]|3[01])$");
        Matcher matcher= pattern.matcher(source);

        if(matcher.find()){
            return LocalDateTime.parse(
                    source+"T00:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }
        //source 뒤에가 시간, 분까지만 있을 수도 있고 날짜값만 있을 수 있어서 if ~ else 필요
        //정규 표현식 사용: 어떤 문자열이 이메일 주소인지 아닌지 파악하는 것(@, .이 들어가 있는지 확인)
        //날짜 형식이 맞게 됐는지 확인: 문자열이 길면 맞고 짧으면 넘어감
        return LocalDateTime.now();//시분초 안 주면 현재 시간을 찍는다
    }
}

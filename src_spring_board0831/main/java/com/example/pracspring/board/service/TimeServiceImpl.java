package com.example.pracspring.board.service;

import com.example.pracspring.board.mapper.TimeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor//객체에 의존성 주입
public class TimeServiceImpl implements TimeService {//실질적으로 구현하는 클래스
    //TimeService를 상속받아서 사용하므로 클래스명이 TimeServiceImpl

    private final TimeMapper timeMapper;//@RequiredArgsConstructor 쓰면 final로 선언 가능

    @Override
    public String getNow() {
        log.info("service....getNow()");

        return timeMapper.getTime2();
    }
}

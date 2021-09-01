package com.example.pracspring.board.mapper;

import com.example.pracspring.board.config.BoardRootConfig;
import com.example.pracspring.common.config.RootConfig;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {BoardRootConfig.class, RootConfig.class})
//BoardRootConfig도 RootConfig 설정을 받아서 이용하기 때문에 2개 클래스를 모두 적어야 함
//RootConfig는 공통으로 사용하는 설정이기 때문에 다른 패키지 쓸 때도 항상 같이 써야 함
public class TimeMapperTests {

    @Autowired
    TimeMapper timeMapper;

    @Test
    public void testGetTime(){
        log.info("----------");
        log.info("----------");
        log.info(timeMapper.getTime2());
        log.info("----------");
        log.info("----------");
    }
}

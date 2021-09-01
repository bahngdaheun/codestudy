package com.example.pracspring.board.mapper;

import com.example.pracspring.board.config.BoardRootConfig;
import com.example.pracspring.board.domain.Board;
import com.example.pracspring.common.config.RootConfig;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.IntStream;

@Log4j2
@ExtendWith(SpringExtension.class)//해당 코드가 스프링을 실행한다고 알려줌
@ContextConfiguration(classes = {BoardRootConfig.class, RootConfig.class})
//지정된 클래스나 문자열을 이용해서 필요한 객체 등록: 스프링의 빈으로 등록된다고도 표현
public class BoardMapperTests {

    @Autowired
    BoardMapper boardMapper;

    @Test
    public void testDummies(){
        IntStream.rangeClosed(1,100).forEach(i->{
            Board board= Board.builder()
                    .title("title"+i)
                    .content("content"+i)
                    .writer("user"+(i%10))
            .build();

            boardMapper.insert(board);
        });
    }

}

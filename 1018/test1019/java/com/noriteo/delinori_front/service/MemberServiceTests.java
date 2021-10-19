package com.noriteo.delinori_front.service;

//import com.noriteo.delinori_front.dto.MemberBoardDTO;
import com.noriteo.delinori_front.dto.MemberDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class MemberServiceTests {

    @Autowired
    private MemberService memberService;

    @Test
    public void testRegister() {
        IntStream.rangeClosed(100, 223).forEach(i-> {
            MemberDTO memberDTO=MemberDTO.builder()
                    .mid("nori"+i)
                    .mname("노리"+i)
                    .mpw("nori"+i)
                    .maddress("서울시 종로구 종로"+i)
                    .memail("nori"+i+"@delinori.com")
                    .mphone("010-"+i+"07"+i+"-28"+i+"3")
                    .build();
            String mid=memberService.register(memberDTO);
            log.info("MID: "+mid);
        });
    }

    @Test
    public void testModify() {
        MemberDTO memberDTO=MemberDTO.builder().mid("nori1").maddress("서울시 강남구 역삼동")
                .mphone("010-1234-5678").build();
        memberService.modify(memberDTO);
    }

//    @Test
//    public void insertdummies() {
//        String query="insert into tbl_board (title, writer, content) values ('v1', 'v2', 'v3');";
//        for(int i=4; i<127; i++){
//            String title="title.."+i;
//            String writer="nori"+i;
//            String content="content.."+i;
//
//            String result=query;
//
//            result=result.replace("v1", title);
//            result=result.replace("v2", writer);
//            result=result.replace("v3", content);
//
//            System.out.println(result);
//        }
//    }

}

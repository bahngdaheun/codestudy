package com.noriteo.delinori.member.mapper;

import com.noriteo.delinori.common.config.RootConfig;
import com.noriteo.delinori.common.dto.PageRequestDTO;
import com.noriteo.delinori.member.config.MemberRootConfig;
import com.noriteo.delinori.member.domain.Member;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.IntStream;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration( classes = {MemberRootConfig.class, RootConfig.class})
public class MemberMapperTests {

    @Autowired
    MemberMapper memberMapper;

    @Test
    public void testDummies() {

        IntStream.rangeClosed(1,10).forEach(i -> {
            Member member= Member.builder()
                    .mid("deli"+i)
                    .mname("mname"+i)
                    .mpw("mpw"+i)
                    .maddress("maddress"+i)
                    .memail("memail"+i)
                    .mphone("mphone"+i)
                    .build();

            memberMapper.insert(member);
        });

    }

    @Test
    public void testList(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();

        log.info(pageRequestDTO);

        memberMapper.getList(pageRequestDTO).forEach(member -> {log.info(member);});
    }

    @Test
    public void testSelect(){
        Member member=memberMapper.select("mid9");
        log.info("==============");
        log.info(member);
    }

    @Test
    public void testDelete(){
        String mid = "mid9";

        log.info("=======delete test=======");
        log.info(memberMapper.delete(mid));
    }
}

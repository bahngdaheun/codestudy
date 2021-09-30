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
    public void testDummiesDeli() {
        IntStream.rangeClosed(1, 106).forEach(i -> {
            Member member= Member.builder()
                    .mid("deli"+i)
                    .mname("mname"+i)
                    .mpw("mpw"+i)
                    .maddress("maddress"+i)
                    .memail("memail"+i)
                    .mphone("mphone"+i)
                    .build();

            memberMapper.insertDeli(member);
        });
    }

    @Test
    public void testDummiesNori() {
        IntStream.rangeClosed(1, 223).forEach(i -> {
            Member member= Member.builder()
                    .mid("nori"+i)
                    .mname("mname"+i)
                    .mpw("mpw"+i)
                    .maddress("maddress"+i)
                    .memail("memail"+i)
                    .mphone("mphone"+i)
                    .build();

            memberMapper.insertNori(member);
        });
    }

    @Test
    public void testListDeli(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();
        log.info(pageRequestDTO);
        memberMapper.getListDeli(pageRequestDTO).forEach(member -> {log.info("deli "+member);});
    }

    @Test
    public void testListNori(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder().build();
        log.info(pageRequestDTO);
        memberMapper.getListNori(pageRequestDTO).forEach(member -> {log.info("nori "+member);});
    }

    @Test
    public void testSelectDeli(){
        Member member=memberMapper.selectDeli("deli9");
        log.info("====deli====");
        log.info(member);
    }

    @Test
    public void testSelectNori(){
        Member member=memberMapper.selectNori("nori9");
        log.info("====nori====");
        log.info(member);
    }

    @Test
    public void testDeleteDeli(){
        String mid = "deli9";
        log.info("====delete test deli====");
        log.info(memberMapper.deleteDeli(mid));
    }

    @Test
    public void testDeleteNori(){
        String mid = "nori9";
        log.info("====delete test nori====");
        log.info(memberMapper.deleteNori(mid));
    }
}

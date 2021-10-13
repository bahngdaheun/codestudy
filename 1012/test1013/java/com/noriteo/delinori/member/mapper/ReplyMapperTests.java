package com.noriteo.delinori.member.mapper;

import com.noriteo.delinori.common.config.RootConfig;
import com.noriteo.delinori.member.config.MemberRootConfig;
import com.noriteo.delinori.member.domain.Reply;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.IntStream;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MemberRootConfig.class, RootConfig.class})
public class ReplyMapperTests {

    @Autowired(required = false)
    ReplyMapper replyMapper;

    @Test
    public void insertDummies(){
        String[] arr={"nori99", "nori98", "nori97", "nori96", "nori95"};
        IntStream.rangeClosed(1,100).forEach(num->{
            String mid=arr[((int)(Math.random()*1000))%5];
            Reply reply= Reply.builder()
                    .mid(mid)
                    .reply("댓글..."+num)
                    .replyer("admin"+(num%5+1))
                    .build();
            replyMapper.insert(reply);
        });
    }

    @Test
    public void testList(){
        String mid="nori99";
        replyMapper.getListWithMember(mid).forEach(reply -> log.info(reply));
    }
}

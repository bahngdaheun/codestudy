package com.noriteo.delinori_front.repository;

//import com.noriteo.delinori_front.dto.MemberBoardDTO;
import com.noriteo.delinori_front.dto.MemberDTO;
import com.noriteo.delinori_front.entity.Member;
//import com.noriteo.delinori_front.entity.MemberBoard;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;

@SpringBootTest
@Log4j2
public class BoardRepositoryTests {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private ModelMapper modelMapper;

//    @Test
//    public void testSearch1() {
//
//        char[] typeArr=null;
//        String keyword=null;
//        Pageable pageable=PageRequest.of(0, 10, Sort.by("bno").descending());
//
//        Page<MemberBoard> result=memberRepository.search1(typeArr, keyword, pageable);
//
//        result.get().forEach(memberBoard -> {
//            log.info(memberBoard);
//            log.info("--------------");
//
//            MemberBoardDTO memberBoardDTO=modelMapper.map(memberBoard, MemberBoardDTO.class);//board를 BoardDTO.class로 바꾼다
//            log.info(memberBoardDTO);
//        });
//    }

}

package com.noriteo.delinori_front.service;

//import com.noriteo.delinori_front.dto.MemberBoardDTO;
import com.noriteo.delinori_front.dto.MemberDTO;
import com.noriteo.delinori_front.dto.MemberPageRequestDTO;
import com.noriteo.delinori_front.dto.MemberPageResponseDTO;
import com.noriteo.delinori_front.entity.Member;
//import com.noriteo.delinori_front.entity.MemberBoard;
import com.noriteo.delinori_front.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final ModelMapper modelMapper;
    private final MemberRepository memberRepository;

    @Override
    public String register(MemberDTO memberDTO) {
        Member member=modelMapper.map(memberDTO, Member.class);
        memberRepository.save(member);
        return member.getMid();
    }

//    @Override
//    public MemberPageResponseDTO<MemberBoardDTO> getList(MemberPageRequestDTO memberPageRequestDTO) {
//        char[] typeArr=memberPageRequestDTO.getTypes();
//        String keyword=memberPageRequestDTO.getKeyword();
//        Pageable pageable= PageRequest.of(
//                memberPageRequestDTO.getPage()-1,
//                memberPageRequestDTO.getSize(),
//                Sort.by("bno").descending());
//        Page<MemberBoard> result=memberRepository.search1(typeArr, keyword, pageable);
//        List<MemberBoardDTO> dtoList=result.get().map(memberBoard -> modelMapper.map(memberBoard, MemberBoardDTO.class))
//                .collect(Collectors.toList());
//
//        long totalCount=result.getTotalElements();
//        return new MemberPageResponseDTO<>(memberPageRequestDTO, (int)totalCount, dtoList);
//    }

    @Override
    public MemberDTO deliRead(String mid) {
        Optional<Member> result=memberRepository.findById(mid);
        if(result.isEmpty()) {
            throw new RuntimeException("NOT FOUND");
        }
        return modelMapper.map(result.get(), MemberDTO.class);
    }

    @Override
    public MemberDTO noriRead(String mid) {
        Optional<Member> result=memberRepository.findById(mid);
        if(result.isEmpty()) {
            throw new RuntimeException("NOT FOUND");
        }
        return modelMapper.map(result.get(), MemberDTO.class);
    }

    @Override
    public void modify(MemberDTO memberDTO) {
        Optional<Member> result=memberRepository.findById(memberDTO.getMid());
        if(result.isEmpty()) {
            throw new RuntimeException("NOT FOUND");
        }
        Member member=result.get();
        member.change(memberDTO.getMpw(), memberDTO.getMaddress(), memberDTO.getMemail(), memberDTO.getMphone());
        memberRepository.save(member);
    }

    @Override
    public void remove(String mid) {
        memberRepository.deleteById(mid);
    }
}

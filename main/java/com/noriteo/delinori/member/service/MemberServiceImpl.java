package com.noriteo.delinori.member.service;

import com.noriteo.delinori.common.dto.PageRequestDTO;
import com.noriteo.delinori.common.dto.PageResponseDTO;
import com.noriteo.delinori.member.domain.Member;
import com.noriteo.delinori.member.dto.MemberDTO;
import com.noriteo.delinori.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;

    @Override
    public PageResponseDTO<MemberDTO> getDTOList(PageRequestDTO pageRequestDTO) {
        List<MemberDTO> dtoList=memberMapper.getList(pageRequestDTO).stream().map(member -> member.getDTO()).collect(Collectors.toList());
        int count=memberMapper.getCount(pageRequestDTO);
        PageResponseDTO<MemberDTO> pageResponseDTO=PageResponseDTO.<MemberDTO>builder()
                .dtoList(dtoList)
                .count(count)
                .build();
        return pageResponseDTO;
    }

    @Override
    public MemberDTO read(String mid) {
        Member member=memberMapper.select(mid);
        log.info("read service=====");
        return member!=null ? member.getDTO() : null;
    }

    @Override
    public String register(MemberDTO memberDTO) {
        Member member=memberDTO.getDomain();
        memberMapper.insert(member);
        return member.getMid();
    }

    @Override
    public boolean remove(String mid) {
        return memberMapper.delete(mid)>0;
    }
}

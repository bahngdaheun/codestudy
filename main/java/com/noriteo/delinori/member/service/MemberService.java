package com.noriteo.delinori.member.service;

import com.noriteo.delinori.common.dto.PageRequestDTO;
import com.noriteo.delinori.common.dto.PageResponseDTO;
import com.noriteo.delinori.member.dto.MemberDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MemberService {

    String register(MemberDTO memberDTO);

    PageResponseDTO<MemberDTO> getDTOList(PageRequestDTO pageRequestDTO);

    MemberDTO read(String mid);

    boolean remove(String mid);

}

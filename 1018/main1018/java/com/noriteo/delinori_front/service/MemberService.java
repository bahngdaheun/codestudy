package com.noriteo.delinori_front.service;

//import com.noriteo.delinori_front.dto.MemberBoardDTO;
import com.noriteo.delinori_front.dto.MemberDTO;
import com.noriteo.delinori_front.dto.MemberPageRequestDTO;
import com.noriteo.delinori_front.dto.MemberPageResponseDTO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface MemberService {
    String register(MemberDTO memberDTO);

    //MemberPageResponseDTO<MemberBoardDTO> getList(MemberPageRequestDTO memberPageRequestDTO);

    MemberDTO deliRead(String mid);

    MemberDTO noriRead(String mid);

    void modify(MemberDTO memberDTO);

    void remove(String mid);
}

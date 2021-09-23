package com.noriteo.delinori.member.mapper;

import com.noriteo.delinori.common.dto.PageRequestDTO;
import com.noriteo.delinori.member.domain.Member;

import java.util.List;

public interface MemberMapper {

    void insert(Member member);

    List<Member> getList(PageRequestDTO pageRequestDTO);

    int getCount(PageRequestDTO pageRequestDTO);

    Member select(String mid);

    int delete(String mid);
}

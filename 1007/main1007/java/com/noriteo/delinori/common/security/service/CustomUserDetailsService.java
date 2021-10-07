package com.noriteo.delinori.common.security.service;

import com.noriteo.delinori.member.domain.Member;
import com.noriteo.delinori.member.dto.SecurityDTO;
import com.noriteo.delinori.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        log.warn("CustomUserDetailsService-----");
        log.warn(username);
        log.warn(memberMapper);
        log.warn("CustomUserDetailsService-----");

        Member member=memberMapper.findByMid(username);
        log.warn(member);
        if(member==null){
            throw new UsernameNotFoundException("NOT EXIST");
        }
            User result=new SecurityDTO(member);
        return result;
    }

}

package com.noriteo.delinori.security;

import com.noriteo.delinori.common.config.RootConfig;
import com.noriteo.delinori.common.security.config.SecurityConfig;
import com.noriteo.delinori.member.domain.Member;
import com.noriteo.delinori.member.mapper.MemberMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class, SecurityConfig.class})
public class PasswordTests {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired(required = false)
    MemberMapper memberMapper;

    @Test
    public void testEncode(){
        String str="nori1";
        String enStr=passwordEncoder.encode(str);
        log.warn(enStr);
    }

    @Test
    public void testDecode(){
        String str="$2a$10$V6FrCuN0Ea6kuwfZmPjAiu9aIIxbsejTmLNy40Iw3Ap/z8FeOAJau";
        boolean match=passwordEncoder.matches("nori1", str);
        log.warn(match);
    }

    @Test
    public void insertNori(){
        String query="insert into member (mid, mpw, mname, maddress, memail, mphone) values ('v1', 'v2', 'v3', 'v4', 'v5', 'v6');";
        for(int i=0; i<10; i++){
            String mid="nori"+i;
            String mpw=passwordEncoder.encode("pw"+i);
            String mname="노리"+i;
            String maddress="주소"+i;
            String memail="메일"+i;
            String mphone="전화"+i;
            String result=query;

            result=result.replace("v1", mid);
            result=result.replace("v2", mpw);
            result=result.replace("v3", mname);
            result=result.replace("v4", maddress);
            result=result.replace("v5", memail);
            result=result.replace("v6", mphone);
            System.out.println(result);
        }
    }

    @Test
    public void insertDeli(){
        String query="insert into member (mid, mpw, mname) values ('v1', 'v2', 'v3');";
        for(int i=0; i<10; i++){
            String mid="deli"+i;
            String mpw=passwordEncoder.encode("pw"+i);
            String mname="딜리"+i;
            String result=query;

            result=result.replace("v1", mid);
            result=result.replace("v2", mpw);
            result=result.replace("v3", mname);
            System.out.println(result);
        }
    }

    @Test
    public void insertAdmin(){
        String query="insert into member (mid, mpw, mname) values ('v1', 'v2', 'v3');";
        for(int i=0; i<10; i++){
            String mid="admin"+i;
            String mpw=passwordEncoder.encode("pw"+i);
            String mname="관리자"+i;
            String result=query;

            result=result.replace("v1", mid);
            result=result.replace("v2", mpw);
            result=result.replace("v3", mname);
            System.out.println(result);
        }
    }

    @Test
    public void insertDeliRole(){
        String sql="insert into member_role (mid, role) values ('%s','%s');";
        for(int i=0; i<10; i++){
            String result=String.format(sql, "deli"+i, "ROLE_DELI");
            System.out.println(result);
        }
    }

    @Test
    public void insertNoriRole(){
        String sql="insert into member_role (mid, role) values ('%s','%s');";
        for(int i=0; i<10; i++){
            String result=String.format(sql, "nori"+i, "ROLE_NORI");
            System.out.println(result);
        }
    }

    @Test
    public void insertAdminRole(){
        String sql="insert into member_role (mid, role) values ('%s','%s');";
        for(int i=0; i<10; i++){
            String result=String.format(sql, "admin"+i, "ROLE_DELI");
            System.out.println(result);
            String result2=String.format(sql, "admin"+i, "ROLE_NORI");
            System.out.println(result2);
            //String result3=String.format(sql, "admin"+i, "ROLE_ADMIN");
            //System.out.println(result3);
        }
    }

    @Test
    public void testMember(){
        String mid="admin0";
        Member member=memberMapper.findByMid(mid);
        log.warn("-------");
        log.warn(member);
    }


}

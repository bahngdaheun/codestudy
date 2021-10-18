package com.noriteo.delinori_front.repository.search;


import com.noriteo.delinori_front.entity.Member;
//import com.noriteo.delinori_front.entity.MemberBoard;
import com.noriteo.delinori_front.entity.QMember;
//import com.noriteo.delinori_front.entity.QMemberBoard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

//@Log4j2
//public class MemberSearchImpl extends QuerydslRepositorySupport implements MemberSearch{

//    public MemberSearchImpl() {
//        super(MemberBoard.class);
//    }
//
//    @Override
//    public Page<MemberBoard> search1(char[] typeArr, String keyword, Pageable pageable) {
//        log.info("--------search1");
//        QMemberBoard memberBoard=QMemberBoard.memberBoard;
//        JPQLQuery<MemberBoard> jpqlQuery=from(memberBoard);
//
//        if(typeArr!=null && typeArr.length>0) {
//
//            BooleanBuilder condition=new BooleanBuilder();
//
//            for(char type: typeArr) {
//                if(type=='T') {
//                    condition.or(memberBoard.title.contains(keyword));
//                } else if(type=='C') {
//                    condition.or(memberBoard.content.contains(keyword));
//                }
//            }
//            jpqlQuery.where(condition);
//        }
//        jpqlQuery.where(memberBoard.bno.gt(0L));
//
//        JPQLQuery<MemberBoard> pagingQuery=this.getQuerydsl().applyPagination(pageable, jpqlQuery);
//
//        List<MemberBoard> memberBoardList=pagingQuery.fetch();
//        long totalCount=pagingQuery.fetchCount();
//
//        return new PageImpl<>(memberBoardList, pageable, totalCount);
//    }
//}

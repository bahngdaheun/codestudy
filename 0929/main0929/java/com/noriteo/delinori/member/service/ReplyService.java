package com.noriteo.delinori.member.service;

import com.noriteo.delinori.member.domain.Reply;
import com.noriteo.delinori.member.dto.ReplyDTO;

import java.util.List;

public interface ReplyService {

    int add(ReplyDTO replyDTO);

    List<ReplyDTO> getRepliesWithMid(String mid);

    int remove(Long rno);

    int modify(ReplyDTO replyDTO);

    default Reply dtoToEntity(ReplyDTO dto){
        Reply reply= Reply.builder()
                .rno(dto.getRno())
                .mid(dto.getMid())
                .reply(dto.getReply())
                .replyer(dto.getReplyer())
                .replyDate(dto.getReplyDate())
                .modDate(dto.getModDate())
                .build();
        return reply;
    }

    default ReplyDTO entityToDTO(Reply reply){//default 쓰면 인터페이스도 몸체를 가질 수 있음

        ReplyDTO replyDTO=ReplyDTO.builder()
                .rno(reply.getRno())
                .mid(reply.getMid())
                .reply(reply.getReply())
                .replyer(reply.getReplyer())
                .replyDate(reply.getReplyDate())
                .modDate(reply.getModDate())
                .build();
        return replyDTO;
    }
}

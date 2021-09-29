package com.noriteo.delinori.member.service;

import com.noriteo.delinori.member.dto.ReplyDTO;
import com.noriteo.delinori.member.mapper.MemberMapper;
import com.noriteo.delinori.member.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class ReplyServiceImpl implements ReplyService{

    private final ReplyMapper replyMapper;
    private final MemberMapper memberMapper;

    @Override
    public List<ReplyDTO> getRepliesWithMid(String mid) {
        return replyMapper.getListWithMember(mid).stream().map(reply -> entityToDTO(reply)).collect(Collectors.toList());
    }

    @Override
    public int remove(Long rno) {
        return replyMapper.delete(rno);
    }

    @Override
    public int modify(ReplyDTO replyDTO) {
        return replyMapper.update(dtoToEntity(replyDTO));
    }

    @Override
    public int add(ReplyDTO replyDTO) {
         int count=replyMapper.insert(dtoToEntity(replyDTO));
         memberMapper.updateReplyCnt(replyDTO.getMid(), 1);//댓글 1개 추가하면 count도 1 늘게

        return count;
    }
}

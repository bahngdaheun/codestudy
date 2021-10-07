package com.noriteo.delinori.member.controller;

import com.noriteo.delinori.member.dto.ReplyDTO;
import com.noriteo.delinori.member.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/replies")
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("")
    public int add(@RequestBody ReplyDTO replyDTO){

        log.info("==========");
        log.info(replyDTO);

        return replyService.add(replyDTO);
    }

    @DeleteMapping("/{rno}")
    public String remove(@PathVariable(name = "rno") Long rno){
        log.info("---reply remove----");
        log.info("rno: "+rno);
        replyService.remove(rno);
        return "success";
    }

    @PutMapping("/{rno}")
    public String modify(@PathVariable(name = "rno") Long rno, @RequestBody ReplyDTO replyDTO){
        log.info("---reply modify----"+rno);
        log.info(replyDTO);
        replyService.modify(replyDTO);
        return "success";
    }

    @GetMapping("/list/{mid}")
    public List<ReplyDTO> getMemberReplies(@PathVariable(name = "mid") String mid){
       //서비스 계층 호출: 모델에 안 담고 바로 반환
        return replyService.getRepliesWithMid(mid);
    }


}

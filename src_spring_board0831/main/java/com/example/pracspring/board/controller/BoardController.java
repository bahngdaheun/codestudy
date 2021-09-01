package com.example.pracspring.board.controller;

import com.example.pracspring.board.dto.BoardDTO;
import com.example.pracspring.board.service.BoardService;
import com.example.pracspring.board.service.TimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/*")//getmapping, postmapping 합친 것(브라우저에서 board 입력하면 다 여기로 옴)
@Log4j2
@RequiredArgsConstructor//이거 쓰려면 final 선언해야 함
//test에서는 autowired 사용
public class BoardController {

    private final TimeService timeService;
    private final BoardService boardService;//객체 연결

    @GetMapping("/time")
    public void getTime(Model model){
        log.info("====controller getTime=====");
        model.addAttribute("time", timeService.getNow());
    }

    @PostMapping("/register")
    public String registerPost(BoardDTO boardDTO){
        log.info("boardDTOM");
        Long bno=boardService.register(boardDTO);
        return "redirect:/board/list";//아직 list.jsp 안 만들어서 화면 나올 게 없음
    }
}

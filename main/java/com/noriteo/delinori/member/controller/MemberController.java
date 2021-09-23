package com.noriteo.delinori.member.controller;

import com.noriteo.delinori.common.dto.PageMaker;
import com.noriteo.delinori.common.dto.PageRequestDTO;
import com.noriteo.delinori.common.dto.PageResponseDTO;
import com.noriteo.delinori.member.dto.MemberDTO;
import com.noriteo.delinori.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member/*")
@Log4j2
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/list")
    public void getList(PageRequestDTO pageRequestDTO, Model model) {
        log.info("c getList...."+pageRequestDTO);
        PageResponseDTO<MemberDTO> responseDTO=memberService.getDTOList(pageRequestDTO);
        model.addAttribute("dtoList", responseDTO.getDtoList());
        int total=responseDTO.getCount();
        int page=pageRequestDTO.getPage();
        int size=pageRequestDTO.getSize();
        model.addAttribute("pageMaker", new PageMaker(page, size, total));
    }

    @GetMapping("/read")
    public void read(String mid, PageRequestDTO pageRequestDTO, Model model) {
        log.info("c   read "+mid);
        log.info("c   read "+pageRequestDTO);
        model.addAttribute("memberDTO",memberService.read(mid));
    }

    @GetMapping("/register")
    public void registerGet(){
    }

    @PostMapping("/register")
    public String registerPost(MemberDTO memberDTO) {
        log.info("memberDTO: "+memberDTO);
        String mid=memberService.register(memberDTO);
        log.info("===c registerPost===");
        log.info(mid);
        return "redirect:/member/list";
    }

    @PostMapping("/remove")
    public String remove(String mid, RedirectAttributes redirectAttributes){
        log.info("c    removeController" + mid);
        if (memberService.remove(mid)){
            log.info("remove success");
            redirectAttributes.addFlashAttribute("result","removed");
        }
        return "redirect:/member/list";
    }

}
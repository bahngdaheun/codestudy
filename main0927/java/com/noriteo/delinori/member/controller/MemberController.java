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

    @GetMapping("/delilist")
    public void getListDeli(PageRequestDTO pageRequestDTO, Model model) {
        log.info("c getList...."+pageRequestDTO);
        PageResponseDTO<MemberDTO> responseDTO=memberService.getDTOListDeli(pageRequestDTO);
        model.addAttribute("dtoList", responseDTO.getDtoList());
        int total=responseDTO.getCount();
        int page=pageRequestDTO.getPage();
        int size=pageRequestDTO.getSize();
        model.addAttribute("pageMaker", new PageMaker(page, size, total));
    }

    @GetMapping("/list")
    public void getListNori(PageRequestDTO pageRequestDTO, Model model) {
        log.info("c getList...."+pageRequestDTO);
        PageResponseDTO<MemberDTO> responseDTO=memberService.getDTOListNori(pageRequestDTO);
        model.addAttribute("dtoList", responseDTO.getDtoList());
        int total=responseDTO.getCount();
        int page=pageRequestDTO.getPage();
        int size=pageRequestDTO.getSize();
        model.addAttribute("pageMaker", new PageMaker(page, size, total));
    }

    @GetMapping("/deliread")
    public void readDeli(String mid, PageRequestDTO pageRequestDTO, Model model) {
        log.info("c   read "+mid);
        log.info("c   read "+pageRequestDTO);
        model.addAttribute("memberDTO",memberService.readDeli(mid));
    }

    @GetMapping("/read")
    public void readNori(String mid, PageRequestDTO pageRequestDTO, Model model) {
        log.info("c   read "+mid);
        log.info("c   read "+pageRequestDTO);
        model.addAttribute("memberDTO",memberService.readNori(mid));
    }

    @GetMapping("/deliregister")
    public void registerGetDeli(){
    }

    @GetMapping("/register")
    public void registerGeNori(){
    }

    @PostMapping("/deliregister")
    public String registerPostDeli(MemberDTO memberDTO, RedirectAttributes redirectAttributes) {
        log.info("memberDTO: "+memberDTO);
        String mid=memberService.registerDeli(memberDTO);
        log.info("===c registerPost===");
        log.info(mid);
        redirectAttributes.addFlashAttribute("result", mid);
        return "redirect:/member/delilist";
    }

    @PostMapping("/register")
    public String registerPostNori(MemberDTO memberDTO, RedirectAttributes redirectAttributes) {
        log.info("memberDTO: "+memberDTO);
        String mid=memberService.registerNori(memberDTO);
        log.info("===c registerPost===");
        log.info(mid);
        redirectAttributes.addFlashAttribute("result", mid);
        return "redirect:/member/list";
    }

    @PostMapping("/deliremove")
    public String removeDeli(String mid, RedirectAttributes redirectAttributes){
        log.info("c    removeController" + mid);
        if (memberService.removeDeli(mid)){
            log.info("remove success");
            redirectAttributes.addFlashAttribute("result","removed");
        }
        return "redirect:/member/delilist";
    }

    @PostMapping("/remove")
    public String removeNori(String mid, RedirectAttributes redirectAttributes){
        log.info("c    removeController" + mid);
        if (memberService.removeNori(mid)){
            log.info("remove success");
            redirectAttributes.addFlashAttribute("result","removed");
        }
        return "redirect:/member/list";
    }

}
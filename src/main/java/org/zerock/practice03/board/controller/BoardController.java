package org.zerock.practice03.board.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.practice03.board.domain.Board;
import org.zerock.practice03.board.dto.BoardDTO;
import org.zerock.practice03.board.service.BoardService;
import org.zerock.practice03.board.service.TimeService;

@Controller
@RequestMapping("/board/*")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

    private final TimeService timeService;

    private final BoardService boardService;

    @GetMapping("/time")
    public void getTime(Model model){
        log.info("==========================controller getTime===================");
        model.addAttribute("time",timeService.getNow());
    }

    @PostMapping("/register")
    public String registerPost(BoardDTO boardDTO, RedirectAttributes redirectAttributes){

        log.info("boardDTOM               " + boardDTO);

        Long bno = boardService.register(boardDTO);

        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public void getList(Model model){
        log.info("c           getList");
        model.addAttribute("dtoList",boardService.getDTOList());
    }

    @GetMapping(value = {"/read" , "/modify"})
    public void read(Long bno, Model model){
        log.info("c             read" + bno);
        model.addAttribute("boardDTO",boardService.read(bno));
    }

    @PostMapping("/remove")
    public String remove(Long bno, RedirectAttributes redirectAttributes){
        log.info("c              remove" + bno);

        if(boardService.remove(bno)){
            log.info("삭제 완료");
            redirectAttributes.addFlashAttribute("result","success");
        }

        return "redirect:/board/list";
    }

    @PostMapping("/modify")
    public String modify(BoardDTO boardDTO, RedirectAttributes redirectAttributes){

        if(boardService.modify(boardDTO)){
            redirectAttributes.addFlashAttribute("result","modified");
        }
        redirectAttributes.addAttribute("bno",boardDTO.getBno());
        return "redirect:/board/read";
    }
}

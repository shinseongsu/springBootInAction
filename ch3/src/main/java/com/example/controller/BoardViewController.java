package com.example.controller;

import com.example.domain.BoardVO;
import com.example.service.BoardViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BoardViewController {

    @Autowired
    private BoardViewService boardService;

    @RequestMapping("/getBoardList")
    public String getBoardList(Model model, BoardVO board) {
        List<BoardVO> boardList = new ArrayList<BoardVO>();

//        for(var i = 1 ; i <= 10; i++) {
//            BoardVO board = new BoardVO();
//            board.setSeq(new Long(i));
//            board.setTitle("게시판 프로그램 테스트");
//            board.setWriter("도우너");
//            board.setContent("게시판 프로그램 테스트입니다...");
//            board.setCnt(0L);
//            boardList.add(board);
//        }

        boardList = boardService.getBoardList(board);

        model.addAttribute("boardList", boardList);
        return "getBoardList";
    }


}

package com.example.controller;

import com.example.domain.BoardVO;
import com.example.domain.MemberVO;
import com.example.repository.MemberRepository;
import com.example.service.BoardViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class BoardViewController {

    @Autowired
    private BoardViewService boardService;

    @Autowired
    private MemberRepository memberRepo;

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

    @GetMapping("/insertBoard")
    public String insertBoardView() {
        return "insertBoard";
    }

    @PostMapping("/insertBoard")
    public String insertBoard(BoardVO board) {
        MemberVO member = memberRepo.findById("member1").get();
        board.setMember(member);
        boardService.insertBoard(board);
        return "redirect:getBoardList";
    }

    @GetMapping("/getBoard")
    public String getBoard(BoardVO board, Model model) {
        model.addAttribute("board", boardService.getBoard(board));
        return "getBoard";
    }

    @PostMapping("/updateBoard")
    public String updateBoard(BoardVO board) {
        boardService.updateBoard(board);
        return "forward:getBoardList";
    }

    @GetMapping("/deleteBoard")
    public String deleteBoard(BoardVO board) {
        boardService.deleteBoard(board);
        return "forward:getBoardList";
    }

}

package com.example.service;

import com.example.domain.BoardVO;

import java.util.List;

public interface BoardService {

    String hello(String name);

    BoardVO getBoard();

    List<BoardVO> getBoardList();

}

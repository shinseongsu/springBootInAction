package com.example.service;

import com.example.domain.BoardVO;

import java.util.List;

public interface BoardViewService {

    List<BoardVO> getBoardList(BoardVO board);

    void insertBoard(BoardVO board);

    BoardVO getBoard(BoardVO board);

    void updateBoard(BoardVO board);

    void deleteBoard(BoardVO board);
}

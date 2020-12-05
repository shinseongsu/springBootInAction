package com.example.serviceImpl;

import com.example.domain.BoardVO;
import com.example.repository.BoardViewRepository;
import com.example.service.BoardViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardViewServiceImpl implements BoardViewService {

    @Autowired
    private BoardViewRepository boardRepo;

    public List<BoardVO> getBoardList(BoardVO board) {
        return (List<BoardVO>) boardRepo.findAll();
    }

    public void insertBoard(BoardVO board) {
    }

    public BoardVO getBoard(BoardVO board) {
        return null;
    }

    public void updateBoard(BoardVO board) {

    }

    public void deleteBoard(BoardVO board) {

    }

}

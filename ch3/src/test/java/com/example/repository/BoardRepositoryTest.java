package com.example.repository;

import com.example.domain.BoardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepo;

    @Test
    public void testInsertBoard() {
        BoardVO board = new BoardVO();
        board.setTitle("첫 번째 게시글");
        board.setWriter("테스터");
        board.setContent("잘 등록되었나요?");
        board.setCreateDate(new Date());
        board.setCnt(0L);

        boardRepo.save(board);
    }

    @Test
    public void testGetBoard() {
        BoardVO board = boardRepo.findById(1L).get();
        System.out.println(board.toString());
    }

    @Test
    public void testUpdateBoard() {
        System.out.println("=== 1번 게시글 조회 ===");
        BoardVO board = boardRepo.findById(1L).get();

        System.out.println("=== 1번 게시글 제목 수정 ===");
        board.setTitle("제목을 수정했습니다.");
        boardRepo.save(board);
    }

    @Test
    public void testDeleteBoard() {
        boardRepo.deleteById(1L);
    }

}

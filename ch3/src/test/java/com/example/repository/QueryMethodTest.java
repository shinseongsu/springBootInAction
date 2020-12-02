package com.example.repository;

import com.example.domain.BoardVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryMethodTest {

    @Autowired
    private BoardRepository boardRepo;

    /*
    @Before
    public void dataPrepare() {
        for(int i = 1 ; i <= 200 ; i++) {
            BoardVO board = new BoardVO();
            board.setTitle("테스트 제목 " + i);
            board.setContent("테스트 내용 " + i);
            board.setCreateDate(new Date());
            board.setCnt(1L);
            boardRepo.save(board);
        }
    }
    */

    @Test
    public void testFindByTitle() {
        List<BoardVO> boardList = boardRepo.findByTitle("테스트 제목 10");

        System.out.println("검색 결과");
        for( BoardVO board : boardList ) {
            System.out.println("---> " + board.toString());
        }
    }

    @Test
    public void testByContentContaining() {
        List<BoardVO> boardList = boardRepo.findByContentContaining("17");

        System.out.println("검색 결과");
        for (BoardVO board : boardList) {
            System.out.println("----> " + board.toString());
        }
    }

    @Test
    public void testFindByTitleContainingOrContentContaining() {
        List<BoardVO> boardList = boardRepo.findByTitleContainingOrContentContaining("17", "17");

        System.out.println("검색 결과");
        for (BoardVO board : boardList) {
            System.out.println("----> " + board.toString());
        }
    }

    @Test
    public void testFindByTitleContainingOrderBySeqDesc() {
        List<BoardVO> boardList = boardRepo.findByTitleContainingOrderBySeqDesc("17");

        System.out.println("검색 결과");
        for (BoardVO board : boardList) {
            System.out.println("---> " + board.toString());
        }
    }

    @Test
    public void testFindByTitleContaining() {
//        Pageable paging = PageRequest.of(0, 5);

//        List<BoardVO> boardList = boardRepo.findByTitleContaining("제목", paging);
        Pageable paging = PageRequest.of(0, 5, Sort.Direction.DESC, "seq");

        Page<BoardVO> pageInfo = boardRepo.findByTitleContaining("제목", paging);

        System.out.println("PAGE SIZE : " + pageInfo.getSize());
        System.out.println("TOTAL PAGES : " + pageInfo.getTotalPages());
        System.out.println("TOTAL COUNT : " + pageInfo.getTotalElements());
        System.out.println("NEXT : " + pageInfo.nextPageable());

        List<BoardVO> boardList = pageInfo.getContent();

        System.out.println("검색 결과");
        for (BoardVO board : boardList) {
            System.out.println("---> " + board.toString());
        }
    }

}

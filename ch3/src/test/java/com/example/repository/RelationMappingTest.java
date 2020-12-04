package com.example.repository;

import com.example.domain.BoardVO;
import com.example.domain.MemberVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationMappingTest {

    @Autowired
    private BoardRepository boardRepo;

    @Autowired
    private MemberRepository memberRepo;

    @Test
    public void testManyToOneInsert() {
        MemberVO member1 = new MemberVO();
        member1.setId("member1");
        member1.setPassword("member111");
        member1.setName("둘리");
        member1.setRole("User");
        memberRepo.save(member1);

        MemberVO member2 = new MemberVO();
        member2.setId("member2");
        member2.setPassword("member222");
        member2.setName("도우너");
        member2.setRole("Admin");
        memberRepo.save(member2);

        for(int i = 1; i <= 3 ; i++) {
            BoardVO board = new BoardVO();
            board.setMember(member1);
            board.setTitle("둘리가 등록한 게시글 " + i);
            board.setContent("둘리가 등록한 게시글 내용 " + i);
            board.setCreateDate(new Date());
            board.setCnt(0L);
            boardRepo.save(board);
        }

        for(int i = 1 ; i <= 3 ; i++) {
            BoardVO board = new BoardVO();
            board.setMember(member2);
            board.setTitle("도우너가 등록한 게시글 " + i);
            board.setContent("도우너가 등록한 게시글 내용 " + i);
            board.setCreateDate(new Date());
            board.setCnt(0L);
            boardRepo.save(board);
        }

    }

    @Test
    public void testManyToOneSelect() {
        BoardVO board = boardRepo.findById(202L).get();

        System.out.println("[ " + board.getSeq() + "번 게시글 정보");
        System.out.println("제목 : " + board.getTitle());
        System.out.println("내용 : " + board.getContent());
        System.out.println("작성자 : " + board.getMember().getName());
        System.out.println("작성자 권한 : " + board.getMember().getRole());

    }

    @Test
    public void testTwoWayMapping() {
        MemberVO member = memberRepo.findById("member1").get();

        System.out.println("==================");
        System.out.println(member.getName() + "가(이) 저장한 게시글 목록");
        System.out.println("==================");
        List<BoardVO> list = member.getBoardList();
        for(BoardVO board : list) {
            System.out.println(board.toString());
        }
    }

}

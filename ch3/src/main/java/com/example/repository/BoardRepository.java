package com.example.repository;

import com.example.domain.BoardVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<BoardVO, Long> {
    List<BoardVO> findByTitle(String searchKeyword);

    List<BoardVO> findByContentContaining(String searchKeyword);

    List<BoardVO> findByTitleContainingOrContentContaining(String title, String content);

    List<BoardVO> findByTitleContainingOrderBySeqDesc(String searchKeyword);

//    List<BoardVO> findByTitleContaining(String searchKeyword, Pageable paging);

    Page<BoardVO> findByTitleContaining(String searchKeyword, Pageable paging);
}

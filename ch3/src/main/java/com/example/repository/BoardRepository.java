package com.example.repository;

import com.example.domain.BoardVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends CrudRepository<BoardVO, Long> {
    List<BoardVO> findByTitle(String searchKeyword);

    List<BoardVO> findByContentContaining(String searchKeyword);

    List<BoardVO> findByTitleContainingOrContentContaining(String title, String content);

    List<BoardVO> findByTitleContainingOrderBySeqDesc(String searchKeyword);

//    List<BoardVO> findByTitleContaining(String searchKeyword, Pageable paging);

    Page<BoardVO> findByTitleContaining(String searchKeyword, Pageable paging);

    @Query("SELECT b FROM BoardVO b where b.title like %?1% ORDER BY b.seq DESC")
    List<BoardVO> queryAnnotationTest1(String searchKeyword);

    @Query("SELECT b FROM BoardVO b "
         + "WHERE b.title like %:searchKeyword% "
         + "ORDER BY b.seq DESC")
    List<BoardVO> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);

    @Query("SELECT b.seq, b.title, b.writer, b.createDate "
         + "FROM BoardVO b "
         + "WHERE b.title like %?1%"
         + "ORDER BY b.seq DESC")
    List<Object[]> queryAnnotationTest3(@Param("searchKeyword") String searchKeyword);

    @Query(value = "select seq, title, writer, create_date "
                 + "from boardvo where title like '%'||?1||'%' "
                 + "order by seq desc", nativeQuery = true)
    List<Object[]> queryAnnotationTest4(String searchKeyword);

    @Query("SELECT b FROM BoardVO b ORDER BY b.seq DESC")
    List<BoardVO> queryAnnotationTest5(Pageable paging);

}

package com.example.repository;

import com.example.domain.BoardVO;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

public interface DynamicBoardRepository extends CrudRepository<BoardVO, Long>, QuerydslPredicateExecutor<BoardVO> {
}

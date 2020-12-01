package com.example.repository;

import com.example.domain.BoardVO;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<BoardVO, Long> {
}

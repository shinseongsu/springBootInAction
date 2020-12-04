package com.example.repository;

import com.example.domain.MemberVO;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<MemberVO, String> {
}

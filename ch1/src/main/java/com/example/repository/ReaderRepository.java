package com.example.repository;

import com.example.domain.Book;
import com.example.domain.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReaderRepository extends JpaRepository<Reader, String> {

}

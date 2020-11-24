package com.example.controller;

import com.example.domain.Book;
import com.example.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * ReadingListController
 * JPA 로 데이터 보내보기
 */
@Controller
@RequestMapping("/")
public class ReadingListController {

    private static final String reader = "craig";

    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    @RequestMapping( method = RequestMethod.GET)
    public String readerBooks(Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if(readingList != null) {
            model.addAttribute("books", readingList);
        }
        return "readingList";
    }

    @RequestMapping( method = RequestMethod.POST)
    public String addToReadingList(Book book) {
        book.setReader(reader);
        readingListRepository.save(book);

        return "redirect:/";
    }

}

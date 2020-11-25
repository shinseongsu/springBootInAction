package com.example.controller;

import com.example.domain.Book;
import com.example.domain.Reader;
import com.example.properties.AmazonProperties;
import com.example.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
@ConfigurationProperties(prefix="amazon")   // 프로퍼티 주입
public class ReadingListController {
    private ReadingListRepository readingListRepository;
    private AmazonProperties amazonProperties;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository
                                ,AmazonProperties amazonProperties ) {          // AmazonProperties 주입
        this.readingListRepository = readingListRepository;
        this.amazonProperties = amazonProperties;
    }

    @RequestMapping( method = RequestMethod.GET)
    public String readerBooks(Reader reader, Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if(readingList != null) {
            model.addAttribute("books", readingList);
            model.addAttribute("reader", reader);
            model.addAttribute("amazonID", amazonProperties.getAssociateId());
        }
        return "readingList";
    }

    @RequestMapping( method = RequestMethod.POST)
    public String addToReadingList(Reader reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);

        return "redirect:/";
    }

}

package com.example.controller;

import com.example.domain.Book;
import com.example.domain.Reader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest( webEnvironment= SpringBootTest.WebEnvironment.MOCK)
public class MockMvcWebTests {

    @Autowired
    private WebApplicationContext webContext;   // webApplicationContext 주입

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webContext)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser(username = "admin", password="password", roles="READER")   //  거쩌 안중
    public void homePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("readingList"))
                .andExpect(model().attributeExists("books"))
                .andExpect(model().attribute("books", is(empty())));
    }

    @Test
    @WithMockUser(roles="READER")   //  거쩌 안중
    public void homePage_unauthenticateUser() throws Exception {
        Reader expectedReader = new Reader();
        expectedReader.setUsername("admin");
        expectedReader.setPassword("password");
        expectedReader.setFullname("CraigWalls");

//        mockMvc.perform(get("/"))
//                .andExpect(status().is3xxRedirection())
//                .andExpect(header().string("Location", "http://localhost/login"));

          mockMvc.perform(get("/"))
                  .andExpect(status().isOk())
                  .andExpect(view().name("readingList"))
                  .andExpect(model().attribute("reader", samePropertyValuesAs(expectedReader)))
                  .andExpect(model().attribute("books", hasSize(0)))
                  .andExpect(model().attribute("amazonID", "habuma-20"));
    }



    @Test
    @WithMockUser(roles="READER")   //  거쩌 안중
    public void postBook() throws Exception {
        mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("title", "BOOK TITLE")
                .param("author", "BOOK AUTHOR")
                .param("isbn", "1234567890")
                .param("description", "DESCRIPTION"))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().string("Location", "/"));

        Book expectedBook = new Book();
        expectedBook.setId(1L);
        expectedBook.setTitle("BOOK TITLE");
        expectedBook.setAuthor("BOOK AUTHOR");
        expectedBook.setIsbn("1234567890");
        expectedBook.setDescription("DESCRIPTION");

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("readingList"))
                .andExpect(model().attributeExists("books"))
                .andExpect(model().attribute("books", hasSize(1)))
                .andExpect(model().attribute("books", contains(samePropertyValuesAs(expectedBook))));

    }

}

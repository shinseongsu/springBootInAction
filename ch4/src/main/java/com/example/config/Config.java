package com.example.config;

import com.example.bean.Member;
import com.example.bean.PrinterA;
import com.example.bean.PrinterB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    /*@Bean
    public Member member1() {
        Member member1 = new Member();
        member1.setName("홍길동");
        member1.setNickname("도사");
        member1.setPrinter(new PrinterA());

        return member1;
    }

    @Bean(name = "hello")
    public Member member2() {
        return new Member("전우치", "도사", new PrinterA());
    }

    @Bean
    public PrinterA printerA() {
        return new PrinterA();
    }

    @Bean
    public PrinterB printerB() {
        return new PrinterB();
    }*/

}
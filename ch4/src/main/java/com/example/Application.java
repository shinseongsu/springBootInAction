package com.example;

import com.example.bean.Member;
import com.example.bean.Printer;
import com.example.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        // IoC 컨테이너 생성
//        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // Member Bean 생성
//        Member member1 = (Member) context.getBean("member1");
//        member1.print();

        // Member Bean 가져오기
//        Member member2 = context.getBean("hello", Member.class);
//        member2.print();

        // PrinterB Bean 가져오기
//        Printer printer = context.getBean("printerB", Printer.class);
//        member1.setPrinter(printer);
//        member1.print();

//        if ( member1 == member2 ) {
//            System.out.println("동일한 객체입니다.");
//        } else {
//            System.out.println("서로 다른 객체입니다.");
//        }


    }
}

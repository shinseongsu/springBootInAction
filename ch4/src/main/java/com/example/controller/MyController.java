package com.example.controller;

import com.example.bean.Printer;
import com.example.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MyController {

    /*@Autowired
    Member member1;

    @Autowired
    @Qualifier("printerB")
    Printer printer;

    @Autowired
    Member member2;


    @RequestMapping("/")
    public @ResponseBody String root() {
        member1.print();

        member1.setPrinter(printer);
        member1.print();

        if(member1 == member2) {
            System.out.println("동일한 객체입니다.");
        } else {
            System.out.println("서로 다른 객체입니다.");
        }

        return "Annotation 사용하기";
    }*/

    @RequestMapping("/")
    public @ResponseBody String root() throws Exception {
//        return "Model & View";
        return "Form 데이터 전달받아 사용하기";
    }

    @RequestMapping("/test1")
    public String test1(HttpServletRequest httpServletRequest, Model model) {

        String id = httpServletRequest.getParameter("id");
        String name = httpServletRequest.getParameter("name");

        model.addAttribute("id", id);
        model.addAttribute("name", name);
//        model.addAttribute("name", "홍길동");

        return "test1";
    }

    /*@RequestMapping("/test2")
    public ModelAndView test2() {
        ModelAndView mv = new ModelAndView();

        List<String> list = new ArrayList<>();

        list.add("test1");
        list.add("test2");
        list.add("test3");

        mv.addObject("lists", list);
        mv.addObject("ObjectTest", "테스트입니다.");
        mv.addObject("name", "홍길동");
        mv.setViewName("view/myView");

        return mv;

       // return "sub/test2";
    }*/

    @RequestMapping("/test2")
    public String test2(@RequestParam("id") String id,
                        @RequestParam("name") String name,
                        Model model) {

        model.addAttribute("id", id);
        model.addAttribute("name", name);

        return "test2";
    }

    @RequestMapping("/test3")
    public String test3(Member member, Model model) {
        return "test3";
    }

    @RequestMapping("/test4/{studentId}/{name}")
    public String getStudent(@PathVariable String studentId,
                             @PathVariable String name,
                             Model model) {

        model.addAttribute("id", studentId);
        model.addAttribute("name", name);

        return "test4";
    }


}

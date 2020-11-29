package com.example;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringExampleApplication {
    public static void main(String[] args) {
//        SpringApplication.run(SpringExampleApplication.class, args);

        SpringApplication application = new SpringApplication(SpringExampleApplication.class);
//        application.setWebApplicationType(WebApplicationType.NONE);  -- 톰캣은 실행되지 않음
//        application.setBannerMode(Banner.Mode.OFF);                  -- 시작시 배너 보이지 않음
        application.setWebApplicationType(WebApplicationType.SERVLET);
        application.run(args);
    }
}

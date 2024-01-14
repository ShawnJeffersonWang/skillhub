package com.club.subject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

 /**
 * 刷题微服务启动类
 *
 * @author: Shawn
 * @date: 2023/12/9
 */
@SpringBootApplication
@ComponentScan("com.club")
@MapperScan("com.club.**.mapper")
public class SubjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubjectApplication.class);
    }
}

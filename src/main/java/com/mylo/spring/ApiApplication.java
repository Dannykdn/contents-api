package com.mylo.spring;

import com.mylo.process.rest.annotation.EnableStub;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(exclude = {MybatisAutoConfiguration.class})
/*@EnableAccessCheck*/
@EnableStub
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

}

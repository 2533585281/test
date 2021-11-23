package com.wzb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * // @EnableScheduling  开启定时任务
 * // @EnableSwagger2    开启Swagger
 * http://localhost:8888/swagger-ui.html
 * @author wzb
 */

@SpringBootApplication
@EnableScheduling
@EnableSwagger2
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

}

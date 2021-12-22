package com.wzb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *  @EnableScheduling  开启定时任务
 *  @EnableCaching     开启缓存属性
 *  @MapperScan        扫描dao层,也可以是mapper
 *  @EnableSwagger2    开启Swagger
 *  http://localhost:8888/swagger-ui.html
 *  @author wzb
 */

@SpringBootApplication
@EnableScheduling
@EnableCaching
@MapperScan("com.wzb.dao")
@EnableSwagger2
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

}

package com.jade.showcase;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @MapperScan({"com.jade.showcase.user.mapper","com.jade.showcase.crawler.mapper","com.jade.showcase.baby.mapper","com.jade.showcase.eat.eat.mapper"})
@MapperScan("com.jade.showcase.**.mapper")
@EnableMethodCache(basePackages = "com.jade.showcase.user.service")
@EnableCreateCacheAnnotation
public class ShowcaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShowcaseApplication.class, args);
    }

}


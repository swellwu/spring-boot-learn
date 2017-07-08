package com.swellwu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * <p>Description:</p>
 *
 * @author xinjian.wu
 * @date 2017-06-22
 */
@SpringBootApplication
@EnableCaching
@EnableAspectJAutoProxy
@MapperScan("com.swellwu.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}

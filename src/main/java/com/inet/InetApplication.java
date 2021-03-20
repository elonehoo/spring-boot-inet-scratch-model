package com.inet;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 程序启动模块
 * @author HCY
 * @since 2021/3/17 上午10:14
*/
@SpringBootApplication
@MapperScan("com.inet.code.mapper")
public class InetApplication {

    public static void main(String[] args) {
        SpringApplication.run(InetApplication.class, args);
    }

}

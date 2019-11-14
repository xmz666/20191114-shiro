package com.aaa.xmz.shiro;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Company AAA软件教育
 * @Author xmz
 * @Date Create in 2019/10/12 9:28
 * @Description
 *      关闭IDEA程序
 *      因为用的是破解版
 *
 **/
@SpringBootApplication
@MapperScan("com.aaa.xmz.shiro.mapper")
public class ApplicationRun {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRun.class, args);
    }

}

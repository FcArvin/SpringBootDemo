package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import tk.mybatis.spring.annotation.MapperScan;

@org.springframework.boot.autoconfigure.SpringBootApplication
//Spring Boot 自动扫描 mybatis mapper 包路径下的类
@MapperScan(basePackages = "com.example.demo.mapper")
//扫描 所有需要的包, 包含一些自用的工具类包 所在的路径

//开启定时任@ComponentScan(basePackages= {"com.example.demo"})务
//@EnableScheduling
//开启异步调用方法
@EnableAsync
public class SpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplication.class, args);
	}
}

package com.cxy.by.web;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import com.cxy.by.rpc.pojo.User;
import com.cxy.by.rpc.service.UserService;


@ImportResource(locations = { "classpath:dubboconsumer.xml" })
//这里配置扫描controller里的文件
@ComponentScan(value = "com.cxy.by.web.controller")
@EnableAutoConfiguration
@SpringBootApplication
public class WebMain {
	public static void main(String[] args) throws IOException {
		
		ApplicationContext tc = SpringApplication.run(WebMain.class, args);
		System.out.println("Web应用已正常加载！");
		UserService userService = (UserService) tc.getBean("userService");

		long id = 2;
		User user = userService.findUserById(id);
		System.err.println(user.toString());
		System.out.println("------------");
		System.out.println(user.uname);
		System.out.println("------------");
	}
}

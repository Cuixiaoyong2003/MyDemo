package com.cxy.by.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class DemoController {
	@RequestMapping("hello")
	public String start() {
		System.out.println("Controller已启动！");
		return "index";
	}

}

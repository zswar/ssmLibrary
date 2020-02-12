package com.iteasyup.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.iteasyup.library.consts.ViewNameConst;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login(){
		return ViewNameConst.LOGIN;
	}
	
}

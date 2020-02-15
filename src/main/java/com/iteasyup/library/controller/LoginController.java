package com.iteasyup.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.iteasyup.library.consts.ViewNameConst;

/**
 * 普通用户登录controller
 * @author dongcheng.liao
 * @since 2020/02/13
 */

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login(){
		return ViewNameConst.LOGIN;
	}
	
}

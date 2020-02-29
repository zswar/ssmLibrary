package com.iteasyup.library.controller;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.iteasyup.library.consts.MessageConst;

import com.iteasyup.library.consts.SessionConst;
import com.iteasyup.library.consts.ViewNameConst;
import com.iteasyup.library.entity.User;
import com.iteasyup.library.service.UserService;

/**
 * 普通用户登录controller
 * @author dongcheng.liao
 * @since 2020/02/13
 */

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String init(){
		return ViewNameConst.LOGIN;
	}
	
	@GetMapping("/gmLogin")
	public String gmInit(){
		return ViewNameConst.GM_LOGIN;
	}
	
	@PostMapping("/login/matchUserName")
	@ResponseBody
	public Boolean matchUserName(String userName){
		Boolean matchUserName = userService.matchUserName(userName);
		if (matchUserName) {
			return true;
		}
		else {
			return false;
		}
	}
	
	@PostMapping("/login/matchUser")
	@ResponseBody
	public Boolean matchUser(String userName
								, String password
								, HttpSession session){
		User matchUser = userService.matchUser(userName, password);
		if (Objects.nonNull(matchUser)) {
			session.setAttribute(SessionConst.USER, matchUser);
			
			return true;		
		}else {
			
			return false;
		}
	}
	
}

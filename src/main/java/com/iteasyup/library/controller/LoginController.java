package com.iteasyup.library.controller;

import java.util.Objects;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iteasyup.library.consts.MessageConst;
import com.iteasyup.library.consts.ModelKeyConst;
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
	
	
	@PostMapping("/login/matchUserName")
	public ModelAndView matchUserName(String userName, ModelAndView modelAndView ){
		modelAndView.setViewName(ViewNameConst.LOGIN);
		Boolean matchUserName = userService.matchUserName(userName);
		if (matchUserName==true) {
			modelAndView.addObject(ModelKeyConst.MESSAGE, MessageConst.CORRECT);
		}
		else {
			modelAndView.addObject(ModelKeyConst.MESSAGE, MessageConst.USERNAMEWRONG);
		}
		return modelAndView;
	}
	
	@PostMapping("/login/matchUser")
	public ModelAndView matchUser(String userName
								, String password
								, ModelAndView modelAndView
								, HttpSession session){
		modelAndView.setViewName(ViewNameConst.LOGIN);
		User matchUser = userService.matchUser(userName, password);
		if (Objects.nonNull(matchUser)) {
			modelAndView.addObject(ModelKeyConst.MESSAGE,MessageConst.CORRECT);
			session.setAttribute(SessionConst.USER, matchUser);
		}else {
			modelAndView.addObject(ModelKeyConst.MESSAGE,MessageConst.PASSWORDWRONG);
		}
		return modelAndView;
	}
	
}

package com.iteasyup.library.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.iteasyup.library.consts.ViewNameConst;
import com.iteasyup.library.controller.bean.RegisterForm;
import com.iteasyup.library.service.UserService;
import com.iteasyup.library.entity.User;

/**
 * 注册controller
 * @author dongcheng.liao
 * @since 2020/02/14
 */

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/register")
	public String init(@ModelAttribute RegisterForm registerForm){
		return ViewNameConst.REGISTER;
	}
	
	/**
	 * @param bindingresult验证结果
	 * 
	 * */
	@PostMapping("/register")
	public String register(@Valid
				   @ModelAttribute RegisterForm registerForm
				 , BindingResult bindingresult
				 , HttpSession session
				 , HttpServletRequest request){
		//如果校验失败，则返回注册页面
		if (bindingresult.hasErrors()) {
			return "register";
		}
		//添加用户
		User user= userService.create(registerForm);
		
		//将注册成功的用户添加到session中
		session.setAttribute("loginUser", user);
		
		//重定向到bookhpcontroller
		return "redirect:/bookhp";
	}
	
}

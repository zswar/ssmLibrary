package com.iteasyup.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.iteasyup.library.consts.ViewNameConst;

/**
 * 首页controller
 * @author dongcheng.liao
 * @since 2020/02/13
 */

@Controller
public class HomeController {
	
	@GetMapping("/homepage")
	public String init(){
		return ViewNameConst.HOME_PAGE;
	}
	
}

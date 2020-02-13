package com.iteasyup.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.iteasyup.library.consts.ViewNameConst;

/**
 * 首页的controller
 * @author 廖东成
 * */

@Controller
public class HomeController {
	
	@GetMapping("/homepage")
	public String init(){
		return ViewNameConst.HOMEPAGE;
	}
	
}

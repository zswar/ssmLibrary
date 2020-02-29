package com.iteasyup.library.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;

import com.iteasyup.library.consts.ViewNameConst;
import com.iteasyup.library.entity.Book;
import com.iteasyup.library.service.BookService;


/**
 * 借书controller
 * 
 * @author dongcheng.liao
 * @since 2020/02/23
 */

@Controller
public class BorrowController {
	
	@Autowired
	private BookService bookService;
	
	/**
	 * 得到图书首页借阅请求，将图书信息返回给借书界面
	 * 
	 * @author dongcheng.liao
	 * @since 2020/02/23
	 */
	@GetMapping("/borrow")
	public ModelAndView init(Book book, ModelAndView modelAndView, HttpSession session){
		modelAndView.setViewName(ViewNameConst.BORROW);
		session.setAttribute("book", book);
		System.out.println(book);
		return modelAndView;
	}
	
	
}

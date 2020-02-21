package com.iteasyup.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iteasyup.library.consts.ViewNameConst;
import com.iteasyup.library.entity.Book;
import com.iteasyup.library.service.BookService;

@Controller
public class BorrowController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/borrow")
	public ModelAndView init(Book book, ModelAndView modelAndView){
		modelAndView.setViewName(ViewNameConst.BORROW);
		modelAndView.addObject("book",book);
		return modelAndView;
	}
	
	
}

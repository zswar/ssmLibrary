package com.iteasyup.library.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.iteasyup.library.consts.ViewNameConst;
import com.iteasyup.library.entity.Book;
import com.iteasyup.library.service.BookService;


/**
 * 图书首页controller
 * */

@Controller
public class BookhpController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/bookhp")
	public String init(HttpServletRequest request){
		List<Book> select = bookService.select();
		request.setAttribute("books", select.subList(0, 3));
		request.setAttribute("num", select.size());
		return ViewNameConst.BOOKHP;
	}
	
}

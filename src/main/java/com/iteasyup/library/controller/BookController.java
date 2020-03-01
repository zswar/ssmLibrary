package com.iteasyup.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import com.iteasyup.library.entity.Book;
import com.iteasyup.library.entity.BookType;
import com.iteasyup.library.service.BookService;
import com.iteasyup.library.service.BookTypeService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookTypeService bookTypeService;
	
	@GetMapping("/book/add")
	public ModelAndView init(ModelAndView modelAndView){
		List<BookType> types = bookTypeService.findAllBookType();
		modelAndView.setViewName("addBook");
		modelAndView.addObject("types",types);
		return modelAndView;
	}
	
	@PostMapping("/book/add")
	public String addBook(Book book){
		System.out.println(book);
		int result = bookService.createBook(book);
		return "redirect:/bookhp";
	}
	
}

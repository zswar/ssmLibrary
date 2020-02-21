package com.iteasyup.library.controller;


import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iteasyup.library.consts.DataLineConst;
import com.iteasyup.library.consts.ModelKeyConst;

import com.iteasyup.library.entity.Book;
import com.iteasyup.library.service.BookService;




/**
 * 图书首页controller
 * 
 * @author dongcheng.liao
 * @since 2020/02/14
 */


@Controller
public class BookhpController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/bookhp")
	public ModelAndView init(ModelAndView modelAndView){
		List<Book> select = bookService.findAllBooks();
		List<Book> subList = select.subList(0, DataLineConst.DATA_LINE);
		modelAndView.addObject(ModelKeyConst.SUB_BOOKS, subList)
					.addObject(ModelKeyConst.SUM_BOOK, select.size());
		return modelAndView;
	}
	
	/**
	 * 查询页面的ajax后端
	 * 暂未实现
	 * */
	@PostMapping("/bookhp/search")
	@ResponseBody
	public List<Book> search(String bookName){
		List<Book> books=bookService.findBooksByBookName(bookName);
		List<Book> subBooks = books.subList(0, DataLineConst.DATA_LINE);
		return subBooks;
	}
	
	
}

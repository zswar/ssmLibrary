package com.iteasyup.library.controller;

import java.awt.print.Pageable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iteasyup.library.consts.DataLineConst;
import com.iteasyup.library.consts.ModelKeyConst;
import com.iteasyup.library.consts.ViewNameConst;
import com.iteasyup.library.entity.Book;
import com.iteasyup.library.service.BookService;

import lombok.Value;


/**
 * 图书首页controller
 * @author dongcheng.liao
 * @since 2020/02/14
 */

@Value
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
		for (Book book : subList) {
			System.out.println(book);
		}
		return modelAndView;
	}
	
}

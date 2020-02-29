package com.iteasyup.library.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iteasyup.library.consts.DataLineConst;
import com.iteasyup.library.consts.ModelKeyConst;
import com.iteasyup.library.consts.ViewNameConst;
import com.iteasyup.library.controller.bean.BookhpForm;
import com.iteasyup.library.entity.Book;
import com.iteasyup.library.entity.User;
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
	public ModelAndView init(ModelAndView modelAndView, HttpSession session){
		List<Book> select = bookService.findAllBooks();
		List<Book> subList;
		if (select.size()<DataLineConst.DATA_LINE) {
			subList = select;
		}else {
			subList = select.subList(0, DataLineConst.DATA_LINE);
		}
		int totalPage = select.size()/DataLineConst.DATA_LINE;
		if (select.size()%DataLineConst.DATA_LINE!=0) {
			totalPage++;
		} 
		
		Object attribute = session.getAttribute("user");
		User user=(User)attribute;
		if (user.getUserType()==0) {
			modelAndView.setViewName(ViewNameConst.BOOK_HP);
		}else {
			modelAndView.setViewName(ViewNameConst.GMBOOK_HP);
		}
		
		modelAndView.addObject(ModelKeyConst.SUB_BOOKS, subList)
					.addObject(ModelKeyConst.SUM_BOOK, select.size())
					.addObject("pageNumber", 1)
					.addObject("totalPage", totalPage);
		session.setAttribute("pageNumber", 1);
		return modelAndView;
	}
	
	/**
	 * 查询页面的ajax后端
	 * 暂未实现
	 * */
	@PostMapping("/bookhp/search")
	@ResponseBody
	public BookhpForm search(String likeName, HttpSession session){
		if (null==likeName) {
			likeName="";
		}
		String bookName="%"+likeName+"%";
		List<Book> books = bookService.findBooksByBookName(bookName);
		List<Book> subBooks;
		if (books.size()<DataLineConst.DATA_LINE) {
			subBooks = books;
		}else {
			subBooks = books.subList(0, DataLineConst.DATA_LINE);
		}
		
		int sumBook = books.size();
		int totalPage = sumBook/DataLineConst.DATA_LINE;
		if (sumBook%DataLineConst.DATA_LINE!=0) {
			totalPage++;
		} 
		
		BookhpForm bookhpForm = new BookhpForm(totalPage, 1, subBooks, sumBook);
		session.setAttribute("pageNumber", 1);
		return bookhpForm;
	}
	
	@PostMapping("/bookhp/page")
	@ResponseBody
	public BookhpForm page(String likeName, HttpSession session, String pageNumber){
		if (null==likeName) {
			likeName="";
		}
		String bookName="%"+likeName+"%";
		List<Book> books = bookService.findBooksByBookName(bookName);
		List<Book> subBooks;
		int pageNo = Integer.parseInt(pageNumber);
		if (books.size()<DataLineConst.DATA_LINE*pageNo) {
			subBooks = books.subList(DataLineConst.DATA_LINE*(pageNo-1),books.size());
		}else {
			subBooks = books.subList(DataLineConst.DATA_LINE*(pageNo-1), DataLineConst.DATA_LINE*pageNo);
		}
		
		int sumBook = books.size();
		int totalPage = sumBook/DataLineConst.DATA_LINE;
		if (sumBook%DataLineConst.DATA_LINE!=0) {
			totalPage++;
		} 
		
		BookhpForm bookhpForm = new BookhpForm(totalPage, 1, subBooks, sumBook);
		
		return bookhpForm;
	}
	
	
}

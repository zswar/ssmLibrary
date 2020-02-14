package com.iteasyup.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iteasyup.library.consts.DataLineConst;
import com.iteasyup.library.dao.BookDao;
import com.iteasyup.library.entity.Book;

/**
 * 查询图书数据
 * */

@Service
public class BookService {

	@Autowired
	private BookDao bookDao;
	
	public List<Book> select(){
		
		List<Book> list=bookDao.selectAll();
		return list;
	}
	
}

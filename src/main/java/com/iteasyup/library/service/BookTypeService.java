package com.iteasyup.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iteasyup.library.dao.BookTypeDao;
import com.iteasyup.library.entity.BookType;

@Service
public class BookTypeService {
	
	@Autowired
	private BookTypeDao bookTypeDao;
	
	public List<BookType> findAllBookType(){
		List<BookType> selectAll = bookTypeDao.selectAll();
		return selectAll;
	}
	
}

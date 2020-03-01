package com.iteasyup.library.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.iteasyup.library.entity.BookType;

public interface BookTypeDao {
	
	@Select("select id, type_name typeName from book_type")
	List<BookType> selectAll();
	
}

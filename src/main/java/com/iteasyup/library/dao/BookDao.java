package com.iteasyup.library.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.iteasyup.library.entity.Book;


public interface BookDao {
	
	/**
	 * 查询book表所有数据
	 * 
	 * */
	@Select("select  id"
			+ "	   , book_name bookname"
			+ "	   , author"
			+ "	   , publish_location publishlocation"
			+ "    , publish_time publishtime"
			+ "    , price "
			+ "    , type_id type"
			+ " from book")
	List<Book> selectAll();
	
	
	
	
}

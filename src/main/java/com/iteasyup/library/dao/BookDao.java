package com.iteasyup.library.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.iteasyup.library.entity.Book;

/**
 * 对book表的交互
 * @author dongcheng.liao
 * @since 2020/02/14
 */
public interface BookDao {
	
	/**
	 * 查询book表所有数据
	 * 
	 * */
	@Select("select  id"
			+ "	   , book_name bookName"
			+ "	   , author"
			+ "	   , publish_location publishLocation"
			+ "    , publish_time publishTime"
			+ "    , price "
			+ "    , type_id typeId"
			+ " from book")
	List<Book> selectAll();
	
	/**
	 * 模糊查询
	 * 
	 * */
	@Select("select  id"
			+ "	   , book_name bookName"
			+ "	   , author"
			+ "	   , publish_location publishLocation"
			+ "    , publish_time publishTime"
			+ "    , price "
			+ "    , type_id typeId"
			+ " from book "
			+ "where book_name like #{bookName}")
	List<Book> selectByBookName(String bookName);
	
	
	
}

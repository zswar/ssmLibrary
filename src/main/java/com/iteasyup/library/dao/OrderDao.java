package com.iteasyup.library.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;

import com.iteasyup.library.entity.Order;

public interface OrderDao {
//	private Integer id;
//	
//	private String startTime;
//	
//	private String endTime;
//	
//	private Integer userId;
//	
//	private Integer bookId;
//	
//	private String state;
	
	
	@Insert("insert into order values(defalut "
			+ "						, #{startTime}"
			+ "						, #{endTime}"
			+ "						, #{userId}"
			+ "						, #{bookId}"
			+ "						, #{state})")
	@SelectKey(statement = "select last_insert_id()"
			 , keyProperty = "id"
			 , keyColumn = "id"
			 , before = false
			 , resultType = int.class)
	int insert(Order order);
	
}

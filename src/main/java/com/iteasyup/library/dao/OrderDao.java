package com.iteasyup.library.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.iteasyup.library.entity.Order;

/**
 * 订单dao
 * 
 * @author dongcheng.liao
 * @since 2020/02/14
 */


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
	
	@Select("select id, start_time startTime, end_time endTime, user_id userId, book_id bookId, state  from order "
			+ " where user_id=#{userId}")
	List<Order> selectByUserId(Integer userId);
	
}

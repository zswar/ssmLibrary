package com.iteasyup.library.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.iteasyup.library.entity.User;

/**
 * 对user表的交互
 * @author dongcheng.liao
 * @since 2020/02/14
 */

public interface UserDao {
	
	
	@Insert("insert into user values( default"
			+ "						, #{userName}"
			+ "						, #{tel}"
			+ "						, #{password}"
			+ "						, #{userType}"
			+ "						, #{question}"
			+ "						, #{answer})")
	int insert(User user);
	
//private Integer Id;
//	
//	private	String userName;
//	
//	private String tel;
//	
//	private String password;
//	
//	private int userType;
//	
//	private String question;
//	
//	private String answer;
	
	@Select("select   id"
			+ "   	, user_name userName"
			+ "   	, user_phone tel"
			+ "	  	, user_password password"
			+ "   	, user_type userType"
			+ "   	, mb_wtid question"
			+ "   	, mb_daan answer"
			+ "	 from user"
			+ " where user_name = #{userName}"
			+ "   and user_password = #{password}")
	User selectByUserNameAndPassword(@Param("userName") String userName
			  , @Param("password") String password);
	
	@Select("select user_name userName from user where user_name=userName")
	String selectByUserName(String userName);
}

package com.iteasyup.library.dao;

import org.apache.ibatis.annotations.Insert;

import com.iteasyup.library.entity.User;

/**
 * 注册用户的dao接口
 * */

public interface UserDao {
	
	
	@Insert("insert into user values(default"
			+ "						,#{userName}"
			+ "						,#{tel}"
			+ "						,#{password}"
			+ "						,#{usertype}"
			+ "						,#{question}"
			+ "						,#{answer})")
	int create(User user);
	
}

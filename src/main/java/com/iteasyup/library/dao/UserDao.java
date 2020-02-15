package com.iteasyup.library.dao;

import org.apache.ibatis.annotations.Insert;

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
			+ "						, #{usertype}"
			+ "						, #{question}"
			+ "						, #{answer})")
	int createuser(User user);
	
}

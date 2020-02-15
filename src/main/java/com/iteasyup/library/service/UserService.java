package com.iteasyup.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iteasyup.library.controller.bean.RegisterForm;
import com.iteasyup.library.dao.UserDao;
import com.iteasyup.library.entity.User;

/**
 * 注册业务层service
 * @author dongcheng.liao
 * @since 2020/02/13
 */

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * 通过校验的registerform，其属性会装入user对象，
	 * 经由dao接口插入user表
	 * */
	public User create(RegisterForm registerForm){
		User user=new User(null
						 , registerForm.getUserName()
						 , registerForm.getTel()
						 , registerForm.getPassword()
						 , 0
						 , registerForm.getQuestion()
						 , registerForm.getAnswer());
		int result=userDao.createuser(user);
		//数据添加失败时，抛出异常，暂未做异常处理
		if (result==0) {
			throw new RuntimeException();
		}
		return user;
		
	}
	
}

package com.iteasyup.library.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iteasyup.library.controller.bean.RegisterForm;
import com.iteasyup.library.dao.UserDao;
import com.iteasyup.library.entity.User;

/**
 * user业务层service
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
	 */
	public User createUser(RegisterForm registerForm){
		User user=new User(null
						 , registerForm.getUserName()
						 , registerForm.getTel()
						 , registerForm.getPassword()
						 , 0
						 , registerForm.getQuestion()
						 , registerForm.getAnswer());
		int result=userDao.insert(user);
		//数据添加失败时，抛出异常，暂未做异常处理
		if (result==0) {
			throw new RuntimeException();
		}
		return user;
		
	}
	
	public Boolean matchUserName(String userName){
		String string=userDao.selectByUserName(userName);
		if (Objects.nonNull(string)) {
			return true;
		}else {
			return false;
		}
	}
	
	public User matchUser(String userName, String password){
		User user=userDao.selectByUserNameAndPassword(userName, password);
		return user;
	}
	
	
	
}

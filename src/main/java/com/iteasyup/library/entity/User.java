package com.iteasyup.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户类
 * */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private Integer userId;
	
	private	String userName;
	private String tel;
	private String password;
	private int usertype;
	private String question;
	private String answer;
	
}

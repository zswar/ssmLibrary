package com.iteasyup.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户类
 * @author dongcheng.liao
 * @since 2020/02/14
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private Integer Id;
	
	private	String userName;
	
	private String tel;
	
	private String password;
	
	private int userType;
	
	private String question;
	
	private String answer;
	
}

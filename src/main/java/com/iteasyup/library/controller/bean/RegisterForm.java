package com.iteasyup.library.controller.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.ScriptAssert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 1.用户名：可以由英文数字中文下划线&*@#等符号组成，长度6-12位
 * 2.手机号：由1开头的11位数字
 * 3.安全问题：下拉框
 * 4.密保答案：任意字符，长度{0,40}
 * 5.密码：可以由任意字符组成，长度8-12
 * 6.确认密码
 * 7.验证码
 * @author 廖东成
 * */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ScriptAssert( lang="javascript"
			 , alias="_"
			 , script="_.password==_.confirmPwd"
			 , message="密码与确认密码不一致"
			 , reportOn="confirmPwd")
public class RegisterForm {
	
	@NotNull(message="用户名不能为空")
	@Pattern(regexp="^[A-Za-z0-9\u4E00-\u9FA5_&*@#]{6,12}$"
			,message="用户名不合法，可以由英文数字中文下划线&*@#等符号组成，长度6-12位")
	private String userName;
	
	@NotNull(message="手机号不能为空")
	@Pattern(regexp="^1[0-9]{10}$",
			message="手机号不正确")
	private String tel;
	
	private String question;
	
	@NotNull(message="密保答案不能为空")
	@Pattern(regexp="^.{0,40}$"
			,message="密保答案可以是任意字符，40字以内")
	private String answer;
	
	@NotNull(message="密码不能为空")
	@Pattern(regexp="^.{8,12}$"
			,message="密码格式不正确，可以由任意字符组成，长度8-12位")
	private String password;
	
	
	private String confirmPwd;
	
	private String securityCode;
	
}

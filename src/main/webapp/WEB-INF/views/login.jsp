<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="login" method="post">
		<h1>免费注册</h1>
		
		*用户名<input type="text" value="请输入用户名"/>
		*手机号<input type="text" value="请输入手机号"/>
		安全设置<input type="text" value="设置密保问题"/>
			<input type="text" value="密保答案"/>
		密码<input type="text" value="请输入密码"/>
		请确认密码<input type="text" value="请再次输入密码"/>
		<input type="text" value="请输入验证码"/>
		<button>获取验证码</button>
		<button>注册</button>
	</form>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	
	
	<h1>免费注册</h1>
	<form:form action="register" method="post" modelAttribute="registerForm">
		
		<label>用户名：</label>
		<form:input path="userName"/>
		<form:errors path="userName" cssStyle="color:red"></form:errors>
		<br/>
		
		<label>手机号</label>
		<form:input path="tel"/>
		<form:errors path="tel" cssStyle="color:red"></form:errors>
		<br/>
		
		<label>安全设置：</label>
		<form:input path="question"/>
		<br/>
		
		<label>密保答案：</label>
		<form:input path="answer"/>
		<form:errors path="answer" cssStyle="color:red"></form:errors>
		<br/>
		
		<label>密码：</label>
		<form:password path="password"/>
		<form:errors path="password" cssStyle="color:red"></form:errors>
		<br/>
		
		<label>确认密码：</label>
		<form:password path="confirmPwd"/>
		<form:errors path="confirmPwd" cssStyle="color:red"></form:errors>
		<br/>
		
		<label>验证码：</label>
		<form:input path="securityCode"/>
		<br/>
		<button>获取验证码</button>
		<button>注册</button>
	</form:form>
	
	
	
	
</body>
</html>
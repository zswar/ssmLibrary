<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
</head>
<body>
	<h1>请登录</h1>
	<form action="bookhp" method="post">
		<label>用户名：</label>
		<input type="text" name="userName" id="userNameIn"/>
		<span id="name"></span>
		<br/>
		<label>密码：</label>
		<input type="password" name="password" id="passwordIn"/>
		<span id="password"></span>
		<br/>
		<button disabled>登录</button>
		<br/>
	</form>
	<a href="#">忘记密码</a>
	<a href="register?userName&password">免费注册</a>
	
	
	<script>
		$("#userNameIn").on("blur",function(){
			$.ajax({
				url: '${pageContext.request.contextPath}/login/matchUserName',
				type: 'post',
				data: {"userName":$("#userNameIn").val()},
				success: function(data) {
					if(data==false){
						
						$("#name").html("用户名不存在");
						
					}else{
						
						$("#name").html("用户名正确");
					}					
				},
			});
		})
		
		$("#passwordIn").change(function(){
			$.ajax({
				url: '${pageContext.request.contextPath}/login/matchUser',
				type: 'post',
				data: {"userName":$("#userNameIn").val(), "password":$('[name="password"]').val()
				},
				success: function(reData) {
					if(reData==false){
						
						$("#password").html("密码错误");
					}else{
						
						$("#password").html("密码正确");
						if($("#name").html()=="用户名正确"){
							$('button').attr('disabled',false)
						}
					}
				},
			});
		})
		
		
		
		
	</script>
	
</body>
</html>
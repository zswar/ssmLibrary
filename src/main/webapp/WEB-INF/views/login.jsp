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
		<input type="text" name="userName"/>
		<span id="name"></span>
		<br/>
		<label>密码：</label>
		<input type="password" name="password"/>
		<span id="password"></span>
		<br/>
		<button disabled>登录</button>
		<br/>
	</form>
	<a href="#">忘记密码</a>
	<a href="register?userName&password">免费注册</a>
	
	
	<script>
		$('[name="userName"]').change(function(){
			$.ajax({
				url: '${pageContext.request.contextPath}/login/matchUserName',
				type: 'post',
				data: {"userName":$('[name="userName"]').val()},
				success: function(reData) {
					$('#name').html(${message})
					
				}
			});
		})
		
		$('[name="password"]').change(function(){
			$.ajax({
				url: '${pageContext.request.contextPath}/login/matchUse',
				type: 'post',
				data: {   "userName":$('[name="userName"]').val()
						, "password":$('[name="password"]').val()},
				}
				success: function(reData) {
					$('#password').html(${message})
				}
			});
		})
		$('button').mouseover(function(){
			if($('#name')==''&&$('#password')==''){
				$('button').attr('disabled',false)
			}
		})
	</script>
	
</body>
</html>
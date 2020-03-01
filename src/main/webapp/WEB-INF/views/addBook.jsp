<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>添加图书画面</h1>
	<form action="add" method="post">
	书名<input type="text" name="bookName"/>
	作者<input type="text" name="author"/>
	出版社<input type="text" name="publishLocation"/>
	出版时间<input type="text" name="publishTime"/>
	价格<input type="text" name="price"/>
	<select name="typeId">
			<c:forEach items="${types}" var="type">
				<option value="${type.id}">${type.typeName}</option>
			</c:forEach>
	</select>
	<button>提交</button>
	</form>
	
	
</body>
</html>
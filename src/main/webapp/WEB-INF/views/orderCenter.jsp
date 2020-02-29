<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
</head>
<body>
	
	<h1>订单中心</h1>
	<a href="">图书首页</a>
	<table>
		<thead>
			<tr>
				<td>订单号</td>
				<td>开始时间</td>
				<td>结束时间</td>
				<td>状态</td>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${orders}"  var="order">
	            <tr>
	            	<td>${order.id}</td>
	                <td>${order.startTime}</td>
	                <td>${order.endTime}</td>
	                <td>${order.state}</td>
	             
	            </tr>
        	</c:forEach>
		</tbody>
		
	</table>
	
</body>
</html>
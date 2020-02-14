<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>北方图书城在线检索系统首页</h1>
	<form action="search"  method="get">
		<input type="text" name="searchinf"/>
		<button></button>
	</form>
	<a href="orderhp">我的订单</a>
	共-${num } -本书
	<table>
		<thead>
			<tr>
				<td>编号</td>
				<td>书名</td>
				<td>作者</td>
				<td>出版社</td>
				<td>出版时间</td>
				<td>价格</td>
				<td>操作</td>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${books}"  var="book"  varStatus="sta">
	            <tr>
	            	<td>${sta.count}</td>
	                <td>${book.bookname}</td>
	                <td>${book.author}</td>
	                <td>${book.publishlocation}</td>
	                <td>${book.publishtime}</td>
	                <td>${book.price}</td>
	                <td> <a href="order?id=${book.id}&bookname=${book.bookname}&price=${book.price }">借阅</a> </td>
	                
	            </tr>
        	</c:forEach>
		</tbody>
		
	</table>
</body>
</html>
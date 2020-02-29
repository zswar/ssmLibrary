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
	<h1>北方图书城在线检索系统首页</h1>
	
	<input type="text" id="likeName"/>
	<button id="search">搜索</button>
	
	<a href="#">添加图书</a>
	共<span id="sumBook">${sumBook}</span>本书
	
	第<input type="text" value=${pageNumber } id="pageNumber"/>/<span id="totalPage">${totalPage }</span>页
	<br/>
	<button id="up">上一页</button>
	<button id="down">下一页</button>
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
			<c:forEach items="${subBooks}"  var="book"  varStatus="sta">
	            <tr>
	            	<td>${sta.count}</td>
	                <td>${book.bookName}</td>
	                <td>${book.author}</td>
	                <td>${book.publishLocation}</td>
	                <td>${book.publishTime}</td>
	                <td>${book.price}</td>
	                <td> <a href="#?id=${book.id}&bookName=${book.bookName}&author=${book.author}&publishLocation=${book.publishLocation}&publishTime=${book.publishTime}&price=${book.price}&typeId=${book.typeId}">更新</a> </td>
	                <td> <a href="#?id=${book.id}&bookName=${book.bookName}&author=${book.author}&publishLocation=${book.publishLocation}&publishTime=${book.publishTime}&price=${book.price}&typeId=${book.typeId}">删除</a> </td>
	                
	            </tr>
        	</c:forEach>
		</tbody>
		
	</table>
	
	<script>
		$('#search').click(function(){
			console.log($('#likeName').val());
			$.ajax({
				url: '${pageContext.request.contextPath}/bookhp/search',
				type: 'post',
				data: {"likeName":$('#likeName').val()},
				success: function(data){
					$('tbody').empty();
					var count=1;
					data.subBooks.forEach(book => {
						var sta = $(`<td></td>`);
							sta.append(count);
						var bookName = $(`<td></td>`);
							bookName.append(book.bookName);
						var author = $(`<td></td>`);
							author.append(book.author);
						var publishLocation = $(`<td></td>`);
							publishLocation.append(book.publishLocation);
						var publishTime = $(`<td></td>`);
							publishTime.append(book.publishTime);
						var price = $(`<td></td>`);
							price.append(book.price);
						var a = $(`<a href="borrow?id=${book.id}&bookName=${book.bookName}&author=${book.author}&publishLocation=${book.publishLocation}&publishTime=${book.publishTime}&price=${book.price}&typeId=${book.typeId}">借阅</a>`);
						var borrow = $(`<td></td>`);
							borrow.append(a);
						var tr = $(`<tr></tr>`);
						tr.append(sta)
						  .append(bookName)
						  .append(author)
						  .append(publishLocation)
						  .append(publishTime)
						  .append(price)
						  .append(borrow);
						$('tbody').append(tr);
						$("#sumBook").text(data.sumBook);
						$("#totalPrice").text(data.totalPrice);
						count++;
					});
				}
			})
		})
	</script>
</body>
</html>
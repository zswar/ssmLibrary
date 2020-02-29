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
	
	<form action="order" method="get">
	
	
	<label>开始时间</label>
	<input type="date" id="startDate" name="startDate"/>
	<br />
	
	<label>结束时间</label>
	<input type="date" id="endDate" name="endDate"/>
	<br />
	
	<label>结算</label>
	<span>单价:</span>
	<input type="text" readonly="readonly" value="${book.price }" id="price">
	<span>*</span>
	<span>天数:</span>
	<input type="text" readonly="readonly" id="days" name="days">
	<span>=</span>
	<span>总价:</span>
	<input type="text" readonly="readonly" id="totalprice" name="totalPrice">
	
	<button>提交订单</button>
	
	</form>
	
	<script>
	$("#endDate").blur(function(){
		
		var time=parseInt(Date.parse($("#endDate").val())-Date.parse($("#startDate").val()))
		var day=time/(1000 * 60 * 60 * 24)
		$("#days").attr("value",day)
		var price=parseInt($("#price").val())
		var totalprice=price*day
		$("#totalprice").attr("value",totalprice)
	})
	</script>
	
</body>
</html>
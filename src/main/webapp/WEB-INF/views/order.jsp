<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	订单号：${order.id }
	租书人：${userName }
	租期：${days }
	<br/>
	开始时间:${order.startTime }
	<br/>
	结束时间：${order.endTime }
	<br/>
	<a href="order/center">订单中心</a>
	<a href="bookhp">图书首页</a>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<style>
	
	#title {
		width: 1200px;
		height: 30px;
		position: relative;
	}
	
	#head {
		width: 1200px;
		height: 100px;
		position: relative;
		margin-top: 12px;
	}
	
	
	#tubiao {
		background-image: url('img/tubiao.png');
	}
	
	#beijing {
		background-image: url('/library/src/main/webapp/WEB-INF/img/beijing.png')
	}
	
</style>

<body>
	<div id="title">
		<h1>欢迎来到北方图书城在线检索系统    请<a href="login">登录</a>
		 <a href="register">注册</a>
		</h1>
	</div>
	
	<div id="head">
		<div id="tubiao"></div>
		<div id="search">
			<input type="text" />
			<button>搜索</button>
		</div>
	</div>
	
	<div id="body">
		<div id="fenlei">
			<table>
				<tr><td>书籍分类</td></tr>
				<tr><td>军事 现实 历史 科幻</td></tr>
				<tr><td>玄幻 都市 武侠 修真</td></tr>
				<tr><td>仙侠 游戏 体育 灵异</td></tr>
				<tr><td>女生</td></tr>
				<tr><td>Java</td></tr>
			</table>
		</div>
		<div id="beijing"></div>
	</div>
	
	
	
	
</body>
</html>
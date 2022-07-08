<%@page import="vo.Dog"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#listForm {
	width: 650px;
	height: 500px;
	border: 1px solid red;
	margin: auto;
}

h2 {
	text-align: center;
}

img {
	width: 280px;
	height: 280px;
	border: none;
}

#content_main {
	height: 300px;
}

#content_left {
	width: 300px;
	float: left;
}

#content_right {
	width: 340px;
	float: left;
}

hr {
	border: 0.2px;
	height: 0.2px;
}

#commandList {
	text-align: center;
}

.btn {
	text-decoration: none;
	color: black;
}   
	
</style>
</head>
<body>
	<section id="listForm">
		<h2>${dog.name}</h2>

		<section id="content_main">

			<section id="content_left">
				<img src="images/${dog.image}" />
			</section>

			<section id="content_right">
				<b>제품구분 : </b>${dog.kind }<br>
				<hr>
				<b>제품명 : </b>${dog.name }<br>
				<hr>
				<b>가격 : </b>${dog.price }원<br>

				<p id="desc">
					<b>내용 : </b>${dog.content }<br>
				</p>
			</section>

			<div style="clear: both"></div>

			<nav id="commandList">
				<a href="dogList.dog" class="btn"><img src="images/list2.png" style="width:25px; height:25px; position:relative; bottom:10px;">상품목록</a> 
				<a href="dogCartAdd.dog?id=${dog.id}" class="btn"><img src="images/cart.png" style="width:25px; height:25px;">장바구니에 담기</a>
			</nav>

		</section>
	</section>
</body>
</html>
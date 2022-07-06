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
	width: 640px;
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

#commandList {
	text-align: center;
}

#desc {
	height: 170px;
	background: skyblue;
}
</style>
</head>
<body>
	<section id="listForm">
		<h2>${dog.kind}의상세정보</h2>

		<section id="content_main">

			<section id="content_left">
				<img src="images/${dog.image}" />
			</section>

			<section id="content_right">
				<b>제품구분 :</b>${dog.kind }<br> <b>제품명 :</b>${dog.name }<br>
				<b>가격 :</b>${dog.price }<br>

				<p id="desc">
					<b>내용 : </b>${dog.content }<br>
				</p>
			</section>

			<div style="clear: both"></div>

			<nav id="commandList">
				<a href="dogList.dog">쇼핑계속하기</a> <a
					href="dogCartAdd.dog?id=${dog.id}">장바구니에 담기</a>
			</nav>
 			<a href="dogDelete.dog?id=${dog.id}">삭제</a>
		</section>
		
	</section>
</body>
</html>
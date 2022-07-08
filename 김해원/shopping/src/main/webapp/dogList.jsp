<%@page import="java.util.HashMap" %>
<%@page import="vo.Dog" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

	container {
		width : 1200px;
	}
	
	#listForm {
		width:900px;
		height:900px;
		float: left;
		margin-left: 400px;
	}
	
	h1 {
		text-align:center;
	}
	
	h1 img {
		width: 30px;
		height: 30px;
		position: relative;
		top: 5px;
	}
	
	#insert {
		text-align: right;
	}
	
	table {
		margin:auto;
		width:550px;
		border-spacing:10px;
	}
	
	td {
		border: 1px solid lightgray;
		padding: 10px;
	}
		
	#insert {
		text-align: right;
	}
	
	#insert a {
		margin: 100px;
		background-color: white;
		text-decoration: none;
		color: coral;
	}
	
	#insert a:hover {
		color: white;
		background-color: coral;
	}
	
	#product {
		text-align: center;
	}
	
	#product a {
		text-decoration: none;
		color: black;
	}
	
	#dog_name {
		font-weight: bold;
	}
	
	.div_empty {
		background-color:red;
		width: 100%;
		height: 100%;
		text-align: center;
	}
	
	#todayImageList {
		text-align: center;
	}
	
	#productImage {
	width: 150px;
	height: 150px;
	border: none;
	}
	
	#todayImage {
	width: 70px;
	height: 70px;
	border: none;
	}
	
	#sidebar {
	width: 110px;
	height: 900px;
	float: left;
    clear: right;
    overflow: hidden;
	}
	
	#sidebar td {
	float: left;
	}
</style>
</head>
<body>
<container>
<section id= "listForm">
<c:if test="${dogList != null}">
<h1><img src="images/dog.png">KITTY TIME<img src="images/cat.png"></h1>
<div id="insert">
<a href="dogRegistForm.dog">상품등록</a>
</div>

<table>
	<tr>
		<c:forEach var = "dog" items="${dogList }" varStatus="status">
		<td>
			<a href="dogView.dog?id=${dog.id}">
			<img src="images/${dog.image}" id="productImage" />
			</a>
			<br>
			
			<div id="product">
			<a href="dogView.dog?id=${dog.id}">
			<div id="dog_name">${dog.name}</div>
			가격 : ${dog.price}원<br>
			</a>
			</div>
		</td>
		<c:if test="${((status.index+1) mod 4)==0}">
	</tr>
	<tr>
		</c:if>
		</c:forEach>
	</tr>
</table>
</c:if>
<c:if test="${dogList==null }">
	<div class="div_empty">
	상품이 없습니다.
	</div>
</c:if>
</section>

	<section id="sidebar">
		<c:if test="${todayImageList !=null }">
			<div id="todayImageList">
				<h4>오늘 본 상품</h4>
					<table>
						<tr>
							<c:forEach var="todayImage" items="${todayImageList }" varStatus="status">
							<td>
								<a href="dogView.dog?id=${dog.id}">
								<img src="images/${todayImage}" id="todayImage" />
								</a>
							</td>
								<c:if test="${((status.index+1) mod 1)==0 }">
						</tr>
						<tr>
							</c:if>
							</c:forEach>
						</tr>
					</table>
			</div>
		</c:if>
	</section>
	</container>
</body>
</html>
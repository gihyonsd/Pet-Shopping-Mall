<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	overflow-y: hidden;
}

#chuchu {
	width: 100%;
	vertical-align: middle;
}

h1 {
	padding: 5px 10px;
	text-align: center;
	position: absolute;
	top: 50%;
	left: 80%;
	transform: translate(-50%, -50%);
}

#golink {
	font-size: 30px;
	font-weight: bold;
	padding: 5px 10px;
	text-align: center;
	position: absolute;
	top: 60%;
	left: 70%;
	background-color: rgba(0, 0, 0, 0.3);	
}

#nomat {
	padding: 5px 10px;
	text-align: center;
	position: absolute;
	top: 57%;
	left: 80%;
	color: #FFCA00;
}


a {
	color: white;
}
</style>
</head>
<body>
<container>
<img src="images/cat3.jpg" id="chuchu">
<a href="dogList.dog"><h1>고양이가 사냥한 동물을<br>
주인에게 주는 것은<br></h1>
<h1 id="nomat">맛이 없기 때문이다<br></h1>
<p id="golink">맛있는 냥이밥 구경가기→</p>
</a>
</container>
</body>
</html>
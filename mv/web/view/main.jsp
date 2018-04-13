<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<!DOCTYPE>
<html>
<head>
<meta charset="EUC-KR">
<title>Look at this place</title>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/variable-pie.js"></script>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/drilldown.js"></script>

<style>
/* Global CSS */
* {
	margin: 0;
	padding: 0;
}

body {
	background-image: url("img/bg.jpg");
}

h2 {
	margin-top: 15;
}

a {
	text-decoration: none;
	color: white;
}

ul, ol {
	list-style: none;
}
/* Header CSS */
header {
	margin: 0 auto;
	width: 800px;
	height: 150px;
}

header>ul>li {
	float: left;
}

header>ul>li>a {
	font-size: 1.0em;
	font-style: bold;
	padding: 5px 10px;
}

header>ul>li>a:hover {
	color: #bfbfbf;
}
/* Section CSS */
section {
	margin: 0 auto;
	width: 800px;
	min-height: 500px;
	background: white;
}
/* Footer CSS */
footer {
	margin: 0 auto;
	width: 800px;
	height: 80px;
}
</style>
<script></script>
</head>
<body>
	<header>
		<h2>
			<a href="main.do"> Simple is the best. </a>
			</h3>

			<!-- <ul>
	<li><a href="userlist.do">User List</a></li>
	<li><a href="useradd.do">User Add</a></li>
	<li><a href="productlist.do">Product List</a></li>
	<li><a href="productadd.do">Product Add</a></li>
</ul>
<ul>
	<li><a href="itemlist.do">Item List</a></li>
	<li><a href="itemadd.do">Item Add</a></li>
</ul>
 -->
			<br>
			<ul>
				<!-- <li><a href="chart1.do">Chart1</a></li>
	<li><a href="chart2.do">Chart2</a></li> -->
				<li><a href="chart3.do">Chart3</a></li>
				<li><a href="chart4.do">Chart4</a></li>
				<li><a href="http://70.12.114.144:80/GOTozo">Hyeonwoo</a></li>
				<li><a href="http://70.12.114.144:80/GOTozo">Taeik</a></li>
				<li><a href="http://70.12.114.150:80/mv">Ranyoung</a></li>
			</ul>
	</header>
	<section>
		<c:choose>
			<c:when test="${center == null }">
				<jsp:include page="center.jsp"></jsp:include>
			</c:when>
			<c:otherwise>
				<jsp:include page="${center }.jsp"></jsp:include>
			</c:otherwise>
		</c:choose>
	</section>
	<footer></footer>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<style>
#main_center{
	margin:0 20px;
	width:760px;
	height:480px;
	background:white;
}
</style>    
    
<div id="main_center">
<h1>Product List Page</h1>
<form method="get" action="userdetail.do">
<table border="1">
<thead>
	<tr><th>ID</th><th>NAME</th><th>PRICE</th><th>REGDATE</th><th>IMG</th></tr>
</thead>
<tbody>
<c:forEach var="u" items="${productlist }">
	<tr>
		
		<td><a href="productdetail.do?id=${u.id }">${u.id }</a></td>
		<td>${u.name }</td>
		<td>${u.price }</td>
		<td>${u.regdate }</td>
		<td><img src="img/${u.imgname}" height="100" width="100"></td>
	</tr>
</c:forEach>
</tbody>
</table>
</form>
</div>












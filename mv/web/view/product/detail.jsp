<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
#main_center{
	margin:0 20px;
	width:760px;
	height:480px;
	background:white;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<script>
$(document).ready(function(){
	$('#update_btn').click(function(){
		var c = confirm('수정 하시겠습니까?');
		if(c == true){
			$('#product_ud').attr({
				'method':'post',
				'action':'productupdate.do',
				'enctype':'multipart/form-data'
			});
			$('#product_ud').submit();
		};
	});
	
	$('#delete_btn').click(function(){
		var c = confirm('삭제 하시겠습니까?');
		if(c == true){
			$('#product_ud').attr({
				'method':'post',
				'action':'productdelete.do'
			});
			$('#product_ud').submit();
		};
	});
});
</script>
</head>
<body>
<div id="main_center">
<h1>Detail Page</h1>
ㅋㅋㅋㅋ
<form id="product_ud">
ID : <input type="text" value="${productselect.id}" name="id" id="id" readonly><br>
NAME : <input type="text" value="${productselect.name}" name="name" id="name"><br>
PRICE : <input type="number" value="${productselect.price}" name="price" id="price"><br>
REGDATE : <input type="text" value="${productselect.regdate}" disabled="disabled"><br>
IMG : <img src="img/${productselect.imgname}" height="100" width="100">
<input type="file" name="mf" id="mf">
<input type="hidden" value="${productselect.imgname}"  name="imgname" id="imgname">
<br>
<input type="button" value="Update" id="update_btn">&nbsp;
<input type="button" value="Delete" id="delete_btn">
</form>

</div>
</body>
</html>
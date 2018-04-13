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
			$('#user_ud').attr({
				'method':'post',
				'action':'userupdate.do'
			});
			$('#user_ud').submit();
		};
	});
	
	$('#delete_btn').click(function(){
		var c = confirm('삭제 하시겠습니까?');
		if(c == true){
			$('#user_ud').attr({
				'method':'post',
				'action':'userdelete.do'
			});
			$('#user_ud').submit();
		};
	});
});
</script>
</head>
<body>
<div id="main_center">
<h1>Detail Page</h1>
ㅋㅋㅋㅋ
<form id="user_ud">
ID : <input type="text" value="${userselect.id}" name="id" id="id"><br>
PWD : <input type="text" value="${userselect.pwd}" name="pwd" id="pwd"><br>
NAME : <input type="text" value="${userselect.name}" name="name" id="name"><br>
<input type="button" value="Update" id="update_btn">&nbsp;
<input type="button" value="Delete" id="delete_btn">
</form>

</div>
</body>
</html>
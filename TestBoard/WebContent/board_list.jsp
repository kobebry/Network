<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	function write_board(){		
		document.write_form.submit();
	}
	
	function upload_board(){
		document.upload_form.submit();
	}
</script>
<title>게시판</title>
</head>
<body>
<table border="1">
	<tr>
		<th>게시판 번호</th>
		<th>게시판 제목</th>
		<th>작성자</th>
		<th>작성일자</th>
		<th>조회수</th>
		<th>추천</th>
	</tr>
	<c:forEach items="${BL}" var="blist">
	<tr>
		<td>${blist.board_id}</td>
		<td><a href="read.do?p_code=contents&b_id=${blist.board_id}">${blist.title}</a></td>
		<td>${blist.writer}</td>
		<td>${blist.wdate}</td>
		<td>${blist.read_cnt}</td>
		<td>${blist.cont_like}</td>	
	</tr>
	</c:forEach>	
</table>
<form name="write_form" method="post" action="read.do">
   <input type="hidden" name="p_code" value="write_board">
   <p><input type="button" value="글쓰기" onclick="write_board()"></p>
 </form>
 
 <form name="upload_form" enctype="multipart/form-data" method="post" action="imgup.jsp">   
   <p><input type="file" name="filename1"></p>
   <p><input type="button" value="전송" onclick="upload_board()"></p>	
</form>
</body>
</html>
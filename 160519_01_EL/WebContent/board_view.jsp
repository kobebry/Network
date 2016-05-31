<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	
	function b_modify(){
		var v_form = document.form_view;

		//p_code값을 modify	
		v_form.p_code.value="modify";
		v_form.action="read.do";
		v_form.submit();
	}

	function b_delete(){		
		var v_form = document.form_view;

		//p_code값을 modify	
		v_form.p_code.value="delete";
		v_form.action="read.do";
		v_form.submit();
	}
	function b_list(){
		var v_form = document.form_view;
		v_form.p_code.value="list";
		v_form.action="read.do";
		v_form.submit();		
	}
	function b_reply(){
		var v_form = document.form_view;
		// p_code = modify;
		v_form.p_code.value="reply";
		// action = read.do
		v_form.action="read.do";
		v_form.submit();
	}
</script>
<title>::글 보기::</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>글번호</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성일자</th>
		</tr>
		<tr>
			<td>${BDTO.board_id}</td>
			<td>${BDTO.title}</td>
			<td>${BDTO.writer}</td>
			<td>${BDTO.read_cnt}</td>
			<td>${BDTO.wdate}</td>
		</tr>
		<tr>
			<th colspan="3">추천</th>
			<th colspan="2">비추천</th>
		</tr>
		<tr>
			<td colspan="3">${BDTO.cont_like}</td>
			<td colspan="2">${BDTO.cont_unlike}</td>
		</tr>
		<tr>
			<th colspan="5">첨부파일</th>
		</tr>
		<tr>
			<td colspan="5">
				<c:choose>
					<c:when test="${BDTO.pds_link eq null}">첨부파일 없음</c:when>
					<c:otherwise>${BDTO.pds_link}</c:otherwise>
				</c:choose>
			</td>
		</tr>
		<tr>
			<th colspan="2">본문 내용</th>
			<td colspan="3"><textarea rows="10" cols="20" readonly="readonly">${BDTO.contents}</textarea></td>
		</tr>		
	</table>
	<form name="form_view" method="post">
	<p>
	<input type="button" value="수정하기" onclick="b_modify()">
	<input type="button" value="삭제하기" onclick="b_delete()">
	<input type="button" value="목록보기" onclick="b_list()">
	<p><input type="button" value="댓글달기" onclick="b_reply()"> </p>	
	</p>
	<input type="hidden" name="p_code">
	<input type="hidden" name="p_bid" value="${BDTO.board_id}">
	</form>
	
	
</body>
</html>
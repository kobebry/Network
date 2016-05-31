<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>::글읽기 페이지::</title>
</head>
<body>
<p>게시글 번호 : ${BDTO.board_id}</p>
<p>게시글 제목 : ${BDTO.title}</p>
<p>작성자 : ${BDTO.writer}</p>
<p>조회수 : ${BDTO.read_cnt}</p>
<p>작성날짜 : ${BDTO.wdate}</p>
<p>파일 : ${BDTO.pds_link}</p>
</body>
</html>
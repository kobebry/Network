<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>::���б� ������::</title>
</head>
<body>
<p>�Խñ� ��ȣ : ${BDTO.board_id}</p>
<p>�Խñ� ���� : ${BDTO.title}</p>
<p>�ۼ��� : ${BDTO.writer}</p>
<p>��ȸ�� : ${BDTO.read_cnt}</p>
<p>�ۼ���¥ : ${BDTO.wdate}</p>
<p>���� : ${BDTO.pds_link}</p>
</body>
</html>
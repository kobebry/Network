<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script type="text/javascript">
	function d_accept(){
		alert("�����Ǿ����ϴ�.")
		var form1 = document.delete_form;
		form1.p_code.value="delete_ok";
		form1.submit();
	}
	function iserror(error){
		if(error == "ok"){
			alert("�н����尡 Ʋ�Ƚ��ϴ�.")
			form1.password.focus();

		}
	}
</script>
<title>Insert title here</title>
</head>
<body onload="iserror('${error}')">
<form action="write.do" name="delete_form" method="post">
	<p>�н����带 �Է��ϼ���</p><br>
	<p>${BID} ���� ����</p>
	<p><input type="password" name="password" value=""></p>
	<input type="button" value="�Է¿Ϸ�" onclick="d_accept()">
	<input type="hidden" name="p_code">
	<input type="hidden" name="p_bid" value="${BID}">
</form>
</body>
</html>
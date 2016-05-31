<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script type="text/javascript">
	function join(){
		document.login_form.p_code.value = "join";
		document.login_form.submit();
	}
	function login(){
		document.login_form.p_code.value = "login";
		document.login_form.submit();
	}

</script>
<title>Insert title here</title>
</head>
<body>
<form name="login_form" action="read.do">
<p>id : <input type="text" name="b_id"></p>
<p>pass : <input type="password" name="b_pass"></p>
<input type="hidden" name="p_code">
<p><input type="button" value="회원가입" onclick="join()"> <input type="button" value="로그인" onclick="login()"></p>
</form>
</body>
</html>
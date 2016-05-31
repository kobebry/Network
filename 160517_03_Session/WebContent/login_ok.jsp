<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page session ="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script type="text/javascript">
	function logout(){
		document.logoutFrom.p_code.value="log_out";
		document.logoutForm.submit();		
	}
	function empmod(){
		//action 바꿔줘야함
		document.logoutForm.action="Emp.do";
		document.logoutForm.submit();
	}
</script>
<title>Login OK</title>
</head>
<body>
<% HttpSession hs = request.getSession(); %>
<p>로그인에 성공하셨습니다.</p>
<p>사용자 번호 : <%=hs.getAttribute("empno") %> <br>
<p>사용자 이름 : <%=request.getAttribute("ename") %>

<input type="hidden" name=<%=hs.getAttribute("empno") %>>
<form name="logoutForm" method="post" action="login.do">
		<input name="p_code" type="hidden">
		<input name="mod_emp" value="정보수정" type="button" onclick="empmod()">
		<input name="logout_bt" value="로그아웃" type="button" onclick="logout()">				
</form>
</body>
</html>
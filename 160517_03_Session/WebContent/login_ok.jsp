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
		//action �ٲ������
		document.logoutForm.action="Emp.do";
		document.logoutForm.submit();
	}
</script>
<title>Login OK</title>
</head>
<body>
<% HttpSession hs = request.getSession(); %>
<p>�α��ο� �����ϼ̽��ϴ�.</p>
<p>����� ��ȣ : <%=hs.getAttribute("empno") %> <br>
<p>����� �̸� : <%=request.getAttribute("ename") %>

<input type="hidden" name=<%=hs.getAttribute("empno") %>>
<form name="logoutForm" method="post" action="login.do">
		<input name="p_code" type="hidden">
		<input name="mod_emp" value="��������" type="button" onclick="empmod()">
		<input name="logout_bt" value="�α׾ƿ�" type="button" onclick="logout()">				
</form>
</body>
</html>
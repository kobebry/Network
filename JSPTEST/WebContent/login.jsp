<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script type="text/javascript">
	function login() {
		document.loginform.code.value="login_chk";
		document.loginform.submit();
	}
	<%HttpSession hs = request.getSession(); %>
	if(<%=hs.getAttribute("name")%>!= null){
	   location.href="list.jsp"
	}
	
</script>

<title>Insert title here</title>
</head>
<body>
<form action="abc.do" name="loginform" method="post">
<p>�α��� ������</p>
<p> ���̵� : <input name="id" type="text" ></p><br>
<p> �̸� : <input name="name" type="text" ></p><br>
<p> ��й�ȣ : <input name="pass" type="password"></p><br>
<p><input name="code" type="hidden" ></p>
<p><input name="p_bt_login" type="button" value="�α���" onclick="login()"></p>
</form>
</body>
</html>
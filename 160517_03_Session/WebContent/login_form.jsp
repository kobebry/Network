<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script type="text/javascript">
	function login(){
		//Controller
		//p_code = Ư�� ���� ������ �Է�
		//p_code = login_chk
		//�� ���� ��� ���� �� ó��
		if(document.loginForm.p_empno.value==""){
			alert("�����ȣ�� �Է��Ͻñ� �ٶ��ϴ�.");
			document.loginForm.p_empno.focus();
		}else if(document.loginForm.p_ename.value==""){
			alert("����̸��� �Է��Ͻñ� �ٶ��ϴ�.");
			document.loginForm.p_ename.focus();
		}else{
			document.loginForm.p_code.value="login_chk";
			document.loginForm.submit();			
		}
	}

	function join(){
		//Controller
		//p_code = user_reg
	}
	
	function chk(){
		if(<%=session.getAttribute("empno")%>!=null){
			location.href="login_ok.jsp";
		}
	}
	function keyevent(){
		//Ű���忡�� enterŰ�� ������ �� ������ �� �ֵ��� ��
		if(event.keyCode == 13){
			login();
		}
	}
	
</script>
<title>Login Page</title>
</head>
<body onload="chk()">
<form action="login.do" method="post" name="loginForm">
	<p>�����ȣ : <input name="p_empno" type="text" onkeydown="keyevent()"></p>
	<p>����̸� : <input name="p_ename" type="text" onkeydown="keyevent()"></p>
	<input name="p_code" type="hidden">
	<p><input name="p_bt_login" value="�α���" type="button" onclick="login()"></p>
	<p><input name="p_bt_reg" value="ȸ������" type="button" onclick="join()"></p>	
</form>
</body>
</html>
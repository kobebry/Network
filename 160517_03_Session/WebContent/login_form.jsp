<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script type="text/javascript">
	function login(){
		//Controller
		//p_code = 특정 값이 들어가도록 입력
		//p_code = login_chk
		//빈 값이 들어 갔을 시 처리
		if(document.loginForm.p_empno.value==""){
			alert("사원번호를 입력하시기 바랍니다.");
			document.loginForm.p_empno.focus();
		}else if(document.loginForm.p_ename.value==""){
			alert("사원이름을 입력하시기 바랍니다.");
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
		//키보드에서 enter키가 눌렸을 시 동작할 수 있도록 함
		if(event.keyCode == 13){
			login();
		}
	}
	
</script>
<title>Login Page</title>
</head>
<body onload="chk()">
<form action="login.do" method="post" name="loginForm">
	<p>사원번호 : <input name="p_empno" type="text" onkeydown="keyevent()"></p>
	<p>사원이름 : <input name="p_ename" type="text" onkeydown="keyevent()"></p>
	<input name="p_code" type="hidden">
	<p><input name="p_bt_login" value="로그인" type="button" onclick="login()"></p>
	<p><input name="p_bt_reg" value="회원가입" type="button" onclick="join()"></p>	
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function loginChk() {
		alert(a);
		if (a == "admin") {
			alert("[" + a + "]���� �α��� �ϼ̽��ϴ�.");
			location.href ="adm_submit.jsp?adm_id=&adm_pass="+"test"
		} else {
			alert("�α��� ���� ���߽��ϴ�.");
			location.href = "/160513_02_WebDataTrans/JSP/admin/admin_input.html";

		}
	}
</script>
</head>
<body onload="loginChk('<%=request.getAttribute("adm_id")%>')">
<form>


</form>

</body>
</html>
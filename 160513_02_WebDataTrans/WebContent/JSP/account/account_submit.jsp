<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	ID = <%=request.getAttribute("a_id") %><br>
	��й�ȣ = <%=request.getAttribute("a_pass")%><br>
	�̸� = <%=request.getAttribute("a_name")%><br>
	���� = <%=request.getAttribute("gender")%><br>
	������� = <%=request.getAttribute("a_birth_y")%> 
	    	   <%=request.getAttribute("a_combo")%>
	           <%=request.getAttribute("a_birth_d")%><br>
	�ּ� = <%=request.getAttribute("a_address") %>
	
	

</body>
</html>
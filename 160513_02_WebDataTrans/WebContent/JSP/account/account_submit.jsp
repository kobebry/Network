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
	비밀번호 = <%=request.getAttribute("a_pass")%><br>
	이름 = <%=request.getAttribute("a_name")%><br>
	성별 = <%=request.getAttribute("gender")%><br>
	생년월일 = <%=request.getAttribute("a_birth_y")%> 
	    	   <%=request.getAttribute("a_combo")%>
	           <%=request.getAttribute("a_birth_d")%><br>
	주소 = <%=request.getAttribute("a_address") %>
	
	

</body>
</html>
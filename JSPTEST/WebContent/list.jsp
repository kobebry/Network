<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%HttpSession hs = request.getSession(); %>
<p>���̵� <%=hs.getAttribute("id") %></p><br>
<p>�̸� <%=hs.getAttribute("name") %><p><br>
<p>��й�ȣ <%=hs.getAttribute("pass") %>

</body>
</html>
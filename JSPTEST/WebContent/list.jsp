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
<p>아이디 <%=hs.getAttribute("id") %></p><br>
<p>이름 <%=hs.getAttribute("name") %><p><br>
<p>비밀번호 <%=hs.getAttribute("pass") %>

</body>
</html>
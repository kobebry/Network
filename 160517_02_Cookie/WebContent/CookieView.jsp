<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%Cookie[] cookie = request.getCookies(); 
	for(int i=0; i<cookie.length; i++){
		out.println(cookie[i].getName()+ " ��Ű"+i+"�� �� = " + cookie[i].getValue()+"<br>");
	}
%>
<%-- <%=cookie[0].getName() %> ��Ű1�� �� = <%=cookie[0].getValue()%><br>
<%=cookie[1].getName() %> ��Ű2�� �� = <%=cookie[1].getValue()%><br>
<%=cookie[2].getName() %> ��Ű3�� �� = <%=cookie[2].getValue()%>
 --%>
</body>
</html>
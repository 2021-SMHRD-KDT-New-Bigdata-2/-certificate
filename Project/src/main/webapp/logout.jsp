<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		session.removeAttribute("member");
		//���ǻ���
		//set-get-remove
		response.sendRedirect("main2.jsp");
	%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num = 0;
	String num_ = request.getParameter("n"); 
	if(num_ != null && !num_.equals(""))
		num = Integer.parseInt(num_);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>스파게티 코드가된 jsp</title>
</head>
<body>
	<%if(num % 2 != 0){ %>
	홀수 입니다.
	<%}else{%>
	짝수 입니다.
	<%} %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
  	String cnt_ = request.getParameter("cnt");
    
    int cnt = 100;
    if(cnt_ != null && !cnt_.equals(""))
    	cnt = Integer.parseInt(cnt_);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>hello</title>
</head>
<body>
	<%for(int i=0; i<cnt; i++){ %>
	Hello! Servlet!<br/>
	<%} //반복문의 중괄호 끝도 감싸주어야 한다 %>	
</body>
</html>
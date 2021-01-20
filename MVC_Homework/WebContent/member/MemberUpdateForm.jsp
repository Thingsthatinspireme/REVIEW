<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="spms.vo.Member" %> 
<%@ page import="java.util.ArrayList" %> 

<%
	Member member = (Member)session.getAttribute("member");
%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원 정보</title>
</head>
<body>
	<h1>회원 정보</h1>
	<form action='update' method='post'>
	번호: <input type='text' name='no' value='<%=member.getNo()%>'readonly><br/>
	이름: <input type='text' name='name' value='<%=member.getName()%>'><br/>
	이메일: <input type='text' name='email' value='<%=member.getEmail() %>'><br/>
	가입일: <%=member.getCreatedDate()%><br/>
	<input type='submit' value='저장'>
	<input type='button' value='삭제' onclick='location.href="delete?no=<%=member.getNo() %>";'>
	
	<input type='button' value='취소' onclick='location.href="list";'>
	</form>
</body>
</html>
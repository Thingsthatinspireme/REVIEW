<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="spms.vo.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ�� ���</title>
</head>
<body>
	<h1>ȸ�� ���</h1>
	<form action='add' method='post'>
	�̸�: <input type='text' name='name'><br/>
	�̸���: <input type='text' name='email'><br/>
	��ȣ: <input type='password' name='password'><br/>
	<input type='submit' value='�߰�'>
	<input type='reset' value='���'>
	</form>
</body>
</html>
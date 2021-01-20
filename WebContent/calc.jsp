<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>계산기</title>
</head>
<body>
	<form action="calc" method="post">
		<div>
			<label>입력 : </label>
			<input type="text" name="v"/>
		</div>
			<div>
			<input type="submit" name="operator" value="+"/>
			<input type="submit" name="operator" value="-"/>
			<input type="submit" name="operator" value="="/>
		</div>
	</form>
</body>
</html>
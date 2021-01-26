<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- VIEW -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello</title>
<%pageContext.setAttribute("result", "hello!");%>
</head>
<body>
	<%=request.getAttribute("result")%>	입니다.<br/>
	${requestScope.result}입니다.<br/>
	${names[0]}<br/>
	${notice.title}<br/>
	${result}<br/>
	${param.n}<br/>
	${header.accept}<br/>
</body>
</html>
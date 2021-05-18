<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	Object message = request.getAttribute("message");
	Object list = request.getAttribute("list");
	if (message != null && !"".equals(message)) {
%>
<script type="text/javascript">
	          alert("<%=request.getAttribute("message")%>");
</script>
<%
	}
%>
<body>
	<form action="servlet?method=insert" method="post">
		姓名<input type="text" name="name" /><br> 学号<input type="text"
			name="id" /><br> 性别<input type="radio" name="sex" value="男" />男
		<input type="radio" name="sex" value="女" />女<br> <input
			type="submit" value="添加">

	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页面</title>
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
<h1>主页面</h1>
<a href="insert.jsp">添加信息</a><br>
<a href="servlet?method=list">删除信息</a><br>
<a href="servlet?method=list">修改信息</a><br>
<a href="servlet?method=list">遍历</a>

</body>
</html>
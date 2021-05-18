<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<%
	Object message = request.getAttribute("message");
	Object list = request.getAttribute("list");
	if (message != null && !"".equals(message)) {
%>
<script type="text/javascript">
	          alert("<%=request.getAttribute("message")%>");
	          $.ajax({
	  			type : "post",
	  			date:data,
	  			dateType:"text",
	  			async : true, //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
	  			url : "servlet?method=list", //请求发送到TestServlet处
	  			success : function(msg){
	  				if("success"==msg){
	  					
	  				alert("成功");
	  				}else{
	  					alert("失败");
	  				}
	  			},

	  			error : function(){
	  				alert("失败");
	  			}

	  		});

				
</script>
<%
	}
%>
<body>
	<div align="center">
		<h1>返回主页</h1>
		<table>
			<tr>
				<td>姓名</td>
				<td>学号</td>
				<td>性别</td>
				<td align="center" colspan="2">操作</td>
			</tr>
			<c:forEach items="${list}" var="item">
				<tr>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.sex}</td>
				<td><a href="update.jsp?id=${item.id}&name=${item.name}&sex=${item.sex}">修改</a></td>
				<td><a href="servlet?method=delete&id=${item.id}">删除</a></td>
				</tr>

			</c:forEach>
		</table>

	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>Insert title here</title>
</head>
<body>
<table border="1" align="center" width="80%" class="table13_7">
	<h1 align="center">成绩列表</h1>
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>成绩</td>
				<td>操作</td>
			</tr>
			<tr>
				<td>${stu.id}</td>
				<td>${stu.stuname}</td>
				<td>${stu.score}</td>
				<td><a style="text-decoration:none"
					href="${pageContext.request.contextPath}/editpage?id=${stu.id}">修改成绩</a>
				</td>
			</tr>
</table>
</body>
</html>
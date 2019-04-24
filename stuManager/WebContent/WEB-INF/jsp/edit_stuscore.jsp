<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>Insert title here</title>
</head>
<body>
Welcome ${stu.stuname}
<a href="${pageContext.request.contextPath}/logout">Logout</a>
<table border="1" align="center" width="80%" class="table13_7">
	<h1 align="center">Result List</h1>
			<tr>
				<td>ID</td>
				<td>Username</td>
				<td>Score</td>
				<td>Action</td>
			</tr>
			<tr>
				<td>${stu.id}</td>
				<td>${stu.stuname}</td>
				<td>${stu.score}</td>
				<td><a style="text-decoration:none"
					href="${pageContext.request.contextPath}/editpage?id=${stu.id}">Edit</a>
				</td>
			</tr>
</table>
</body>
</html>
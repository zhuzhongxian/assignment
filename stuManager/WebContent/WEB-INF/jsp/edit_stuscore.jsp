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
		<c:forEach var="stu" >
			<tr>
				<td>${stu.id}</td>
				<td>${stu.name}</td>
				<td>${stu.score}</td>
				<td><a style="text-decoration:none"
					href="${pageContext.request.contextPath}/editpage?id=1">修改成绩</a></td>
			</tr>
		</c:forEach>
</table>
</body>
</html>
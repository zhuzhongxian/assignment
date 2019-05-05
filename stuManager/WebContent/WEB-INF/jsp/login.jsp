<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Sign in</h1>
<form action="${pageContext.request.contextPath}/toEditStuScore" method="post"  >
<table border="1" cellpadding="0" bordercolor="#9DCCCCC" align="center" >
<tr>
    <td bgcolor="#E7FBFF" align="right">username:</td>
    <td><input type="text" name="stuname" id="stuname"></td>
</tr>
<tr>
    <td bgcolor="#E7FBFF" align="right">password:</td>
    <td><input type="password" name="password" id="password"></td>
</tr>
    <tr align=center><td colspan="2"> <input type="submit" value="Commit"/></td></tr>

</table>
</form>
</body>
</html>
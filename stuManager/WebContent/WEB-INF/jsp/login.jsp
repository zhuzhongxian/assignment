<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>Insert title here</title>
</head>
<body>
<%
String error_message = "";		            //防止用户名为空		            
if(session.getAttribute("error_message")!=null){		                
	  error_message = session.getAttribute("error_message").toString();		            
	  }	
%>
<%=error_message%>
<h1 align="center">登陆界面</h1>
<form action="${pageContext.request.contextPath}/toEditStuScore" method="post"  >
<table border="1" cellpadding="0" bordercolor="#9DCCCCC" align="center" >
<tr>
    <td bgcolor="#E7FBFF" align="right">用户名:</td>
    <td><input type="text" name="stuname" id="stuname"></td>
</tr>

<tr>
    <td bgcolor="#E7FBFF" align="right">密码：</td>
    <td><input type="password" name="password" id="password"></td>
</tr>
    <tr align=center><td colspan="2"> <input type="submit" value="提交" onClick="return validateLogin()"/></td></tr>

</table>
</form>
<script language="javascript">
  function validateLogin(){
    var sUserName = document.getElementById("username").value ;
    var sPassword = document.getElementById("password").value ;
    if (sUserName ==""){
     alert("请输入用户名!");
     return false ;
    }
    if (sPassword ==""){
     alert("请输入密码!");
     return false ;
    }
   } 
  </script>
</body>
</html>
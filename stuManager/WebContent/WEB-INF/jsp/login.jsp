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
String error_message = "";		            //��ֹ�û���Ϊ��		            
if(session.getAttribute("error_message")!=null){		                
	  error_message = session.getAttribute("error_message").toString();		            
	  }	
%>
<%=error_message%>
<h1 align="center">��½����</h1>
<form action="${pageContext.request.contextPath}/toEditStuScore" method="post"  >
<table border="1" cellpadding="0" bordercolor="#9DCCCCC" align="center" >
<tr>
    <td bgcolor="#E7FBFF" align="right">�û���:</td>
    <td><input type="text" name="stuname" id="stuname"></td>
</tr>

<tr>
    <td bgcolor="#E7FBFF" align="right">���룺</td>
    <td><input type="password" name="password" id="password"></td>
</tr>
    <tr align=center><td colspan="2"> <input type="submit" value="�ύ" onClick="return validateLogin()"/></td></tr>

</table>
</form>
<script language="javascript">
  function validateLogin(){
    var sUserName = document.getElementById("username").value ;
    var sPassword = document.getElementById("password").value ;
    if (sUserName ==""){
     alert("�������û���!");
     return false ;
    }
    if (sPassword ==""){
     alert("����������!");
     return false ;
    }
   } 
  </script>
</body>
</html>
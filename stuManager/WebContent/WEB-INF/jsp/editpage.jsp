<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">修改界面</h1>
<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/edit" method="post" >
  
  <fieldset disabled>
    <div class="form-group">
      <label for="disabledTextInput" class="col-sm-2 control-label">ID</label>
      <div class="col-sm-10">
        <input type="text" id="disabledTextInput" class="form-control" placeholder=${stu.id}>
      </div>
    </div>
    <div class="form-group">
      <label for="disabledSelect" class="col-sm-2 control-label">用户名</label>
      <div class="col-sm-10">
      <input type="text" id="disabledTextInput" class="form-control" placeholder=${stu.stuname}>
      </div>
    </div>
    <input type="hidden" value=${stu.score} name="score"></input>
  </fieldset>
   <div class="form-group">
      <label for="disabledSelect" class="col-sm-2 control-label">修改成绩</label>
      <div class="col-sm-10">
      <input type="password" class="form-control" id="inputPassword" placeholder="修改的成绩">
      </div>
    </div>
  <input type="submit" value="提交"/>

  
</form>
</body>
</html>
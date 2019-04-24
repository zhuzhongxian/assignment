<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="GB18030">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Edit</h1>
<form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/edit" method="post" >
  
   <div class="form-group">
   	<label for="disabledSelect" class="col-sm-2 control-label">ID</label>
      <div class="col-sm-10">
      <input type="text" class="form-control" name="id" value=${stu.id}  readonly  unselectable="on" >
      </div>
      <label for="disabledSelect" class="col-sm-2 control-label">Username</label>
      <div class="col-sm-10">
      <input type="text" class="form-control" name="stuname" value=${stu.stuname}   readonly  unselectable="on" >
      </div>
      <input type="hidden" class="form-control" name="score" value=${stu.score} >
      <label for="disabledSelect" class="col-sm-2 control-label">Score</label>
      <div class="col-sm-10">
      <input type="text" class="form-control" id="inputPassword" placeholder="Score" name="score1">
      </div>
    </div>
  <input type="submit" value="commit"/>

  
</form>
</body>
</html>
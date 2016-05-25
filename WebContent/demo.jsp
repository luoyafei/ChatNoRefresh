<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My WebSocket</title>
  </head>
  <body>
  	<form action="/ChatNoRefresh/Demo" method="post">
  		<label name="hello" value="hello">hello</label>
  		<button type="submit">提交</button>
  	</form>
  </body>
</html>
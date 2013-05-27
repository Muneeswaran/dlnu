<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    
    <SCRIPT type="text/javascript" src="js/jquery-1.6.4.min.js"></SCRIPT>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<script type="text/javascript">
		$(document).ready(function(){
		$("#show").hide();
		$("#myForm").submit(function(e){
			alert("aa");
   			 $("#show").show();
   		 });
  	});
</script>
  </head>
  
  <body>
  	<form id="myForm" action="UserActionuploadFile" enctype="multipart/form-data" method="post"> 
  		<p>上传的文件不能超过200M</p>
  		文件名<input type="text" name="fileName"/>
  		上传文件<s:file name="upload"/>
  		文件说明<s:textfield name="fileState"/>
  		<input type="submit" id="sumbit" value="提交"/>
  	</form>
  	<p id="show">正在上传  请稍等！</p>
 
  </body>
</html>

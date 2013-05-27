<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />

<base target="_self">
<link rel="stylesheet" type="text/css" href="skin/css/base.css" />
<link rel="stylesheet" type="text/css" href="skin/css/main.css" />
</head>
<body leftmargin="8" topmargin='8'>
<form action="ManagerActionaddCategory" name="addCategory" meth="post">
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
  <tr bgcolor="#EEF4EA">
    <td colspan="2" background="skin/images/frame/wbg.gif" class='title'><span>添加模块</span><br></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="25%" bgcolor="#FFFFFF">模块名称<br></td>
    <td width="75%" bgcolor="#FFFFFF"><input name="categoryName" type="text" style="width:200px"></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td>模块描述<br></td>
    <td><input name="categoryDescribe" type="text" style="width:200px"></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td></td>
    <td><input type="submit" value="提交">&nbsp; &nbsp;<input type="reset" value="重置"></td>
    
  </tr>

</table>
</form>
</body>
</html>
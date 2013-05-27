<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

<link rel="stylesheet" type="text/css" href="skin/css/base.css">
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
</td>
</tr>
</table>
  
<!--  内容列表   -->
  <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
    <tr bgcolor="#E7E7E7">
      <td height="24" colspan="15" background="skin/images/tbg.gif">模块列表&nbsp;</td>
    </tr>
    <tr align="center" bgcolor="#FAFAF1" height="22">
      <td width="10%">ID</td>
      <td width="20%">模块名称</td>
      <td width="70">模块描述</td>
      
      <td width="20%">操作</td>
    </tr>
    <s:iterator value="categoryList" id="category">
    <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
    <form action="ManagerActionupdateCategory">
      <td><s:property value="#category.getId()"/></td>
      <td align="left"><input type="text" name="categoryName" value="<s:property value="#category.getName()"/>" style="width:200px" /></td>
      <td><input name="categoryDescribe" type="text" value="<s:property value="#category.getDescribe()"/>" style="width:500px" /></td>
      <input type="hidden" name="categoryId" value="<s:property value='#category.getId()'/>" />
      <td><input type="submit" value="确认修改" /><br/><a href="ManagerActiondeleteCategory?categoryId=<s:property value='#category.getId()'/>">删除</a></td>
      
      </form>
    </tr>
    </s:iterator>
    <tr bgcolor="#FAFAF1">
      <td height="28" colspan="15">&nbsp; <a href="javascript:selAll()" class="coolbg">更新列表</a> </td>
    </tr>
    <tr align="right" bgcolor="#EEF4EA">
      <td height="36" colspan="15" align="center"><!--翻页代码 --></td>
    </tr>
  </table>

<!--  搜索表单  -->
<form name='form3' action='' method='get'>
</form>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<base target="_self">
<link rel="stylesheet" type="text/css" href="skin/css/base.css" />
<link rel="stylesheet" type="text/css" href="skin/css/main.css" />
</head>
<body leftmargin="8" topmargin='8'>
<form action="ManagerActionaddUser" name="addUser">
<table width="98%" align="center" border="0" cellpadding="4" cellspacing="1" bgcolor="#CBD8AC" style="margin-bottom:8px">
  <tr bgcolor="#EEF4EA">
    <td colspan="2" background="skin/images/frame/wbg.gif" class='title'><span>添加用户</span><p><s:property value="managerInfoVo.getUserTip()"/></p></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td width="25%" bgcolor="#FFFFFF">用户名 &nbsp;</td>
    <td width="75%" bgcolor="#FFFFFF"><input name="userName" type="text" style="width:200px"></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td>密码 &nbsp; &nbsp;</td>
    <td><input name="userPassword" type="password" style="width:200px"></td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td>用户权限</td>
    <td>
    	<select name="permission">
        	<option value="<s:property value="getAdminP()"/>">管理员</option>
            <option value="<s:property value="getUserP()"/>">普通用户</option>
   		</select>
     </td>
  </tr>
  <tr bgcolor="#FFFFFF">
    <td></td>
    <td><input type="submit" value="提交">&nbsp; &nbsp;<input type="reset" value="重置"></td>
  </tr>
  
</table>
</form>
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">



<style>
.left {
	float:left;
	width:150px;
	height:700px;
	text-align:center;
	}
.right {
	border-left-style:solid;
	float:left;
	height:700px;
	border-left-width: 1px;
	border-left-color: #CCC;
	}
li {
	display:block;
	font-size:24;
	color:#666;
	padding-top:6px;
	padding-bottom:6px;
}
#change {

	cursor:pointer;}
#pass {
		color:#F17200;
		background-color:#DDD;
		margin-top:50px;
		}
		
</style>

</head>

<body>
<div class="left">
<div><img src="img/20121110043736354.jpg" width="100" height="115"></div>
</div>
<div class="right">
<form action="UserActionalterUserInfo" method="post">
<ul> 
<li>用户名&nbsp; ：<s:property value="u.getName()" /></li>
<li> <input type="hidden" name="userId" value="<s:property value='u.getId()' />"/></li> 
<li>性别&nbsp;&nbsp;&nbsp; :<input name = "userSex" type="text" value="<s:property value='u.getSex()'/>"/></li> 
<li>民族&nbsp;&nbsp;&nbsp; :<input name = "nation" type="text" value="<s:property value='u.getNation()'/> "/></li> 
<li>专业&nbsp;&nbsp;&nbsp; :<input name = "major" type="text" value="<s:property value='u.getMajor()'/> "/></li> 
<li>电话&nbsp;&nbsp;&nbsp; :<input name = "tel" type="text" value="<s:property value='u.getTel()'/>" /></li> 
<li>真实姓名:<input name = "trueName" type="text" value="<s:property value='u.getTruename()'/> "/></li> 
<li>个人说明:</li>
<textarea name="state"  style="width:250px;height:100px;"></textarea>
<input type="submit" value="确认修改"></li> 
</ul>
</form>
</div>
</body>
</html>

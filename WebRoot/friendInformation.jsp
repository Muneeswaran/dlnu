<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
request.setCharacterEncoding("UTF-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<script type="text/javascript" src="js/jquery-1.7.1.js"></script>

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
<script>
$(document).ready(function(){
	$("#change").bind("click",function(){
		$("#pass").show();
		});
		
	


	});
</script>
</head>

<body>
<div class="left">
<div><img src="img/20121110043736354.jpg" width="100" height="115"></div>
</div>
<div class="right">
<ul>
<li>用户名：<span><s:property value="u.getName()" /></span></li>
<li>性别：<span><s:property value="u.getSex()" /></span></li>
<li>民族：<span><s:property value="u.getNation()" /></span></li>

<li>用户级别：
<s:if test='u.getPermission() == "4"'>

<span>管理员</span>
</s:if>
<s:else>
<span>普通用户</span>
</s:else>
</li>
<li>专业&nbsp;&nbsp;&nbsp; :<SPAN><s:property value="u.getMajor()"/></SPAN></li> 
<li>电话&nbsp;&nbsp;&nbsp; :<SPAN><s:property value="u.getTel()"/></SPAN></li> 
<li>真实姓名:<SPAN><s:property value="u.getTruename()"/></SPAN></li> 
<li>个人说明：<span><s:property value="u.getState()" /></span></li>

</ul>
</div>
</body>
</html>

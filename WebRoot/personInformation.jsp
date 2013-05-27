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
<li>性&nbsp;&nbsp;别：<span><s:property value="u.getSex()" /></span></li>
<li>民&nbsp;&nbsp;族：<span><s:property value="u.getNation()" /></span></li>


<li>专&nbsp;&nbsp;业: <SPAN><s:property value="u.getMajor()"/></SPAN></li> 
<li>电&nbsp;&nbsp;话: <SPAN><s:property value="u.getTel()"/></SPAN></li> 
<li>用户级别：
<s:if test='u.getPermission() == "4"'>

<span>管理员</span>
</s:if>
<s:else>
<span>普通用户</span>
</s:else>
</li>
<li>真实姓名:<SPAN><s:property value="u.getTruename()"/></SPAN></li> 
<li>个人说明：<span><s:property value="u.getState()" /></span></li>
<li><span id="change"><a href="#">密码修改</a></span>
<form method="post" action="UserActionchangePassword"  name="myform">
<ul style="display:none; margin-left: 100px;" id="pass">
<li><input name="userId" type="hidden" value='<s:property value="u.getId()" />'/> </li>
<li>原始密码：<input name="password1" type="password" id="pw1"/></li>
<li>新  密   码：<input name="password2" type="password" id="pw2"/></li>
<li>密码确认：<input name="password3" type="password" id="pw3"/></li>

<li ><input type="submit" value="确定修改" onclick="return myfun_submit()"/></li>
</ul>
</form>
</li>
<script type="text/javascript">
function myfun_submit(){
	var pw1 = document.getElementById("pw1").value;
	var pw2 = document.getElementById("pw2").value;
	var pw3 = document.getElementById("pw3").value;
	if(pw1==""){
		alert("请输入原始密码");
		return false;
		}else if(pw2==""){
			alert("请输入新密码");
			return false;
			}else if(pw3==""){
				alert("请输入确认密码");
				return false;
				}else if(pw2 != pw3){
					alert("新密码和确认密码不一致");
					return false;
					}else{
return true;
						}
	}
</script>
</ul>
</div>
</body>
</html>

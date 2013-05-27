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
p{
	padding-left:30px;
	}
 a{
		text-decoration:none; 
		}
   span {
	   display:inline-block; margin-left:20px;
	   }
.clickTitle {
	color:#666;
	border-bottom-width: 1px;
	border-bottom-style: dashed;
	border-bottom-color: #CCC;	
	}
.page {
	position: absolute;
	left: 400px;
	top: 680px;
	}		   
	   
</style>
</head>

<body>
<div>
<s:iterator value="topicList" id="topic">
<p><a href="PageInfoActionreadTopicPage?topicId=<s:property value='#topic.getId()'/>" target="_black" class="clickTitle"><s:property value="#topic.getTitle()" /></a>&nbsp;&nbsp;被举报次数：<s:property value="#topic.report" /><span><a href="UserActiondelectTopic?topicId=<s:property value="#topic.getId()"/>&&userId=<s:property value="getUserId()"/>">删除</a></span></p>
</s:iterator>
</div>

<div class="page">

</div>
</body>
</html>

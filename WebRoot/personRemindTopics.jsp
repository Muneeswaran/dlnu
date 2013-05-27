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
ul li{
	padding-left:4px;
	list-style:none;
	}
.f{
	font-size:14px;
}
 a{
		text-decoration:none; 
		}
.clickTitle {
	color:#666;
	border-bottom-width: 1px;
	border-bottom-style: dashed;
	border-bottom-color: #CCC;	
	}
.page {
	padding-right:40px;
	float:right;
	
	top: 500px;
	}
.title{
	width:500px;
	
	float:left;
 	overflow: hidden;
 	-o-text-overflow:ellipsis;
	text-overflow: ellipsis;
	white-space: nowrap;
	course:hand;
	}
.browse{
	width:50px;
	float:left;
	margin-left:4px;
	text-align:center;
	}
.reply{
	width:50px;
	float:left;
	margin-left:4px;
	text-align:center;
	}
.date{
	width:100px;
	float:left;
	margin-left:4px;
	text-align:center;
	}		   
.del{
	display:inline-block;
	width:50px;
	float:left;
	margin-left:4px;
	text-align:center;
	}	   
	.b{
	
	padding:1px 3px;
	border: 1px solid;
	background: #ADC720;
	color: #fff;}
</style>
</head>

<body>
<div>
<ul>
<li class="f"><div class="title">标题</div><div class="browse">浏览数</div><div class="reply">回复数</div><div class="date">发表时间</div></li>
<s:iterator value="topicList" id="topic">
<li>
<div class="title"><a href="PageInfoActionreadTopicPage?topicId=<s:property value='#topic.getId()'/>" target="_black" class="clickTitle"><s:property value="#topic.getTitle()" /></a></div>
<div class="browse"><s:property value="#topic.countBrowse"/></div>
<div class="reply"><s:property value="#topic.countComment"/></div>
<div class="date"><s:date name="date" format="yyyy-MM-dd HH:mm:ss"/></div>
</li>
</s:iterator>
</ul>
</div>


</div>
</body>
</html>

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
<li class="f"><div class="title">标题</div><div class="browse">浏览数</div><div class="reply">回复数</div><div class="date">发表时间</div><div class="del">管理</div></li>
<s:iterator value="topicList" id="topic">
<li>
<div class="title"><a href="PageInfoActionreadTopicPage?topicId=<s:property value='#topic.getId()'/>" target="_black" class="clickTitle"><s:property value="#topic.getTitle()" /></a></div>
<div class="browse"><s:property value="#topic.countBrowse"/></div>
<div class="reply"><s:property value="#topic.countComment"/></div>
<div class="date"><s:date name="date" format="yyyy-MM-dd HH:mm:ss"/></div>
<div class="del"><a href="UserActiondelectTopic?topicId=<s:property value="#topic.getId()"/>&&userId=<s:property value="getUserId()"/>">删除</a></div>
</li>
</s:iterator>
</ul>
</div>

 <div id="l_a" style="float:right;padding-right: 60px;" >
<script type="text/javascript">
 
     var i = 0;
   
   var isNext =<s:property value="pageInfoVo.getTp().getNext()"/>;
	 var size = <s:property value="topicList.size()"/>;//当前拿出来的长度
     var size1 = <s:property value="pageInfoVo.getTp().getPageSize()"/>;  //规定好每页的长度
	 var isPre = <s:property value="pageInfoVo.getTp().getPre()"/>;
	 var pageNum = <s:property value="pageInfoVo.getTp().getAllPage()"/>;
	 var userId = <s:property value="pageInfoVo.getUserId()"/>;

	 if(size < size1){
			for(var j = size; j <= size1; j++){
			document.write("<br/>");
			}
			}
	   	document.write("<center>")
	   	for ( i=1; i<=pageNum; i++){
	   		document.write(" <a href='PageInfoActiontoPersonTopic?userId="
	   							+userId+
	   							"&&topicPageNum="
	   							+i+
	   							"'><strong class='b'>"+i+"</strong></a>&nbsp;");
	   	}
	
		var t = <s:property value="pageInfoVo.getTopicPageNum()"/>;
	   	document.write("<br/>当前第"+t+"页（共"+pageNum+"页）<br/>");

	   if(isPre == 1){
	   var a = t-1;
	 
	   document.write(" <a href='PageInfoActiontoPersonTopic?userId="
	   							+userId+
	   							"&&topicPageNum="
	   							+a+
	   							"'/>上一页");
	   							
	   }
	  
	   if(isNext == 1){
	   var b = t+1;
	   document.write(" <a href='PageInfoActiontoPersonTopic?userId="
	   							+userId+
	   							"&&topicPageNum="
	   							+b+
	   							"'/>下一页");
	   }
	   

	   	document.write("</center>")
	 
</script>
</div>
</div>
</body>
</html>

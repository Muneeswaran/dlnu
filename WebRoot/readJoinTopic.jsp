<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE HTML>
<html>
<head>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script >
	$(document).ready(function() {
	
		$('#ul_li li:odd div').addClass("redClass");
		$('#ul_li li:eq(0) div').removeClass("redClass");
		$('#ul_li li:not(:first-child)').hover(function(){
		
			$(this).addClass('hover')},function(){
			
				$(this).removeClass('hover');
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<style>
ul li{
height: 30px;}

ul li, ul li:not(first-child){

	clear:both;
	padding: 5px 0;
	
	list-style:none;
	}
.f div{
	
	font-size:18px;
	background: #ADC720;
	color:#fff;
}
#ul_li li div{
	height:100%;
	}
		#ul_li li{
	width: 736px;
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
	position: absolute;
	left: 400px;
	top: 680px;
	}
.title{
	width:350px;
	float:left;
 	overflow: hidden;
 	-o-text-overflow:ellipsis;
	text-overflow: ellipsis;
	white-space: nowrap;
	course:hand;
	}
.browse{
	width:60px;
	float:left;
	margin-left:4px;
	}
.reply{
	width:60px;
	float:left;
	margin-left:4px;
	}
.date{
	width:200px;
	float:left;
	margin-left:4px;
	}		   
.del{
	display:inline-block;
	width:50px;
	float:left;
	margin-left:4px;
	}
	.clear{
	clear:both;
}  	
	.b{
	
	padding:1px 3px;
	border: 1px solid;
	background: #ADC720;
	color: #fff;}   
	
	.redClass{
		background:#ccc;
	}
	.hover{
		background: #ccc;
	}
</style>

</head>

<body>
<div>
<ul id="ul_li">
<li class="f"><div class="title">标题</div><div class="browse">浏览数</div><div class="reply">回复数</div><div class="date">发表时间</div><div class="del">作者</div></li>
<s:iterator value="topicList" id="topic">
<li><div class="title"><a href="PageInfoActionreadTopicPage?topicId=<s:property value='#topic.getId()'/>" target="_black" class="clickTitle"><s:property value="#topic.getTitle()" /></a></div>
<div class="browse"><s:property value="#topic.countBrowse"/></div>
<div class="reply"><s:property value="#topic.countComment"/></div>
<div class="date"><s:date name="date" format="yyyy-MM-dd HH:mm:ss"/></div>
<div class="del"><a href="PageInfoActiontoFriendCenter?friendId=<s:property value='#topic.user.id'/>"><s:property value="#topic.user.name"/></a></div>
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
	   		document.write(" <a href='PageInfoActiontoReadJoinTopic?userId="
	   							+userId+
	   							"&&topicPageNum="
	   							+i+
	   							"'><strong class='b'>"+i+"</strong></a>&nbsp;");
	   	}
	
		var t = <s:property value="pageInfoVo.getTopicPageNum()"/>;
	   	document.write("<br/>当前第"+t+"页（共"+pageNum+"页）<br/>");

	   if(isPre == 1){
	   var a = t-1;
	 
	   document.write(" <a href='PageInfoActiontoReadJoinTopic?userId="
	   							+userId+
	   							"&&topicPageNum="
	   							+a+
	   							"'/>上一页");
	   							
	   }
	  
	   if(isNext == 1){
	   var b = t+1;
	   document.write(" <a href='PageInfoActiontoReadJoinTopic?userId="
	   							+userId+
	   							"&&topicPageNum="
	   							+b+
	   							"'/>下一页");
	   }
	   

	   	document.write("</center>")
	 
</script>
</div>
</body>
</html>

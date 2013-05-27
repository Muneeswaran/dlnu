<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>	
<head>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<meta charset="utf-8">
<link href="topic.css" rel="stylesheet" type="text/css" />
<style>


 .title{
	width:370px;
	float:left;
 	overflow: hidden;
 	-o-text-overflow:ellipsis;
	text-overflow: ellipsis;
	white-space: nowrap;
	course:hand;
	}
.author{
	text-align:center;
	width:70px;
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
	}
.reply{
	width:50px;
	float:left;
	margin-left:4px;
	clear:right;
	}
.title{
	width:370px;
	float:left;

 	overflow: hidden;
 	-o-text-overflow:ellipsis;
	text-overflow: ellipsis;
	white-space: nowrap;
	course:hand;
	}



	.redClass{
		background:#ccc;
	}
	li{
		list-style-type: none;
		height: 30px;
		padding-left: 10px;
		font-size: 15px;
		padding-top: 5px;
	}
	a{
	text-decoration: none;}
	.b{
	
	padding:1px 3px;
	border: 1px solid;
	background: #ADC720;
	color: #fff;}
	.hover{
	background: #000;}
</style>
<script >
	$(document).ready(function() {
		$('#ul_li li:even').addClass("redClass");
		$('#ul_li li:first-child').removeClass("redClass");
		$('#ul_li li:not(:first-child)').hover(function(){
			$(this).addClass('hover')},function(){
				$(this).removeClass('hover');
		});
	});
</script>
</head>

<body>
<ul id="ul_li">
<li class="p_t"><div class="title">标题</div><div class="author">作者</div><div class="browse">浏览数</div><div class="reply">回复数</div></li>
<s:iterator value="topicList" id="topic">
<li>
<div class="title"><a href="PageInfoActionreadTopicPage?topicId=<s:property value="#topic.getId()"/>&&commentPageNum = 1" target="_black"><s:property value="#topic.getTitle()"/></a></div>
<div class="author"><s:property value="#topic.user.name"/></div>
<div class="browse"><s:property value="#topic.countBrowse"/></div>
<div class="reply"><s:property value="#topic.countComment"/></div>
<div class="clear"></div>
</li>

</s:iterator>
</ul>
<br>
<script type="text/javascript">
     var i = 0;
   
	 var isNext =<s:property value="pageInfoVo.getTp().getNext()"/>;
	 var size = <s:property value="topicList.size()"/>;//当前拿出来的长度
     var size1 = <s:property value="pageInfoVo.getTp().getPageSize()"/>;  //规定好每页的长度
	 var isPre = <s:property value="pageInfoVo.getTp().getPre()"/>;
	 var pageNum = <s:property value="pageInfoVo.getTp().getAllPage()"/>;
	 var categoryId = <s:property value="pageInfoVo.getCategoryId()"/>;
	 if(size < size1){
			for(var j = size; j <= size1; j++){
			document.write("<br/>");
			}
			}
	   	document.write("<center>")
	   	for ( i=1; i<=pageNum; i++){
	   		document.write(" <a href='PageInfoActiontoCTopicList?categoryId="
	   							+categoryId+
	   							"&&topicPageNum="
	   							+i+
	   							"'><strong class='b'>"+i+"</strong></a>&nbsp;");
	   	}
	
		var t = <s:property value="pageInfoVo.getTopicPageNum()"/>;
	   	document.write("<br/>当前第"+t+"页（共"+pageNum+"页）<br/>");

	   if(isPre == 1){
	   var a = t-1;
	 
	   document.write(" <a href='PageInfoActiontoCTopicList?categoryId="
	   							+categoryId+
	   							"&&topicPageNum="
	   							+a+
	   							"'/>上一页");
	   							
	   }
	  
	   if(isNext == 1){
	   var b = t+1;
	   document.write(" <a href='PageInfoActiontoCTopicList?categoryId="
	   							+categoryId+
	   							"&&topicPageNum="
	   							+b+
	   							"'/>下一页");
	   }
	   

	   	document.write("</center>")
</script>

</body>
</html>

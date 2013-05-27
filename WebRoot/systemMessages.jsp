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
		$('#button1').click(function(){
			alert("555555");
			var t = $("#ID").attr("value");
			alert(t);
			//window.location.href="UserActionCheckSystemMessage?SMCheck=1&&smid="t;
		});
		$('#button2').click(function(){
			var t = $('#ID').values;
			window.location.href="UserActionCheckSystemMessage?SMCheck=2&&smid="t;
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
	width:100px;
	float:left;
 	overflow: hidden;
 	-o-text-overflow:ellipsis;
	text-overflow: ellipsis;
	white-space: nowrap;
	course:hand;
	}
.browse{
	width:220px;
	float:left;
	margin-left:4px;
	}
.reply{
	width:100px;
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
	width:100px;
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
<li class="f"><div class="title">标题</div><div class="browse">内容</div><div class="reply">发送者</div><div class="date">发表时间</div><div class="del">操作</div></li>
<s:iterator value="listSystemMessage" id="systemMessage">
<li><div class="title">好友添加</div>
<%----%>

<div class="browse"><s:property value="#systemMessage.master.name"/>请求加你为好友</div>
<div class="reply"><s:property value="#systemMessage.master.name"/></div>
<div class="date"><s:date name="date" format="yyyy-MM-dd HH:mm:ss"/></div>
<div class="del"><a href="UserActionCheckSystemMessage?SMCheck=1&&smid=<s:property value='#systemMessage.id'/> && friendId=<s:property value='#systemMessage.master.id'/>">同意</a> <a href="UserActionCheckSystemMessage?SMCheck=2&&smid=<s:property value='#systemMessage.id'/>&& friendId=<s:property value='#systemMessage.master.id'/>">忽略</a></div>

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

<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<style>
body{
	width:800px;}
ul li {
	list-style-type:none;
	padding:4px;
	font:Verdana, Geneva, sans-serif #000 14px;
	
	}
.date{
	color:#F90;
	float:left;
	}
.user{
	color:#933;
	}
.content{
	list-style-type:none;
	width:730px;
 	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	course:hand;	
	}
.people{
	color:#F90;
	}
.read{
	color:#ccc;
	float:right;
}
a{
		text-decoration:none;
		color:#333;}
hr{
	border:1px #CCC dotted;
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
</style>
</head>

<body>
<ul>
<s:iterator value="listLetter" id="letter">
<li class="date"><s:date name="date" format="yyyy-MM-dd HH:mm:ss"/></li>
<li class="user">To<a href="PageInfoActiontoFriendCenter?friendId=<s:property value='#letter.receiver.id'/>" class="people"> <s:property value="#letter.receiver.name"/>:</a></li>
<li class="content">
<a href="PageInfoActiontoReadOutMessag?letterId=<s:property value='#letter.id'/> " target="_black"><s:property value="#letter.content"/></a>
</li>
<hr noshade="noshade"/>
</s:iterator>
</ul>
 <div id="l_a" style="float:right;padding-right: 60px;" >
<script type="text/javascript">
 var i = 0;
 
 var isNext =<s:property value="lp.next"/>;
 var size = <s:property value="listLetter.size()"/>;//当前拿出来的长度
 var size1 = <s:property value="lp.pageSize"/>;  //规定好每页的长度
  
 var isPre = <s:property value="lp.pre"/>;
 var pageNum = <s:property value="lp.allPage"/>;

 if(size < size1){
		for(var j = size; j <= size1; j++){
			document.write("<br/>");
		}
		}
   	document.write("<center>")
   	for ( i=1; i<=pageNum; i++){
   		document.write(" <a href='PageInfoActiontoOutbox?letterNum="
   							+i+
   							"'><strong class='b'>"+i+"</strong></a>&nbsp;");
   	}

	var t = <s:property value="letterNum"/>;
   	document.write("<br/>当前第"+t+"页（共"+pageNum+"页）<br/>");

   if(isPre == 1){
   var a = t-1;
 
   document.write(" <a href='PageInfoActiontoOutbox?letterNum="
   							+a+
   							"'/>上一页 </a>");
   							
   }
  
   if(isNext == 1){
   var b = t+1;
   document.write(" <a href='PageInfoActiontoOutbox?letterNum="
   							+b+
   							"'>下一页 </a>");
   }
   

   	document.write("</center>")
</script>
</div>
</body>
</html>
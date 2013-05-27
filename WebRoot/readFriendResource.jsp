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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<script>
	$(document).ready(function() {
		$('p:even').addClass("redClass");
		
		$('p').hover(function(){
			$(this).addClass('hover')},function(){
				$(this).removeClass('hover');
		});
	});
</script>
<style>
body,p{
	margin: 0;
	padding: 0;
}
.redClass{
		background:#ccc;
	}
	.hover{
		background: #000;
	}
p{	
	padding-left:20px;
	padding-top:10px;
	height: 40px;
	font-size: 20px;
	color: #000;
	margin-top: px;
	
	}
 a{
		text-decoration:none; 
		}
   span {
	   display:inline-block; margin-left:20px;
	   }
.clickTitle {
	color:#666;
	
	}
.page {
	position: absolute;
	left: 400px;
	top: 680px;

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
<s:iterator value="resourcefileList" id="resourcefile">
<p>
<a href="UserActiondownFile?resourcefileId=<s:property value='#resourcefile.getId()'/>" class="clickTitle"><s:property value="#resourcefile.getFileName()"/></a>

</p>

</s:iterator>
</div>
<div style="	float: right;">
<script type="text/javascript">
   
     var i = 0;
     var size = <s:property value="resourcefileList.size()"/>;//当前拿出来的长度
     var size1 = <s:property value="pageInfoVo.getRfp().getPageSize()"/>;  //规定好每页的长度
             
	 var isNext =<s:property value="pageInfoVo.getRfp().getNext()"/>;
	
	 var isPre = <s:property value="pageInfoVo.getRfp().getPre()"/>;
	 var pageNum = <s:property value="pageInfoVo.getRfp().getAllPage()"/>;
	 var friendId = <s:property value="pageInfoVo.getFriendId()"/>;
	if(size < size1){
	for(var j = size; j <= size1; j++){
	
	document.write("<br/>");
	}
	}
		
	   	for ( i=1; i<=pageNum; i++){
	   			document.write(" <a href='PageInfoActiontoReadPersonResource?friendId="
	   							+friendId+
	   							"&&resourcePageNum="
	   							+i+
	   							"'><strong class='b'>"+i+"</strong></a>&nbsp;");
	   	}
	
		var t = <s:property value="pageInfoVo.getResourcePageNum()"/>;
	   	document.write("<br/>当前第"+t+"页（共"+pageNum+"页）<br/>");

	   if(isPre == 1){
	   var a = t-1;	 
	   document.write(" <a href='PageInfoActiontoReadPersonResource?friendId="
	   							+friendId+
	   							"&&resourcePageNum="+a+"'/>上一页</a>");	   							
	   }
	  
	   if(isNext == 1){
	   var b = t+1;
	   document.write(" <a href='PageInfoActiontoReadPersonResource?friendId="
	   							+friendId+
	   							"&&resourcePageNum="+b+"'>下一页</a>");
	   }
	

	   
</script>
</div>
</body>
</html>

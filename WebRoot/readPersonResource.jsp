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
<s:iterator value="resourcefileList" id="resourcefile">
<p>
<a href="UserActiondownFile?resourcefileId=<s:property value='#resourcefile.getId()'/>" class="clickTitle"><s:property value="#resourcefile.getFileName()"/></a>
<span><a href="UserActiondeleteFile?resourcefileId=<s:property value='#resourcefile.getId()'/>">删除</a></span>
</p>

</s:iterator>
</div>
<script type="text/javascript">
   
     var i = 0;
     var size = <s:property value="resourcefileList.size()"/>;//当前拿出来的长度
     var size1 = <s:property value="pageInfoVo.getRfp().getPageSize()"/>;  //规定好每页的长度
             
	 var isNext =<s:property value="pageInfoVo.getRfp().getNext()"/>;
	
	 var isPre = <s:property value="pageInfoVo.getRfp().getPre()"/>;
	 var pageNum = <s:property value="pageInfoVo.getRfp().getAllPage()"/>;
	 var userId = <s:property value="pageInfoVo.getUserId()"/>;
	if(size < size1){
	for(var j = size; j <= size1; j++){
	
	document.write("<br/>");
	}
	}
		
	   	for ( i=1; i<=pageNum; i++){
	   			document.write(" <a href='PageInfoActiontoReadPersonResource?userId="
	   							+userId+
	   							"&&resourcePageNum="
	   							+i+
	   							"'>"+i+"</a>&nbsp;");
	   	}
	
		var t = <s:property value="pageInfoVo.getResourcePageNum()"/>;
	   	document.write("<br/>当前第"+t+"页（共"+pageNum+"页）<br/>");

	   if(isPre == 1){
	   var a = t-1;	 
	   document.write(" <a href='PageInfoActiontoReadPersonResource?userId="
	   							+userId+
	   							"&&resourcePageNum="+a+"'/>上一页</a>");	   							
	   }
	  
	   if(isNext == 1){
	   var b = t+1;
	   document.write(" <a href='PageInfoActiontoReadPersonResource?userId="
	   							+userId+
	   							"&&resourcePageNum="+b+"'>下一页</a>");
	   }
	

	   
</script>

</body>
</html>

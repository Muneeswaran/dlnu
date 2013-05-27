<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="css/css_about.css" rel="stylesheet" type="text/css">
</head>

<body>
<div id="topic">
<ul>
<p style="padding-left:350px;font-size:16px;font-family: Tahoma, Geneva, sans-serif;	">关于<strong><s:property value="key"/></strong>的帖子</p>
<li><div class="title">标题</div><div class="author">作者</div><div class="browse">浏览数</div><div class="reply">回复数</div><div class="date">发表时间</div></li>
<hr/>
<s:iterator value="topicList" id="topic">
<li><div class="title"><a href="PageInfoActionreadTopicPage?topicId=<s:property value='#topic.getId()'/>" target="_black"><s:property value="#topic.getTitle()"/></a></div>
<div class="author"><a href="UserActionmakeFriend?friendId=<s:property value='#topic.user.id'/>" class="barname"><s:property value="#topic.getUser().getName()"/></a></div>                       
<div class="browse"><s:property value="#topic.countBrowse"/></div>
<div class="reply"><s:property value="#topic.countComment"/></div>
<div class="date"><s:date name="date" format=" HH:mm:ss"/></div>
</li>
<hr/>
</s:iterator>
</ul>
</div>

<div id="foot">
    <script type="text/javascript">
     var i = 0;
  
   var isNext =<s:property value="topicPager.getNext()"/>;
	 var size = <s:property value="topicList.size()"/>;//当前拿出来的长度
   var size1 = <s:property value="topicPager.getPageSize()"/>;  //规定好每页的长度
   var isPre = <s:property value="topicPager.getPre()"/>;
	 var pageNum = <s:property value="topicPager.getAllPage()"/>;
	
    var  key = "<s:property value='key'/>";


 if(size < size1){
		for(var j = size; j <= size1; j++){
			document.write("<br/>");
		}
		}
	document.write("<hr/>")
	document.write("<center>")
	for ( i=1; i<=pageNum; i++){
		document.write(" <a href='SearchActiontoAboutTopic?key="+key+"&&topicPageNum="
							+i+
							"'>"+i+"</a>&nbsp;");
	}
	
	var t = <s:property value="topicPageNum"/>;
	document.write("<br/>当前第"+t+"页（共"+pageNum+"页）<br/>");
	if(isPre == 1){
		var a = t-1;

		document.write(" <a href='SearchActiontoAboutTopic?key="+key+"&&topicPageNum="
									+a+
									"'/>上一页 </a>");
									
		}

		if(isNext == 1){
		var b = t+1;
		document.write(" <a href='SearchActiontoAboutTopic?key="+key+"&&topicPageNum="
									+b+
									"'>下一页 </a>");
		}


			document.write("</center>")


</script>
</div>
</body>
</html>

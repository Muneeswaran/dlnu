<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta charset="utf-8" >

<link href="css/css-readNews.css" rel="stylesheet" type="text/css"/>
</head>

<body style="background-color:#fff;">
<jsp:include page="header.jsp" />
<div class="bignav" style="background: url(img/sliderbg.jpg);
					border-bottom: 10px solid #fff;
					color: #FFFFFF;
					font-size: 20px;
					font-weight: bold;
					height: 90px;
					line-height: 90px;
					text-shadow: 1px 1px 1px #000000;">
		<div style="padding:5px;margin-left:150px;font-family:font-size:30px;font-weight: bold;">新闻:读取校园小事</div>
        <div class="container">
        
        </div>
 	</div>
<div id="headerr">
<p id="nav">您的位置：<a href="PageInfoActionfirstPage">主页</a><strong>&gt;</strong>新闻<strong>></strong></p>
<hr>
</div><!--#header-->
<div id="content">
	<table style="table-layout:fixed;" cellspacing="0" cellpadding="0" width="100%" height="100%">
	  <tbody>
	    <tr>
	      <td class="left">
          <div id="title"><s:property value="getNews().getName()"/></div>
          <div id="detail">发表时间：<span><s:property value="getNews().getDate()"/></span></div>
          <div id="text"> <s:property value="getNews().getContent()" escape="false"/>
</div>
          </td>
	      <td style="width:160px; height:300px;" class="right">
          <span class="hot">热点新闻</span>
          <ul>
           <s:iterator value="newsList" id="news">
          <li><a href="PageInfoActionreadNewsPage?newsId=<s:property value="#news.getId()" />"><s:property value="#news.getName()" /></a></li>
           </s:iterator>
          </ul>
          </td>
	    </tr>
	  </tbody>
	</table>
</div><!--#content-->
 <jsp:include page="footer.jsp"/>
</body>
</html>

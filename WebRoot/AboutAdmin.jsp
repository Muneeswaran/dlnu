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

<link href="css/css_about.css" rel="stylesheet" type="text/css" />
</head>

<body>
<jsp:include page="header.jsp" />
	
	
		<div class="bignav" style="background: url(img/sliderbg.jpg);
					border-bottom: 10px solid #fff;
					color: #FFFFFF;
					font-size: 20px;
					font-weight: bold;
					height: 90px;
					line-height: 90px;
					text-shadow: 1px 1px 1px #000000;">
		<div style="padding:5px;margin-left:190px;font-family:Tahoma, Geneva, sans-serif;font-size:35px;font-weight: bold;">关于</div>
        <div class="container">
        
        </div>
 	</div>
<div id="nav" style=" background:#fff; height: 550px;">
 <div id="top">
            <!--导航条开始-->
<div id="menu">

<ul>
<li><a href="PageInfoActionfirstPage">首页</a></li>
<li><a href="SearchActiontoAboutTopic?key=<s:property value='key'/>" target="frame">关于<s:property value="key"/>的帖子</a></li>
<li><a href="SearchActiontoAboutResource?key=<s:property value='key'/>" target="frame">关于<s:property value="key"/>的资源</a></li>

</ul>
</div>
<!--导航结束-->
<!--框架部分-->
<iframe src="SearchActiontoAboutTopic?key=<s:property value='key'/>" name="frame" id="f" scrolling="no" frameborder="0"  ></iframe>
<!--框架结束-->

</div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>

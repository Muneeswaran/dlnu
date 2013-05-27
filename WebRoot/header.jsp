<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName

()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    

    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</script>
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>






<script type="text/javascript" src="js/jquery.sticky.js"></script>
 <script>
    $(window).load(function(){
      $("#header").sticky({ topSpacing: 0, center:true, className:"hey" });
    });
  </script>

<!--这是选择块-->


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<style type="text/css">
			#tab{
				display:none;}
			body{
				background:#f1efef;
				margin:auto;
				padding:0;
				}
				.logo{
					float:left;
					margin-top:15px;
				}
				img{border:0;}
			a{
				text-decoration:none;
				}
			li{
				list-style-type:none;
				}
				
			.container { 
				position: relative; 
				width: 960px; 
				margin: 0 auto; 
				padding: 0;
				background:none repeat scroll 0 0 #FAFAF6;
				}
			.headerinside a img{
				width:100px;
				height:50px;
				}
	
			.header{
				background: none repeat scroll 0 0 #FAFAF6;
				border-bottom:2px solid #ADC760;
				height:70px;
				position:relative;
				width:100%;
				z-index:21312313;
				font-size:14px;
				}
			.menu{
				float:right;
				font-size:13px;
				
				text-shadow:0 1px 1px #FFFFFF;
				margin-top:25px;
				}
			.menu li{
				position:relative;
				display:inline;
				text-decoration:none;
				margin-left:15px;
				}
			.menu li a{
				color: #434343;
				font-family:Tahoma, Geneva, sans-serif;				
				font-size:12px;
				
				padding-bottom:20px;
				text-decoration:none;
				}
			.menu li a:hover {
				color:#adc769;
				}
			.sub-menu{
				background:none repeat scroll 0 0 #FFFFFF;
				border-top: 2px solid #adc760;
				box-shadow: 0 4px 15px rgba(0,0,0,0.2);
				display:none;
				left:-10px;
				margin-left:0;
				margin-top:15px;
				padding:3px 10px;
				position: absolute;
			    z-index: 242424242;
				}
			.sub-menu li{
				background:none repeat scroll 0 0 transparent;
				border-bottom:1px solid #EEEEEE;
				margin-left:1px;
				min-width:150px;
				padding-left:0;
				padding-right:0;
				margin-bottom:0px;
				float:left;
				position:relative;
				}
			.sub-menu li a {
    			display: block;
    			padding-bottom: 7px;
    			padding-top: 7px;
				}
				/*下面的样式是用来改变选着文本时的背景色和前景色的*/
			::selection {
				background: #adc760;
				color:#fff;
				}
			::-moz-selection {
				background: #adc760;
				color:#fff;
				}
				/*end*/
				
			.sub-menu li:last-child {
				border-bottom:0px;
				}

<!--header end-->
</style>
  </head>
  
  <body>
   <div class="header" id="header">
    	<div class="container">
        	<div class="headerinside sixteen columns">
            	<a href="PageInfoActionfirstPage"><img class="logo" alt="" src="img/122222.png"/></a>
             <div class="um" style="background: #FAFAF6; float:left; margin-top: 40px; margin-left: 40px;">
                	  <% if (session.getAttribute("userId") == null) 
        {%>
    <a href="LoginActiontoLoginPage">登录</a>|<a href="RegisterActiontoRegisterPage">注册</a>
    <%} 
			else {%>
			
		  <a href="PageInfoActiontoPersonCenter?userId=<%=session.getAttribute("userId") %>" style="color:red"><%=session.getAttribute("userName") %>(<%=session.getAttribute("msCount") %>)</a>
<%--		  <a href="PageInfoActiontoPersonCenter?userId=<%=session.getAttribute("userId") %>" class="welcome">您已登录</a>--%>
		   <a href="QuitAction">注销用户</a>
		<%	}  %>
                </div>
                <ul class="menu">
                     <li><a href="PageInfoActiontopicListPage">帖子</a></li>
                    <li><a href="PageInfoActiontoResourcePage">资源</a>

                    <li><a href="PageInfoActiontoNewsList">新闻</a>

                    </li>
                    <li><a href="UserActiontoWriteTopicPage">发帖</a>

                    </li>
                   
                   
                    </ul>

            </div>
        </div>
    </div>
    
  </body>
</html>

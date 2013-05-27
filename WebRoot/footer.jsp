<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
          

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		<!--footer-->
			.footer {
  			   border-top: 3px solid #ADC760;
 			   min-height: 100px;
			   width: 100%;
			   font-size:1px;
				}
			.fmenu{				
				padding:5px;
				color:#CCC;
				text-align:center;
				}
			.fmenu a,#fmenu a:visited,.copy a,.copy a:visited{
				text-decoration:none;
				font:Georgia, "Times New Roman", Times, serif;
				font-size:16px;				
				color:#CCC;
				font-size:14px
				}
			.fmenu a:hover,.copy a:hover{
				color:#fff;
				}
			.copy{
				background:#1F1F1F;
				width: 100%;
				height: 40px;
				border-top: 1px solid #191919;
				text-align:center;
				padding-top: 6px;
				font-size:14px;
				}
				.fmenu a img{
					height: 40px;
					width: 60px;
				}
	</style>

  </head>
  
  <body>
    <!--footer-->
<div class="footer" style=" border-top: 3px solid #ADC760;max-height: 100px; background:#262626; width: 100%;">
<div class="fmenu">
<a href="JavaRoom.jsp">关注我们&nbsp;→&nbsp;|</a>
<a>联系我们&nbsp;&nbsp;→&nbsp;&nbsp;QQ:356505472|TEL：18842610650</a>|<a href="ManagerActiontoManagerPage">后台入口</a>
<a style="color: #215645;">总访问量：<%=session.getAttribute("allv") %>&nbsp;&nbsp;|今日访问人数：<%=session.getAttribute("tv") %>&nbsp;&nbsp;</a></br></br>
<%--<a style="color: #215645;">今日访问人数：11111&nbsp;→&nbsp;|</a></br></br>--%>
<a href="http://net.china.com.cn" target="_blank"><img src="images/police.png"></a>&nbsp;&nbsp;
<a href="http://www.bj.cyberpolice.cn" target="_blank"><img src="images/110.png"></a>&nbsp;&nbsp;
<a href="http://www.ctws.com.cn" target="_blank"><img src="images/wu.png"></a>&nbsp;&nbsp;
<a href="http://www.itrust.org.cn" target="_blank"><img src="images/s.png"></a>

</div>



</div>
<div class="copy">Copyright©2013&nbsp;&nbsp;大连民族学院李锡祚JAVA工作室</div>
  </body>
</html>
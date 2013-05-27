<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<link rel="stylesheet" href="css/css.css"/>
<script language="javascript" src="js/js.js"></script>
<script language="javascript" src="js/ValidateCode.js"></script>
</head>


</head>
<body class="merge_regist">
<div class="wrap">
	<div class="head">
		<div class="logo"><a href="PageInfoActionfirstPage" class="logolink" title="dlnuHome"><!--<img src="image/logo/DLNUHOME.png" width="194" />--></a><div class="clearit"><img width="194" src="image/logo/DLNUHOME.png" /></div></div> 
		
	</div>
	<div class="main">
		<div class="main_top"></div>
		<div class="main_cen">
			<div class="reg_tab">
				<ul>
					<li id="banben_li"><a href="">DLNU登陆</a></li>
					<li id="banben_li"><a href="PageInfoActionfirstPage">返回主页</a></li>
				</ul>
				<div class="clearit"></div>
			</div>
			<!--<div class="reg_title"><strong>注册DLNUhome30秒</strong> <a href="#">请直接登录</a></div>-->
			<div class="mainCenT1">
				<form id="myForm" name="vForm" method="post" action="LoginActiondoLogin" onsubmit="return checkForm()">
					<ul class="easyReg">
						
						<%
							if (session.getAttribute("tip") != null){
								%><p><%=session.getAttribute("tip")%></p><% 
								session.setAttribute("tip", "");
								}
						%>
						<li>
							<label>论坛昵称：</label>
							<div class="inputbox"> <span class="input"><cite>
							<input id="inputNick" class="ipt" type="text" name="userName" maxlength="20" style="background-color:#CCC;"/></cite></span></div>
						</li>
						
						<li>
							<label>登录密码：</label>
							<div class="inputbox"> <span class="input"><cite>
								<input id="inputPwd" class="ipt" type="password" name="userPassword" style="background-color:#CCC;" />
								</cite></span></div>
						</li>
						
						<li>
							<label>输入验证码：</label>
						 <div class="inputbox">
						 <input  id="cv" type="text" name="securityCode" onblur="checkUserid(this.value)" style="width: 50px"/>
						
                         <img id="ValidateCodeImg" src="rand.action"/>
                         <a style="float: right; margin-right: 50px;" href="javascript:changeAndClear()">换一张？</a>
                         
						 </div>
						
						</li>
					  
						<div>
							<input id="inputSubmit" value=" " type="submit" style="background-image:url(image/login_btn.gif); width:89px; height:45px"/>
						</div>					
					</ul>
				</form>
			</div>
			<div class="clearit"></div>
		</div>
		<div class="main_bottom"></div>
	</div>
	<div class="footer" align="center">
	<!--<ul>
		<li><a href="#">欢迎批评指正</a></li>
		<li><a href="#">DLNU简介</a></li>
		<li><a href="#">联系我们</a></li>
		<li><a href="#">广告朋友</a></li>
		</ul>-->
		<!--<div>&nbsp;</div>-->
		<h3 style=" color:#666;">版权所有Copyright © 2012 JAVA Corporation, All Rights Reserved 李锡祚JAVA工作室 <a href="#" target="_blank"></a> </h3>
	</div>

</div>

</body>
</html>

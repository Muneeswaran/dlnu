<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link href="css/css_personCenter.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-1.7.1.js"></script>
<script>
$(document).ready(function(){
	$(".tab li").hover(function(){
			$(this).addClass('hover')},function(){
				$(this).removeClass('hover');
		});
	$(".tab li").bind("click",function(){
		$(this).addClass("onhover").removeClass("tabLi").siblings("li").removeClass("onhover").addClass("");
		});
		
		$("#readPersonTopic").click(function(){
		$("#outpage").attr("src","PageInfoActiontoFriendTopices?friendId=<s:property value='u.getId()'/>");
		});
		$("#readPersonResource").click(function(){
		$("#outpage").attr("src","PageInfoActiontoReadFriendResource?friendId=<s:property value='u.getId()'/>");
		});
		
		$("#personInformation").click(function(){
		$("#outpage").attr("src","PageInfoActionshowFriendInfo?friendId=<s:property value='u.getId()'/>");
		});
		
		$("#showFriends").click(function(){
			$("#fridentList").toggle();
			});
		$("#closeTopic").click(function(){
			$("#openDiv").hide();
			
			});
			$(".onClickTipy").dblclick(function(){
				$("#openDiv").show();
				});
		
});
</script>
<style type="text/css">
	.top_c ul{padding:0 0 0 10px;
	margin:0px;
	list-style:none;
	height:35px;
	background:#adc720;
	
	box-shadow: 0px 3px 20px #B9B7B7;}
	
	.top_c ul li a{
	color:#fff;
	
	}
</style>
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
		<div style="padding:5px;margin-left:190px;font-family:Tahoma, Geneva, sans-serif;font-size:35px;font-weight: bold;">好友资料</div>
        <div class="container">
        
        </div>
 	</div>
 	
 	
 	
<div class="content" style="margin-top: 20px; background:#fff;">

		<div class="top_c" >
		           	  
							<ul>
		                	<li><a href="PageInfoActionfirstPage">朋友资料</a></li>
		                     <s:iterator value="categoryList" id="category">
		      <li><a href="PageInfoActionsecondPage?categoryId=<s:property value="#category.getId()"/>"><s:property value="#category.getName()"/></a></li>
		   </s:iterator>
		                </ul>
		            </div>
            

<div class="menuu" >
<ul class="tab" >
<li><a href="PageInfoActionfirstPage">首页</a></li>
<li class="onhover" id="personInformation"><s:property value="u.getName()"/>的档案</li>
<li class="" id="readPersonTopic"><s:property value="u.getName()"/>的帖子</li>
<li class="" id="readPersonResource"><s:property value="u.getName()"/>的资源</li>
</ul> </div><!--菜单结束-->
<div class="clear"></div>
<div class="showContent">
<iframe id="outpage" src="PageInfoActionshowFriendInfo?friendId=<s:property value='u.getId()'/>"></iframe>
</div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>

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

<link href="css/css_personCenter.css" rel="stylesheet" type="text/css">
<link href="css/common.css" rel="stylesheet" type="text/css">
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
		$("#outpage").attr("src","PageInfoActiontoPersonTopic?userId=<s:property value='pageInfoVo.getUserId()'/>");
		});
		$("#readPersonResource").click(function(){
		$("#outpage").attr("src","PageInfoActiontoReadPersonResource?userId=<s:property value='pageInfoVo.getUserId()'/>");
		});
		$("#readJoinTopic").click(function(){
		$("#outpage").attr("src","PageInfoActiontoReadJoinTopic?userId=<s:property value='pageInfoVo.getUserId()'/>");
		});
		$("#personInformation").click(function(){
		$("#outpage").attr("src","PageInfoActionshowUserInfo?userId=<s:property value='pageInfoVo.getUserId()'/>");
		});
		$("#informationChange").click(function(){
		$("#outpage").attr("src","PageInfoActioninformationChange?userId=<s:property value='pageInfoVo.getUserId()'/>");
		});
		$("#outbox").click(function(){
		$("#outpage").attr("src","PageInfoActiontoOutbox");
		});
		$("#inbox").click(function(){
		$("#outpage").attr("src","PageInfoActiontoInbox");
		});
		$("#systemMessages").click(function(){
		$("#outpage").attr("src","PageInfoActionsystemMessages");
		});
		$("#topicRemind").click(function(){
		$("#outpage").attr("src","PageInfoActiontopicRemind");
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
	.floatL a{
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
		<div style="padding:5px;margin-left:180px;font-family:Tahoma, Geneva, sans-serif;font-size:35px;font-weight: bold;">个人资料</div>
        <div class="container">
        
        </div>
 	</div>
	

<div class="content" style="margin-top: 20px; background:#fff;">
<div class="top_c" >
		           	  
							<ul>
		                	<li><a href="#">个人资料</a></li>
		                     <s:iterator value="categoryList" id="category">
		      <li><a href="PageInfoActionsecondPage?categoryId=<s:property value="#category.getId()"/>"><s:property value="#category.getName()"/></a></li>
		   </s:iterator>
		                </ul>
		            </div>


<div class="menuu" >
<ul class="tab" style="margin-left: -60px;">
<li><a href="PageInfoActionfirstPage">首页</a></li>
<li class="onhover" id="personInformation">我的档案</li>
<li class="" id="readPersonTopic">帖子</li>
<li class="" id="readPersonResource">资源</li>
<li class="" id="readJoinTopic">我参与的帖子</li>
<li class="" id="informationChange">档案修改</li>
<li class="" id="outbox">发信箱</li>
<li class="" id="inbox">收信箱(<s:property value="countNotReadLetter"/>)</li>
<li class="" id="systemMessages">好友提醒(<s:property value="notCheck"/>)</li>
<li class="" id="topicRemind">帖子动态(<s:property value="topicRemind"/>)</li>
</ul> </div><!--菜单结束-->
<div class="clear"></div>
<div class="showContent">
<iframe id="outpage" src="PageInfoActionshowUserInfo?userId=<s:property value='pageInfoVo.getUserId()'/>"></iframe>
</div>

</div>








<DIV id=floatTools class=float0831>
  <DIV class=floatL >
  <A  id=aFloatTools_Show class=btnOpen title=查看好友列表 
	onclick="javascript:$('#divFloatToolsView').animate({width: 'show', opacity: 'show'}, 'normal',function(){ $('#divFloatToolsView').show(); });$('#aFloatTools_Show').attr('style','display:none');$('#aFloatTools_Hide').attr('style','display:block');" 
href="javascript:void(0);">展开好友</A> 


<A style="DISPLAY: none; " id=aFloatTools_Hide class=btnCtn title=关闭好友列表 
onclick="javascript:$('#divFloatToolsView').animate({width: 'hide', opacity: 'hide'}, 'normal',function(){ $('#divFloatToolsView').hide(); });$('#aFloatTools_Show').attr('style','display:block');$('#aFloatTools_Hide').attr('style','display:none');" 
href="javascript:void(0);">收缩好友</A> </DIV>



  <DIV id=divFloatToolsView class=floatR>
    
    <DIV class=cn>
      <UL>
        <LI class=top>
          <SPAN class=icoZx>好友列表</SPAN>
        </LI>
        
        <s:iterator value="userList" id="user">
<LI><a class=icoTc  href="UserActiontoPostMessage?reId=<s:property value='#user.id'/>  "><s:property value="#user.getName()"/></a> <a style="float: right;" href="UserActiondeleteFriend?friendId=<s:property value='#user.id'/>  ">×</a></LI>
</s:iterator>
        
        
       
      </UL>
    
     
    </DIV>
  </DIV>
</DIV>








<%--<div id="openDiv">--%>
<%----%>
<%--<form action="#" method="post">--%>
<%----%>
<%--<div class="rember">--%>
<%--<p>dfffffffg</p></div>--%>
<%--<div class="inWords"><textarea rows="8" cols="47"></textarea></div>--%>
<%--</form>--%>
<%-- <button id="subTopic">提交</button><button id="closeTopic">关闭</button>--%>
<%--</div>--%>
<jsp:include page="footer.jsp"/>
</body>
</html>

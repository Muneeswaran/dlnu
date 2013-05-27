<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">

<link href="css/css-readPost.css" rel="stylesheet" type="text/css">
<link href="css/css-tableStyle.css" rel="stylesheet" type="text/css">

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
		<div style="padding:5px;margin-left:190px;font-family:Tahoma, Geneva, sans-serif;font-size:35px;font-weight: bold;">收到的信息</div>
        <div class="container">
        
        </div>
 	</div>
<div id="main">
	<div id="header">
   
    
    <ul id="nav">
    	<li><a href="PageInfoActionfirstPage">首页</a></li>
     <s:iterator value="categoryList" id="category">
      <li><a href="PageInfoActionsecondPage?categoryId=<s:property value="#category.getId()"/>"><s:property value="#category.getName()"/></a></li>
   </s:iterator>
    </ul>
    <div class="clear"></div>
    <hr>
    </div><!--#header-->
	<div id="content">

    <center>
    <div id="title">From <s:property value="letter.sender.name"/></div>
    </center>
       <table id="post-393058130" class="post " cellspacing="0" cellpadding="0" border="0" data-post-id="393058130">
      <colgroup>
      <col width="180">
      <col>
      </colgroup>
      <tbody>
      <tr>
      <td class="wirter" valign="top" rowspan="4">
      <dl class="user_info ">
      <dt class="user_head" data-username="thdxs">
      <a target="_blank" href="">
      <img class="avatar" src="images/head.jpg" alt="thdxs">
      </a>
      </dt>
      </dl>
      </td>
      <td style="display: none;"></td>
      </tr>
      <tr class="post_info " data-floor="2" data-username="thdxs">
      <td class="data">
      <span class="fr">
    
      </span>
      <span class="time"> 发表于：<s:property value="letter.date"/></span>
      </td>
      </tr>
      <tr>
      <td>
      <div class="post_body"><s:property value="letter.content" escape="false"/>
       </div>
      </td>
 
      </tbody>
      </table>
      
 
      <div class="innerNav">
    <a href="UserActiontoPostMessage?reId=<s:property value='letter.sender.id'/>" class="tend">回复</a>
    </div><!--.innerNav-->
    
    </div><!--#content-->
    <div class="clear"></div>

</div>

</script>
<jsp:include page="footer.jsp"/>
</body>
</html>

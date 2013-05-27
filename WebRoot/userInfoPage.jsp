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

 <link href="css_font.css" rel="stylesheet" type="text/css">
 <link href="css_person.css" rel="stylesheet" type="text/css">
 <link type="text/css" href="jquery-ui-1.7.2.custom.css" rel="stylesheet" />	
<script type="text/javascript" src="jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="jquery-ui-1.7.2.custom.min.js"></script>
<script type="text/javascript">
			$(function(){

			$('#tabs').tabs();
			});
</script>
</head>

<body>
 <div id="nav">
 <div id="top">
        	<div class="top_t">
            	<div class="logo">
                	<a href="firstpage.html">
            		<img src="images/logo.jpg" width="198" height="100" alt="IT家园" border="none">
                	</a>
             	</div>
                <div class="um">
                	<p>
                    	<a href="LoginActiontoLoginPage">登陆</a>
                        <span class="pipe">|</span>
                        <a href="RegisterActiontoRegisterPage">注册</a>
                        <span class="pipe">|</span>
<!--                        <a href="">忘记密码</a>-->
                    </p>
                </div>
            </div>
            <div class="top_c">
           	  <a href="#" id="qmenu"><img src="images/quick .png" style="border:none;"/></a>
				<ul>
                	<li>	<a href="PageInfoActionfirstPage">主页</a></li>
                    <s:iterator value="categoryList" id="category">
								<li>
									<a
										href="PageInfoActionsecondPage?categoryId=<s:property value="#category.getId()"/>"><s:property
											value="#category.getName()" /> </a>
								</li>
							</s:iterator>
                </ul>
            </div>
            <div class="top_b">
<!--            	<a href="#">-->
                	<img src="images/photo.jpg" width="880"; style="border:solid #CCC 1px;"  />
<!--                </a>-->
            </div>	
      </div>
   <!-- the end of id=header -->
<!--     <div id="trans">-->
<!--      		<a href="#" class="home"><img src="images/home.png" height="18" style="border:none;"/></a>-->
<!--      		<a href="#">论坛</a>-->
<!--            <em>></em>-->
<!--            <a href="#">个人资料</a>-->
<!-- 	-->
<!--      </div>-->
      
   <div id="main">
   <div id="left">
   <p><strong>个人信息</strong></p>
   <p id="headPhoto"><img src="images/4020.png"></p>
   	<ul>
						<li class="information">
							用户名：
							<strong><s:property value="u.getName()" /> </strong>
						</li>
						<li class="information">
							性别：
							<strong><s:property value="u.getSex()" /> </strong>
						</li>
						<li class="information">
							专业：
							<strong><s:property value="u.getMajor()" /> </strong>
						</li>
						<li class="information">
							email：
							<strong><s:property value="u.getEmail()" /> </strong>
						</li>
						<li class="information">
							民族：
							<strong><s:property value="u.getNation()" /> </strong>
						</li>
						<li class="information">
							个人说明：
							<strong><s:property value="u.getState()" /> </strong>
						</li>

					</ul>


   </div><!-- the end of id=left -->
   <div id="tabs">
   <ul style="height:40px;">       <li><a href="#tab1"><span>修改个人信息</span></a></li>
     <li><a href="#tab2"><span>上传资源</span></a></li>
     <li><a href="#tab3"><span>所有帖子</span></a></li>
     <li><a href="#tab4"><span>站内信（<em>0</em>）</span></a></li>
   </ul>
 
<div id="tab1" class="show">
	<form class="show1"
							action="UserActionalterUserInfo?userId=<s:property value='pageInfoVo.getUserId()'/>"
							method="post">

							<br>
							<label>
								民 &nbsp;&nbsp;族：
								<input type="text" id="nation" name="nation" 
									value="<s:property value='u.getNation()'/>"/>
										性&nbsp;&nbsp;别：
							<select name="userSex">

								<s:if test='u.getSex()=="男"'>

									<option value="男">
										男
									</option>
									<option value="女">
										女
									</option>
								</s:if>

								<s:else>
									<option value="女">
										女
									</option>
									<option value="男">
										男
									</option>
								</s:else>
							</select>
							</label>
							

						
							<br>
							<label>
								专&nbsp;&nbsp;业:
								<input type="text" id="major" name="major"
									value="<s:property value='u.getMajor()'/>"/>
							</label>
						

							<br>
							<label>
								个人说明：
								<textarea name="address" cols="30" rows="3"
									value="<s:property value='u.getState()'/>"></textarea>
							</label>
<!--							<br>-->
<!--							<label>-->
<!--								修改头像:-->
<!--								<input type="file" id="file" name="file">-->
<!--							</label>-->
							<br>
							<input type="submit" value="确定">
							&nbsp;
							<input type="reset" value="重置">
						</form>
</div>
<div id="tab2" class="show">

 <s:iterator value="resourcefileList" id="resourcefile">
<p class="page">
<a href="UserActiondownloadFile?resourcefileId=<s:property value='#resourcefile.getId()'/>" class="contentCss">
                <s:property value="#resourcefile.getFileName()"/></a>
<a href="UserActiondeleteFile?resourcefileId=<s:property value='#resourcefile.getId()'/>" class="aCss">删除</a>

							</p>
							</s:iterator>

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
	   			document.write(" <a href='PageInfoActionshowUserInfo?userId="
	   							+userId+
	   							"&&resourcePageNum="
	   							+i+
	   							"'>"+i+"</a>&nbsp;");
	   	}
	
		var t = <s:property value="pageInfoVo.getResourcePageNum()"/>;
	   	document.write("<br/>当前第"+t+"页（共"+pageNum+"页）<br/>");

	   if(isPre == 1){
	   var a = t-1;	 
	   document.write(" <a href='PageInfoActionshowUserInfo?userId="
	   							+userId+
	   							"&&resourcePageNum="+a+"'/>上一页</a>");	   							
	   }
	  
	   if(isNext == 1){
	   var b = t+1;
	   document.write(" <a href='PageInfoActionshowUserInfo?userId="
	   							+userId+
	   							"&&resourcePageNum="+b+"'>下一页</a>");
	   }
	

	   
</script>

</div>

<div id="tab3" class="show">

<s:iterator value="topicList" id="topic">
		<p class="page">
								<a
									href="PageInfoActionreadTopicPage?topicId=<s:property value="#topic.getId()"/>"
									class="contentCss"><s:property value="#topic.getTitle()" />
								</a>
								<a
									href="UserActiondelectTopic?topicId=<s:property value="#topic.getId()"/>&&userId=<s:property value="getUserId()"/>"
									class="aCss">删除</a>
									</p>
						</s:iterator>

<script type="text/javascript">
     var i = 0;
   
	 var isNext =<s:property value="pageInfoVo.getTp().getNext()"/>;
	 var size = <s:property value="topicList.size()"/>;//当前拿出来的长度
     var size1 = <s:property value="pageInfoVo.getTp().getPageSize()"/>;  //规定好每页的长度
	 var isPre = <s:property value="pageInfoVo.getTp().getPre()"/>;
	 var pageNum = <s:property value="pageInfoVo.getTp().getAllPage()"/>;
	 var userId = <s:property value="pageInfoVo.getUserId()"/>;
	 if(size < size1){
			for(var j = size; j <= size1; j++){
			document.write("<br/>");
			}
			}
	   	document.write("<center>")
	   	for ( i=1; i<=pageNum; i++){
	   		document.write(" <a href='PageInfoActionshowUserInfo?userId="
	   							+userId+
	   							"&&topicPageNum="
	   							+i+
	   							"'>"+i+"</a>&nbsp;");
	   	}
	
		var t = <s:property value="pageInfoVo.getTopicPageNum()"/>;
	   	document.write("<br/>当前第"+t+"页（共"+pageNum+"页）<br/>");

	   if(isPre == 1){
	   var a = t-1;
	 
	   document.write(" <a href='PageInfoActionshowUserInfo?userId="
	   							+userId+
	   							"&&topicPageNum="
	   							+a+
	   							"'/>上一页");
	   							
	   }
	  
	   if(isNext == 1){
	   var b = t+1;
	   document.write(" <a href='PageInfoActionshowUserInfo?userId="
	   							+userId+
	   							"&&topicPageNum="
	   							+b+
	   							"'/>下一页");
	   }
	   

	   	document.write("</center>")
</script>
 </div>
 <div id="tab4" class="show">
 <p class="page"><a href="#" class="contentCss">XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</a>
<a href="#" class="aCss">删除</a>
<a href="#" class="aCss">浏览</a>
</p>
<strong><a href="#">上一页</a>|<a href="#">下一页</a></strong>
 </div>
   </div><!-- the end of id=tabs -->
   
   </div><!-- the end of id=main -->
    <div id="foot">
      		<hr/>
            <span>Power BY JAVA @xxx</span>
            <div class="bot_r">
            	<a href="#">联系我们</a> | <a href="#">联系我们</a> | <a href="#">联系我们</a><br/><br/>
                <a href="#"><img src="images/sina.png" style="border:none;"/>关注我们微博</a>&nbsp;&nbsp;|&nbsp;&nbsp;
                <a href="images/tencent.png"><img src="images/tencent.png" style="border:none;"/>关注我们微博</a>
            </div>
      </div>
   
   </div><!-- the end of id=layout -->
   
   
</body>
</html>
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

<link href="css/css_postSend.css" rel="stylesheet" type="text/css">

<%--<link rel="stylesheet" href="themes/default/default.css" />--%>
<%--<link rel="stylesheet" href="plugins/code/prettify.css" />--%>

 <link href="css/css_font.css" rel="stylesheet" type="text/css">
 <link href="css/css_index.css" rel="stylesheet" type="text/css">


<link rel="stylesheet" href="kindeditor-3.5.6-zh_CN/themes/default/default.css" />
	<link rel="stylesheet" href="kindeditor-3.5.6-zh_CN/plugins/code/prettify.css" />
	<script charset="utf-8" src="kindeditor-3.5.6-zh_CN/kindeditor.js"></script>
	<script charset="utf-8" src="kindeditor-3.5.6-zh_CN/lang/zh_CN.js"></script>
	<script charset="utf-8" src="kindeditor-3.5.6-zh_CN/plugins/code/prettify.js"></script>
	<script charset="utf-8" src="kindeditor-3.5.6-zh_CN/kindeditor.js">	</script>
<script type="text/javascript">
KE.show({    
id : 'tg',//TEXTAREA输入框的ID 
imageUploadJson : '../../jsp/upload_json.jsp',  //注意路径别写错！！
   fileManagerJson : '../../jsp/file_manager_json.jsp',  
   allowFileManager : true, 
   allowUpload : true, //允许上传图片 
   afterCreate : function(id) {  
       KE.event.ctrl(document, 13, function() {  
           KE.util.setData(id);  
           document.forms['example'].submit();  
       });  
       KE.event.ctrl(KE.g[id].iframeDoc, 13, function() {  
           KE.util.setData(id);  
           document.forms['example'].submit();  
       });  
   } 
}); 
</script>



<script type="text/javascript">
KE.show({    
id : 'tg',//TEXTAREA输入框的ID 
imageUploadJson : '../../jsp/upload_json.jsp',  //注意路径别写错！！
   fileManagerJson : '../../jsp/file_manager_json.jsp',  
   allowFileManager : true, 
   allowUpload : true, //允许上传图片 
   afterCreate : function(id) {  
       KE.event.ctrl(document, 13, function() {  
           KE.util.setData(id);  
           document.forms['example'].submit();  
       });  
       KE.event.ctrl(KE.g[id].iframeDoc, 13, function() {  
           KE.util.setData(id);  
           document.forms['example'].submit();  
       });  
   } 
}); 


</script>
</head>

  
<body>
  
   <div id="layout">
   <div id="header">
   <div id="top">
   <div id="logo">
   <img src="images/logo1.png" height="110"></div> <!-- the end of id=logo-->
   <div id="top_right">
   <% if (session.getAttribute("userId") == null) 
        {%>
	      <a href="LoginActiontoLoginPage" id="change1">登陆</a>
	      <em style="color:#fff; margin:1px;">|</em>
		  <a href="RegisterActiontoRegisterPage" id="change2">注册</a>
		<%} 
			else {%>
		  <a href="#" class="welcome">您已登录</a>
		  <a href="<%=session.getAttribute("userId") %>" style="color:red"><%=session.getAttribute("userName") %></a>
		  <a href="#">注销用户</a>
   <%	}  %>
   </div><!-- the end of id=top_right -->
   </div><!-- the end of id=top -->
   <div id="nav">
   <ul>
   <li><a href="#">主页</a></li>
   <s:iterator value="categoryList" id="category">
      <li>.<a href="PageInfoActionsecondPage?categoryId=<s:property value="#category.getId()"/>"><s:property value="#category.getName()"/></a></li>
   </s:iterator>
   </ul>
   </div><!-- the end of id=nav -->
   </div><!-- the end of id=header -->
   <form id="example" name="example" action="ManagerActionwriteNews" method="post">
   <div id="content_postSend">
   <div id="pb-main">
   <div id="editor"></div>
   <h2 id="pb_main_title" class="clearfix">
   <span>发表新闻</span></h2>
   <div id="pb-post-area">
   <div id="pb-text-title-holder" class="pb-post-section">
   <h3 class="pb-section-title">标题</h3>
   <input tabindex="1" type="text" name="newsName" class="pb-input-text" id="pb-text-title"><br>
     分类选择：
     <select name="categoryId">
     	<s:iterator value="categoryList" id="category">
       		<option value="<s:property value="#category.getId()"/>"><s:property value="#category.getName()"/></option> 
   	   </s:iterator>
	 </select>
   </div><!-- the end of id=pb-text-title-holder -->
   <div id="pb-text-post-holder" class="pb-post-section">
   <h3 class="pb-section-title">内容</h3>
   <textarea id="tg"name="newsContent" cols="100" rows="8" style="width:630px;height:300px;visibility:hidden; margin-left:3px;"></textarea>
		<br />
		<input type="submit" name="button" value="提交内容" /> (提交快捷键: Ctrl + Enter)
   </div><!-- the end of id=pb-text-post-holder -->
   
   
   
   </div><!-- the end of id=pb-post-area -->
   </div><!-- the end of id=pb-main -->
   
   <div id="pb-aside" style="position:static; top:0px; left:0px; text-align:center; padding-top:40px;">
   <p>请尽量让自己的帖子能够完美</p>
   <br>
   <div>
   <strong>温馨提示</strong>
  <br>
   <p>1.如果帖子中有过激言语,管理员将删帖</p>
   <p>2.要记得为自己的帖子选择分类哦</p>
   </div>
   </div><!-- the end of id=pb-aside -->
  
   </div><!-- the end of id=content_postSend -->
   </form>
   <div id="footer" style="width:980px;">
    <hr style="color:#069; width:980px;">
   <h3>copy@大连民族学院</h3>
   <p style="color:#666;"><a href="#">关于我们</a>|<a href="#">意见反馈</a>|<a href="#">后台登陆</a></p>
   </div><!-- the end of id=footer -->
   </div><!-- the end of id=layout -->
</body>
</html>


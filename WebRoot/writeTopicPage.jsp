<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<link href="post.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="kindeditor-3.5.6-zh_CN/themes/default/default.css" />
	<link rel="stylesheet" href="kindeditor-3.5.6-zh_CN/plugins/code/prettify.css" />
	<script charset="utf-8" src="kindeditor-3.5.6-zh_CN/kindeditor.js"></script>
	<script charset="utf-8" src="kindeditor-3.5.6-zh_CN/lang/zh_CN.js"></script>
	<script charset="utf-8" src="kindeditor-3.5.6-zh_CN/plugins/code/prettify.js"></script>
	<script charset="utf-8" src="kindeditor-3.5.6-zh_CN/kindeditor.js">	</script>
    <script language="javascript" src="js/ValidateCode.js"></script>

<meta charset="UTF-8" />
	<title>IT家园--发帖</title>
		

	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="content1"]', {
				cssPath : '../plugins/code/prettify.css',
				uploadJson : '../jsp/upload_json.jsp',
				fileManagerJson : '../jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
	<script type="text/javascript">


KE.show({    
id : 'content1',//TEXTAREA输入框的ID 
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
	<jsp:include page="header.jsp" />
	
	
		<div class="bignav" style="background: url(img/sliderbg.jpg);
					border-bottom: 10px solid #fff;
					color: #FFFFFF;
					font-size: 20px;
					font-weight: bold;
					height: 90px;
					line-height: 90px;
					text-shadow: 1px 1px 1px #000000;">
		<div style="padding:5px;margin-left:190px;font-family:Tahoma, Geneva, sans-serif;font-size:35px;font-weight: bold;">发表你的帖子</div>
        <div class="container" style="background: url(img/sliderbg.jpg);">
     	
        </div>
 	</div>
	
	
	
	<div id="nav" style=" background:#fff; height: 550px;">
   
		<div id="top" >
        	
            <div class="top_c" >
           	  
					<ul>
                	<li><a href="PageInfoActionfirstPage">首页</a></li>
                     <s:iterator value="categoryList" id="category">
      <li><a href="PageInfoActionsecondPage?categoryId=<s:property value="#category.getId()"/>"><s:property value="#category.getName()"/></a></li>
   </s:iterator>
                </ul>
            </div>
       
      </div>
      <!--顶部菜单结束-->
      
      
      <!--过渡内容-->
      <div id="trans">
      		<img src="topic_images/home.png" height="18" style="border:none;"/>
      	论坛
            <em>></em>
            发表帖子
 	
      </div>
      
      
      <!--内容部分-->
      <div id="con">
            <div class="po">
        		<ul>
            		<li>发表帖子</li>
            	</ul>
            </div>
            
      		<div class="post">
     			<form name="example" method="post" action="UserActiondoWriteTopic" onsubmit="return checkForm()">
              
                <select class="sel"  name="categoryChildId">
                 <s:iterator value="categoryChildList" id="categoryChild">
                <option value="<s:property value="#categoryChild.getId()"/>"><s:property value="#categoryChild.getName()"/></option> 
               </s:iterator>
                </select>
                <input id="title" type="text" class="title" name="topicTitle"/>低于25个字
                <textarea  id="content1" name="content1" cols="100" rows="8" style="width:700px;height:300px;"  ></textarea>
				<br />
				<input id="cv" type="text" name="securityCode" onblur="checkUserid(this.value)" style="width: 50px"/>
                <img id="ValidateCodeImg" src="rand.action"/><a href="javascript:changeAndClear()">换一张？</a><br/>
				<input type="submit" name="button" value="提交内容" onclick="return myfun_submit()"/> 
                </form>
             </div>
                  
      </div>
      
     
   </div>
   <jsp:include page="footer.jsp"/>
   <script type="text/javascript">
function myfun_submit(){
	
	var title = document.getElementById("title").value;
	           
    if(title ==""){
        alert("标题不能为空");
        return false;
    }else if(title.length > 25){
        	 alert("标题过长");
            return false;
            }else{       
   
    
    return true;
            }
}
</script>
</body>
</html>

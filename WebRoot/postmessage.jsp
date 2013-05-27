<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<link href="css/topic.css" rel="stylesheet" type="text/css" />
<link href="css/css-readPost.css" rel="stylesheet" type="text/css" />
<link href="css/css-tableStyle.css" rel="stylesheet" type="text/css" />
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
		<div style="padding:5px;margin-left:190px;font-family:Tahoma, Geneva, sans-serif;font-size:35px;font-weight: bold;">发信</div>
        <div class="container">
        
        </div>
 	</div>
   <div id="nav" >
		<div id="top" style="margin-left: 0px;">
        	
            <div class="top_c">
           	  
				<ul>
                	 <li><a href="PageInfoActionfirstPage">首页</a></li>
     <s:iterator value="categoryList" id="category">
    <li><a href="PageInfoActionsecondPage?categoryId=<s:property value="#category.getId()"/>"><s:property value="#category.getName()"/></a></li>
    </s:iterator>
                </ul>
            </div>
           
      </div>
      <!--顶部菜单结束-->
      
      
  
      
      
      <!--内容部分-->
      <div id="con" style="margin-left: 0px;">
            <div class="po">
        		<ul>
            	<center>	<li style="font-size: 24px;">TO&nbsp;&nbsp;&nbsp;<s:property value="receiver.name"/></li></center>
            	</ul>
            </div>
            
      		<div class="post">
     			<form name="example" method="post" action="UserActionwriteLetter?reId=<s:property value='receiver.id'/>">
              
<!--                <input name="reId" type="hidden" value="<s:property value='#receiver.id'/>"/>-->
                <textarea id="tg" name="l_message" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;" ></textarea>
				<br />
				<input type="submit" name="button" value="提交内容" /> 
                </form>
                </div>
              
           
      </div>
      </div>
<jsp:include page="footer.jsp"/>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="kindeditor-3.5.6-zh_CN/themes/default/default.css" />
	<link rel="stylesheet" href="kindeditor-3.5.6-zh_CN/plugins/code/prettify.css" />
	<script charset="utf-8" src="kindeditor-3.5.6-zh_CN/kindeditor.js"></script>
	<script charset="utf-8" src="kindeditor-3.5.6-zh_CN/lang/zh_CN.js"></script>
	<script charset="utf-8" src="kindeditor-3.5.6-zh_CN/plugins/code/prettify.js"></script>
	<script charset="utf-8" src="kindeditor-3.5.6-zh_CN/kindeditor.js">	</script>
	<script language="javascript" src="js/ValidateCode.js"></script>
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
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>

<script >

	



	
	$(document).ready(function(){
	
	$("#lzl_link_fold").click(function(){
		
		$(".j_lzl_container").hide();
		$("#lzl_link_fold").attr('style','display:none');
		$("#lzl_link_unfold").attr('style','display:block');
	});
	
	$("#lzl_link_unfold").click(function(){

		$(".j_lzl_container").show();
		$("#lzl_link_unfold").attr('style','display:none');
		$("#lzl_link_fold").attr('style','display:block');
	});
	
	$(".j_lzl_p_sb").click(function(){
		location.href = "#";
	});
	});
	

</script>
<style >

	.wirter img{
	background: none repeat scroll 0 0 #FFFFFF;
				box-shadow: 0 0 2px #BBBBBB;
				float: left;
				height: 125px;
				width:125px;
				padding: 20px;}
				.b{
	
	padding:1px 3px;
	border: 1px solid;
	background: #ADC720;
	color: #fff;}
	
	
	
	
	
	/*回复*/
	
	.core_reply_wrapper {
margin: 0 0 8px 15px;
background: #fafafa;
}
.core_reply_tail {
line-height: 28px;
height: 28px;
}

.p_reply {
float: right;
margin-left: 6px;
}
a:link, a:visited {
text-decoration: none;
}

.lzl_link_fold {
background: url(/tb/static-pb/img/pb_css_pic.png?t=130506175929) no-repeat -256px -120px;
color: #1d53bf;
cursor: pointer;
display: inline-block;
height: 28px;
line-height: 28px;
text-align: center;
width: 80px;
}
.core_reply_tail ul {
list-style: none;
float: right;
}

.p_tail li, .p_mtail li {
display: inline;
margin-left: 6px;
color: #999;
}

.p_tail, .p_mtail {
list-style: none outside none;
}

.core_reply_content {
border-left: 1px solid #f4f4f4;
border-right: 1px solid #f4f4f4;
padding: 14px 15px;
}


.core_reply_content li.first_no_border {
margin-top: 0;
padding-top: 0;
border-top: 0;
}

.core_reply_content li {
margin-top: 6px;
padding-top: 10px;
border-top: 1px #d7d7d7 dotted;
}
.lzl_single_post {
zoom: 1;
}

.lzl_li_pager_s {
text-align: left;
overflow: hidden;
}
.lzl_cnt {
margin-left: 60px;
margin-top:-40px;
zoom: 1;
word-wrap: break-word;
word-break: break-all;
}
.lzl_content_main {
color: #333;
font-size: 14px;
line-height: 20px;
}

Matched CSS Rules
.lzl_content_reply {
text-align: right;
}

.j_lzl_p {
cursor: pointer;
float: right;
width: 95px;
}
.j_lzl_p a {
no-repeat -510px -7px;
display: block;
padding-left:  10px;
width: 75px;
height: 25px;
line-height: 25px;
text-align: center;
text-decoration: none;
}
p {
display: block;
-webkit-margin-before: 1em;
-webkit-margin-after: 1em;
-webkit-margin-start: 0px;
-webkit-margin-end: 0px;
}
.lzl_li_pager_s {
text-align: left;
}
.lzl_li_pager_s {
text-align: left;
overflow: hidden;
}
.lzl_jb {
color: #999;
display: none;
}
.lzl_jb_in {
color: #999;
}
.lzl_s_r {
color: #666;
}
.lzl_content_reply {
text-align: right;
}
.lzl_editor_container_s {
padding-top: 13px;
}
.lzl_simple_wrapper {
border: 2px solid #d6dffa;
background-color: #fff;
position: relative;
}
.tb-editor-editarea {
cursor: text;
outline: 0;
overflow: auto;
word-break: break-all;
padding: 1px 6px 1px 8px;
font-family: SimSun,Verdana,sans-serif;
font-size: 14px;
line-height: 24px;
}

.box-holder .box-title {
padding-left: 7px;
padding-right: 10px;
color: #676767;
cursor: default;
}
.lzl_editor_container .lzl_panel_wrapper {
width: 531px;
margin-top: 11px;
zoom: 1;
}
tbody {
display: table-row-group;
vertical-align: middle;
border-color: inherit;
border:2px solid #000;
}
tbody tr {
border:2px solid #000;
display: table-row;
vertical-align: inherit;
border-color: inherit;
}
.lzl_panel_wrapper td {
vertical-align: bottom;
}
.lzl_panel_btn {
line-height: 24px;
zoom: 1;
}
.lzl_panel_submit {
cursor: pointer;
float: right;
width: 51px;
height: 24px;

text-align: center;

}

.insertsmiley_holder {
width: 33px;
height: 22px;

cursor: pointer;
}

table {
display: table;


border:none;
}


tbody {
display: table-row-group;
vertical-align: middle;
border-color: inherit;
}

.j_lzl_p_sb {
   border-top: 1px solid #96d1f8;
   background: #65a9d7;
   background: -webkit-gradient(linear, left top, left bottom, from(#75a7c9), to(#65a9d7));
   background: -webkit-linear-gradient(top, #75a7c9, #65a9d7);
   background: -moz-linear-gradient(top, #75a7c9, #65a9d7);
   background: -ms-linear-gradient(top, #75a7c9, #65a9d7);
   background: -o-linear-gradient(top, #75a7c9, #65a9d7);
   padding: 2px 5px;
   -webkit-border-radius: 8px;
   -moz-border-radius: 8px;
   border-radius: 8px;
   -webkit-box-shadow: rgba(0,0,0,1) 0 1px 0;
   -moz-box-shadow: rgba(0,0,0,1) 0 1px 0;
   box-shadow: rgba(0,0,0,1) 0 1px 0;
   text-shadow: rgba(0,0,0,.4) 0 1px 0;
   color: white;
   font-size: 15px;
   font-family: 'Lucida Grande', Helvetica, Arial, Sans-Serif;
   text-decoration: none;
   vertical-align: middle;
   }
.j_lzl_p_sb:hover {
   border-top-color: #6d98b5;
   background: #6d98b5;
   color: #ccc;
   }
.j_lzl_p_sb:active {
   border-top-color: #1b435e;
   background: #1b435e;
   }
   
   .j_lzl_p a{
   color: #fff;}
   
   .j_lzl_p {
   border-top: 1px solid #ffffff;
   background: #4fab46;
   background: -webkit-gradient(linear, left top, left bottom, from(#a4d95e), to(#4fab46));
   background: -webkit-linear-gradient(top, #a4d95e, #4fab46);
   background: -moz-linear-gradient(top, #a4d95e, #4fab46);
   background: -ms-linear-gradient(top, #a4d95e, #4fab46);
   background: -o-linear-gradient(top, #a4d95e, #4fab46);
   padding: 2.5px 5px;
   -webkit-border-radius: 2px;
   -moz-border-radius: 2px;
   border-radius: 2px;
   -webkit-box-shadow: rgba(0,0,0,1) 0 1px 0;
   -moz-box-shadow: rgba(0,0,0,1) 0 1px 0;
   box-shadow: rgba(0,0,0,1) 0 1px 0;
   text-shadow: rgba(0,0,0,.4) 0 1px 0;
   color: #dcf6f7;
   font-size: 9px;
   font-family: 'Lucida Grande', Helvetica, Arial, Sans-Serif;
   text-decoration: none;
   vertical-align: middle;
   }
.j_lzl_p:hover {
   border-top-color: #50993d;
   background: #50993d;
   color: #ccc;
   }
.j_lzl_p:active {
   border-top-color: #1b435e;
   background: #1b435e;
   }
   
  .lzl_link_fold {
background:#FAFAFA;
color: #1d53bf;
cursor: pointer;
display: inline-block;
height: 28px;
line-height: 28px;
text-align: center;
width: 80px;
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
		<div style="padding:5px;margin-left:160px;font-family:Tahoma, Geneva, sans-serif;font-size:35px;font-weight: bold;">帖子：贴出你的风采</div>
        <div class="container">
        
        </div>
 	</div>
<div id="main" style="margin-top: 20px; background: #fff;">

	<div id="content">
	
	
	<div class="top_c" >
           	  
					<ul>
                	<li style="float: left;margin-left: 5px;"><a href="PageInfoActionfirstPage">首页</a></li>
                     <s:iterator value="categoryList" id="category">
      <li style="float: left;margin-left: 5px;"><a href="PageInfoActionsecondPage?categoryId=<s:property value="#category.getId()"/>"><s:property value="#category.getName()"/></a></li>
   </s:iterator>
                </ul>
            </div>
	
	
    <div class="innerNav">
   
                	<a href="UserActiontoWriteTopicPage"><img src="topic_images/pn_post.png" style="border:none;" /></a>
               

    </div><!--.innerNav-->
    <center>
    <div id="title"><s:property value="getTopic().getTitle()"/></div>
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
      <hr style="width: 50px; height: 0;"/>
   		<a href="PageInfoActiontoFriendCenter?friendId = <s:property value="topic.user.id"/>"> <s:property value="topic.user.name"/></a>
      <dd>
      
      <a href="UserActionmakeFriend?friendId=<s:property value='topic.user.id'/>" id="listen" title="加为好友">加为好友</a>
      </dd>
      </dl>
      </td>
      <td style="display: none;"></td>
      </tr>
      <tr class="post_info " data-floor="2" data-username="thdxs">
      <td class="data">
      <span class="fr">
    
      </span>
      <span class="time"> 发表于：<s:date name="topic.date" format="yyyy-MM-dd HH:mm:ss"/></span>
      <span style="float: right;"><a href="UserActionreportTopic?topicId=<s:property value='topic.id'/>">举报</a></span>
      </td>
      </tr>
      <tr>
      <td>
      <div class="post_body"> <s:property value="pageInfoVo.topic.contents" escape="false"/>
       </div>
        <!--相关帖子  -->
       <div class="related">
       <strong>看过此贴的用户还看过</strong>
       <s:iterator value="topicList" id="topic1" status="sta">
       <ul>
       <li><a href="PageInfoActionreadTopicPage?topicId=<s:property value='#topic1.getId()'/>"><s:property value="#topic1.title"/></a></li>       
      </ul>       
       </s:iterator>
       </div>
      </td>
 
      </tbody>
      </table>
      <s:iterator value="cr" id="target">
              <table id="post-393058130" class="post " cellspacing="0" 
              cellpadding="0" border="0" data-post-id="393058130">
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
      <dd class="username">
      <a target="_blank" href="PageInfoActiontoFriendCenter?friendId=<s:property value='#target.key.user.id'/>"><s:property value="#target.key.user.name"/></a>
      </dd>
       <dd>
       <hr style="width: 50px; height: 0;"/>
      <a href="UserActionmakeFriend?friendId=<s:property value='#target.key.user.id'/>" id="listen" title="加为好友">加为好友</a>
      </dd>
      </dl>
      </td>
      <td style="display: none;"></td>
      </tr>
      <tr class="post_info " data-floor="2" data-username="thdxs">
      <td class="data">
      <span class="fr">
    
      </span>
      <span class="time">回复于：<s:date name="#target.key.date" format="yyyy-MM-dd HH:mm:ss"/></span>
      </td>
      </tr>
      <tr>
      <td>
      <div class="post_body">
      <s:property value="#target.key.content" escape="false"/>
     
      
      <div class="core_reply j_lzl_wrapper">
				<a class="l_post_anchor" name="31828005068l"></a>
			<div class="core_reply_tail">

	              
			</div>
		
			
	          <!-- XXXXXXXX1 -->
                    	 
                    	 <div class="j_lzl_container core_reply_wrapper " data-

field="{&quot;pid&quot;:&quot;31828005068&quot;,&quot;floor_num&quot;:&quot;2&quot;}" style="display:">    
 <div class="core_reply_border_top"></div>
	              <div class="j_lzl_c_b_a core_reply_content">
	                  <ul class="j_lzl_m_w" style="display:">      
	                    <s:iterator value="#target.value" id="reply">
	                    <li class="lzl_single_post j_lzl_s_p " data-field="{&quot;pid&quot;:&quot;31828005068&quot;, &quot;spid&quot;:&quot;31878569511&quot;,&quot;user_name&quot;:&quot;你个菊花的&quot;,&quot;portrait&quot;:&quot;8b1bc4e3b8f6bed5bba8b5c40e25&quot;}">
	                        <a class="l_post_anchor" name="31878569511"></a>
	                        <a class="lzl_p_p" href="/i/290542402?st_mod=pb&amp;fr=tb0_forum&amp;st_type=uface" target="_blank" onmouseout="hideattip(this);" onmouseover="showattip(this);" username="你个菊花的"><img src="http://tb.himg.baidu.com/sys/portraitn/item/8b1bc4e3b8f6bed5bba8b5c40e25" style="width:32px;height:32px"></a>	
	                        <div class="lzl_cnt">    
	                          <a class="at" target="_blank" href="/i/sys/jump?un=你个菊花的" username="你个菊花的" onmouseover="showattip(this);" onmouseout="hideattip(this);"><s:property value="#reply.user.name"/></a>:
	                          <span class="lzl_content_main">
	                        <s:property value="#reply.content"/>
	                          </span>  
	                          <div class="lzl_content_reply">
								<span class="lzl_jb" delete-data="" style="display: none;"><a href="" class="lzl_jb_in" data-checkun="un">举报</a>&nbsp;|&nbsp;</span>
								<span class="lzl_op_list j_lzl_o_l" style="display:none;"></span>
	                            <span class="lzl_time"><s:date name="#reply.date" format="yyyy-MM-dd HH:mm:ss"/></span>
	                          
	                          </div>
	                        </div>
	                      </li>
	                     
	                 </s:iterator>	
	                   
<%--	                    <li class="lzl_li_pager j_lzl_l_p lzl_li_pager_s" data-field="{&quot;total_num&quot;:&quot;7&quot;,&quot;total_page&quot;:&quot;1&quot;}">--%>
<%--	                    	<p class="j_lzl_p"><a>我也说一句</a></p>--%>
<%--	                         <p class="j_pager l_pager pager_theme_2" style="display:none">&nbsp;</p>                 --%>
<%--	                    </li>                   --%>
        			 <li style="background: #FAFAFA; height: 120px;">
	                      	<form name="reply" id="myReply" action="UserActionWriteReply" method="post">
    		<input name="replyContent" type="text" style="height: 50px; width: 400px; margin-left: 130px;"> 
    		<input type="hidden" name="topicId" value="<s:property value='pageInfoVo.topic.id'/>" style="height: 50px; width: 400px; margin-left: 130px;"> 
    		<input type="hidden" name="commentPageNum" value="<s:property value='pageInfoVo.getCommentPageNum()'/>" style="height: 50px; width: 400px; margin-left: 130px;"> 
    		<input type="hidden" name="commentId" value=" <s:property value='#target.key.id'/>" style="height: 50px; width: 400px; margin-left: 130px;"> 
    		
    		<br>
    		
    		
     		<input style="float: right;margin-right: 180px; margin-top: 10px;" type="submit" value="回复"  onClick="get();"/> </form>
	                      </li>
	                      </ul>
	                 
	                  
	              </div>
	             
				</div>
		<!-- div -->
      </td>

      </tbody>
      </table>
      </s:iterator>
       <div id="l_a" style="float:right;padding-right: 60px;" >
      <script type="text/javascript">
   
     var i = 0;
     
 	 var isNext =<s:property value="pageInfoVo.getCp().getNext()"/>;
 	 var size = <s:property value="cr.size()"/>;//当前拿出来的长度 
 	var size1 = <s:property value="pageInfoVo.getCp().getPageSize()"/>;  //规定好每页的长度
	 var isPre = <s:property value="pageInfoVo.getCp().getPre()"/>;

	 var pageNum = <s:property value="pageInfoVo.getCp().getAllPage()"/>;
  	var topicId = <s:property value="pageInfoVo.getTopicId()"/>;
  	if(size < size1){
		for(var j = size; j <= size1; j++){
			document.write("<br/>");
		}
		}
	          document.write("<center>");
	for ( i=1; i<=pageNum; ++i){

  		document.write("<a href='PageInfoActionreadTopicPage?topicId="
  							+topicId+
  							"&&commentPageNum="
  							+i+
  							"'><strong class='b'>"+i+"</strong></a>&nbsp;");
		
  	}

  	var t = <s:property value="pageInfoVo.getCommentPageNum()"/>;
	document.write("<br/>当前第"+t+"页（共"+pageNum+"页）<br/>");
if(isPre == 1){

var b = t-1;
document.write("<a href='PageInfoActionreadTopicPage?topicId="
  							+topicId+
  							"&&commentPageNum="
  							+b+
  							"'>上一页</a>");
}
if(isNext == 1){

	 var a = t+1;
	 document.write("<a href='PageInfoActionreadTopicPage?topicId="
	   							+topicId+
	   							"&&commentPageNum="
	   							+a+
	   							"'>下一页</a>");
	   
	 } 
document.write("</center>");
   </script>
   </div>
      <div class="innerNav">
    <a href="UserActiontoWriteTopicPage" class="tend">发帖</a>
    </div><!--.innerNav-->
    <div id="reply" style="height: 450px;">
    <form name="reply" id="myReply" action="UserActiontoWriteCommentPage?topicId=<s:property value='pageInfoVo.getTopicId()'/>" method="post" onsubmit="return checkForm()">
    <div id="left">
    1.这里发言，表示您用户行为准则。<br>
    2.请对您的言行负责，并遵守中华人民共和国有关法律法规,尊重网上道德。<br>
    3.转载文章请注明出处。如是商业用途请联系原作者。
    </div>
    <input type="hidden" name="commentPageNum" value="<s:property value='pageInfoVo.getCommentPageNum()'/>" style="height: 50px; width: 400px; margin-left: 130px;"> 
    <textarea id="tg" name="content2" style="width:700px;height:200px;visibility:hidden;"></textarea>
	<div style="width: 100%; display: block;">
	<div style="float:right; display: block; margin-right: 50px;margin-top: 20px;">
        <input id="cv" type="text" name="securityCode" onblur="checkUserid(this.value)" style="width: 50px; " />
                         <img id="ValidateCodeImg" src="rand.action"/><a href="javascript:changeAndClear()">换一张？</a><br/>
     </div>
   </div>

   <input type="submit" value="提交" id="sub" onClick="get();" style="float: right;margin-right: 100px;">
   </form>
</div>
      
    </div><!--#content-->
    <div class="clear"></div>
</div>

 <jsp:include page="footer.jsp"/>


</body>
</html>

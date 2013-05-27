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

<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<link href="topic.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	.redClass{
		background:#E9E9E9;
	}
	.b{
	
	padding:1px 3px;
	border: 1px solid;
	background: #ADC720;
	color: #fff;}
	.hover{
	background: #ccc;}
	
</style>
<script >
	$(document).ready(function() {
		$('#ul_li li:even').addClass("redClass");
		$('#ul_li li:first-child').removeClass("redClass");
		$('#ul_li li:not(:first-child)').hover(function(){
			$(this).addClass('hover')},function(){
				$(this).removeClass('hover');
		});
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
		<div style="padding:5px;margin-left:190px;font-family:Tahoma, Geneva, sans-serif;font-size:35px;font-weight: bold;">帖子列表</div>
        <div class="container">
        
        </div>
 	</div>
	<div id="nav" style=" background:#fff; height: 700px;">
   
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
      <div id="trans" >
      		<a href=""><img src="topic_images/home.png" style="border:none;"/></a>
      		
 	
      </div>
      
      <!--内容部分-->
      <div id="cen" >
           
            <div class="cen_right"  >
            	<div class="c_r_top">
                	<a href="UserActiontoWriteTopicPage"><img src="topic_images/pn_post.png" style="border:none;" /></a>
                    <div class="link">

                    </div>
                </div>
                <div class="posts" >                	                	                	                
                    <ul id="ul_li">  
                      <li class="p_t"><div class="title">标题</div><div class="author">作者</div><div class="browse">浏览数</div><div class="reply">回复数</div><div class="date">发表时间</div></li>
                                                       	
						<s:iterator value="topicList" id="topic">
						<li><div class="title"><a href="PageInfoActionreadTopicPage?topicId=<s:property value='#topic.getId()'/>" target="_black"><s:property value="#topic.getTitle()"/></a></div>
						<div class="author"><a href="PageInfoActiontoFriendCenter?friendId=<s:property value='#topic.user.id'/>" class="barname"><s:property value="#topic.getUser().getName()"/></a></div>                       
						<div class="browse"><s:property value="#topic.countBrowse"/></div>
						<div class="reply"><s:property value="countComment"/></div>
						<div class="date"><s:date name="date" format="yyyy-MM-dd HH:mm:ss"/></div>
<!--						<div class="date"><s:property value="#topic.date"/></div>-->
						</li>
                        </s:iterator>
                        

                    </ul>
                     <div id="l_a" style="float:right;padding-right: 60px; margin-top: 20px;" >
       <script type="text/javascript">
     var i = 0;
   
	 var isNext =<s:property value="pageInfoVo.getTp().getNext()"/>;
	 var size = <s:property value="topicList.size()"/>;//当前拿出来的长度
     var size1 = <s:property value="pageInfoVo.getTp().getPageSize()"/>;  //规定好每页的长度
      
	 var isPre = <s:property value="pageInfoVo.getTp().getPre()"/>;
	 var pageNum = <s:property value="pageInfoVo.getTp().getAllPage()"/>;

	 if(size < size1){
			for(var j = size; j <= size1; j++){
				document.write("<br/>");
			}
			}
	   	document.write("<center>")
	   	for ( i=1; i<=pageNum; i++){
	   		document.write(" <a href='PageInfoActiontopicListPage?topicPageNum="
	   							+i+
	   							"'><strong class='b'>"+i+"</strong></a>&nbsp;");
	   	}
	
		var t = <s:property value="pageInfoVo.getTopicPageNum()"/>;
	   	document.write("<br/>当前第"+t+"页（共"+pageNum+"页）<br/>");

	   if(isPre == 1){
	   var a = t-1;
	 
	   document.write(" <a href='PageInfoActiontopicListPage?topicPageNum="
	   							+a+
	   							"'/>上一页 </a>");
	   							
	   }
	  
	   if(isNext == 1){
	   var b = t+1;
	   document.write(" <a href='PageInfoActiontopicListPage?topicPageNum="
	   							+b+
	   							"'>下一页 </a>");
	   }
	   

	   	document.write("</center>")
</script>
</div>
                </div>
                                  
            </div>
          
      </div>
     
     </div>
       
       <jsp:include page="footer.jsp"/>
        
</body>
</html>

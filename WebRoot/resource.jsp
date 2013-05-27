
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%><!doctype html>
<html>
<head>
<meta charset="utf-8">

<script type="text/javascript" src="js/jQuery.js"></script>

<script>
	  jQuery(document).ready(function(){
        
$('.menu li').hover(function () {
    $(this).find(".sub-menu").slideDown("medium");
    },
	function(){
	    $(this).find(".sub-menu").slideUp("fast");
	});
		            });
</script>


<link href="css/css-resource.css" rel="stylesheet" type="text/css">

<style type="text/css">
			#tab{
				display:none;}
			body{
				background:#f1efef;
				margin:auto;
				padding:0;
				}
				.logo{
					float:left;
					margin-top:15px;
				}
				img{border:0;}
			a{
				text-decoration:none;
				}
			li{
				list-style-type:none;
				}
				
			.container { 
				position: relative; 
				width: 960px; 
				margin: 0 auto; 
				padding: 0;
				background:#000; 
				}
			.headerinside a img{
				width:100px;
				height:50px;
				}
	
			.header{
				background: none repeat scroll 0 0 #FAFAF6;
				border-bottom:2px solid #ADC760;
				height:70px;
				position:relative;
				width:100%;
				z-index:21312313;
				}
			.menu{
				float:right;
				font-size:13px;
				
				text-shadow:0 1px 1px #FFFFFF;
				margin-top:25px;
				}
			.menu li{
				position:relative;
				display:inline;
				text-decoration:none;
				margin-left:15px;
				}
			.menu li a{
				color: #434343;
				padding-bottom:20px;
				text-decoration:none;
				}
			.menu li a:hover {
				color:#adc769;
				}
			.sub-menu{
				background:none repeat scroll 0 0 #FFFFFF;
				border-top: 2px solid #adc760;
				box-shadow: 0 4px 15px rgba(0,0,0,0.2);
				display:none;
				left:-10px;
				margin-left:0;
				margin-top:15px;
				padding:3px 10px;
				position: absolute;
			    z-index: 242424242;
				}
			.sub-menu li{
				background:none repeat scroll 0 0 transparent;
				border-bottom:1px solid #EEEEEE;
				margin-left:1px;
				min-width:150px;
				padding-left:0;
				padding-right:0;
				margin-bottom:0px;
				float:left;
				position:relative;
				}
			.sub-menu li a {
    			display: block;
    			padding-bottom: 7px;
    			padding-top: 7px;
				}
				/*下面的样式是用来改变选着文本时的背景色和前景色的*/
			::selection {
				background: #adc760;
				color:#fff;
				}
			::-moz-selection {
				background: #adc760;
				color:#fff;
				}
				/*end*/
				
			.sub-menu li:last-child {
				border-bottom:0px;
				}

<!--header end-->
</style>


<style type="text/css">
	.redClass{
		background:#ccc;
	}
	.hover{
	background: #000;}
	
	.b{
	padding:1px 3px;
	border: 1px solid;
	background: #ADC720;
	color: #fff;}
	.top_c ul{padding:0 0 0 10px;
	margin:0px;
	list-style:none;
	height:35px;
	background:#adc720;
	box-shadow: 0px 3px 20px #B9B7B7;
	color: #fff;}
	.top_c{	
	font-family:Arial, Helvetica, sans-serif;
	font-size:14px;
	width:980px;
	text-align:center;}
#qmenu{float:right; margin-top:3px;padding-right:8px; text-decoration:none;}
.top_c ul{padding:0 0 0 10px;
	margin:0px;
	list-style:none;
	height:35px;
	background:#adc720;
	box-shadow: 0px 3px 20px #B9B7B7;}
.top_c ul li{float:left;}
.top_c ul li a{display:block;
	line-height:35px;
	color:#fff;
	text-decoration:none;
	padding:0 10px 0 10px;}
.top_c ul li a:hover{
	color:#fff;
	background:#f17200;}
</style>
	


<script >
	$(document).ready(function() {
		$('#ul_li li:even').addClass("redClass");
		
		$('#ul_li li:not(first-child)').hover(function(){
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
					<div style="padding:5px;margin-left:200px;font-family:Tahoma, Geneva, sans-serif;font-size:35px;font-weight: bold;">资源天地</div>
        <div class="container">
        
        </div>
 	</div>
    
    
<div id="main" style="" >
<div style="background: #fff; width: 980px;margin:auto; ">
  <div id="content">
  
<div class="top_c" >
           	  
					<ul>
                	<li style="float: left;margin-left: 5px;"><a href="PageInfoActionfirstPage">首页</a></li>
                     <s:iterator value="categoryList" id="category">
      <li style="float: left;margin-left: 5px;"><a href="PageInfoActionsecondPage?categoryId=<s:property value="#category.getId()"/>"><s:property value="#category.getName()"/></a></li>
   </s:iterator>
                </ul>
            </div>



  <div id="main-content">
  <div id="main-left">
  <ul id="ul_li">
 <s:iterator value="resourcefileList" id="resource">
  <li class="download">
     <a>
    <s:property value="#resource.getFileName()"/>
     </a>
     <strong class="getDiscript" style="display:none;"> <s:property value="#resource.getState()"/></strong>
     <span style="display:none;" class="getId"><s:property value="#resource.getId()"/></span>
  </li>
  </s:iterator>
  </ul>
  <div style="text-align: center;">
   <script type="text/javascript">
   
     var i = 0;
     var size = <s:property value="resourcefileList.size()"/>;//当前拿出来的长度
     var size1 = <s:property value="pageInfoVo.getRfp().getPageSize()"/>;  //规定好每页的长度
             
	 var isNext =<s:property value="pageInfoVo.getRfp().getNext()"/>;
	
	 var isPre = <s:property value="pageInfoVo.getRfp().getPre()"/>;
	 var pageNum = <s:property value="pageInfoVo.getRfp().getAllPage()"/>;
	
	if(size < size1){
	for(var j = size; j <= size1; j++){
	
	document.write("<br/>");
	}
	}
		
	   	for ( i=1; i<=pageNum; i++){
	   		document.write(" <a href='PageInfoActiontoResourcePage?resourcePageNum="+i+"'><strong class='b'>"+i+"</strong></a>&nbsp;");
	   	}
	
		var t = <s:property value="pageInfoVo.getResourcePageNum()"/>;
	   	document.write("<br/>当前第"+t+"页（共"+pageNum+"页）<br/>");

	   if(isPre == 1){
	   var a = t-1;	 
	   document.write(" <a href='PageInfoActiontoResourcePage?resourcePageNum="+a+"'/>上一页</a>");	   							
	   }
	  
	   if(isNext == 1){
	   var b = t+1;
	   document.write(" <a href='PageInfoActiontoResourcePage?resourcePageNum="+b+"'>下一页</a>");
	   }
	

	   
</script>
</div>
  </div>
  <div id="main-right"><span id="button">上传资源</span>
  <div id="right-hot">
  <span style="background-color:#E1E1E1; color:#666; display:block; width:100%; height:30px; padding-top:8px; font-size:20px; text-align:center;">最热资源</span>
 <s:iterator value="hotResourceList" id="resource">
  <p class="download download1"><a><s:property value="#resource.getFileName()"/></a>
  <strong class="getDiscript" style="display:none;"><s:property value="#resource.getState()"/></strong>
  <span style="display:none;" class="getId"><s:property value="#resource.getId()"/></span>
  </p>
  </s:iterator>
  </div><!--#right-hot-->
  </div><!--#main-right-->
  
  </div><!--#main-content-->
 

  </div><!--#content-->

  
</div><!--#main-->
<div id="main1">
<div id="show">
<span style="width:100%; height:30px; font-size:18px; color:#957C17; display:block; text-indent:2em; background-image:url(images/nav-win.gif); background-repeat:repeat-x;">资源上传<strong style="color:#000; display:inline-block; margin-left:240px; cursor:pointer;" id="hiden">x</strong></span>
<form id="myForm" action="UserActionuploadFile" enctype="multipart/form-data" method="post">
<%--<label for="#name">资源名称:</label><input name="fileName" type="text" size="50" id="name"><br>--%>
<label>资源描述：</label><br>
<textarea rows="5" cols="44" id="introduction" name="fileState"> 这里是资源描述；。。。。。</textarea><br>
<label>选择路径：<input type="file" name="upload"></label><br>
<input type="submit" value="上传" id="sumbit" style="margin-left:300px;">
</form>
<p id="show">正在上传  请稍等！</p>
</div>
</div><!--#main1-->
<div id="main2">
<div id="show1">
<span style="width:100%; height:30px; font-size:18px; color:#957C17; display:block; text-indent:2em; background-image:url(images/nav-win.gif); background-repeat:repeat-x;">资源下载<strong style="color:#000; display:inline-block; margin-left:240px; cursor:pointer;" id="hiden1">x</strong></span>
<form id="myForm1" action="UserActiondownFile">
<input name="resourcefileId" type="text" id="getT"  style="display:none;">
<label>资源名称:</label><br>
<div style="width:98%; height:40px; border:1px #ccc solid; padding-top:5px; " id="getName"></div>
<label>资源描述：</label><br>
<div style="width:98%;height:100px;border:1px #ccc solid; padding-top:5px; " id="getDiscript"></div>
<input type="submit" value="下载" style="margin-left:300px;">
</form>
</div>
</div><!--#main2-->



</div>

<script>
$(document).ready(function(e) {
    $("#button").click(function(){
		$("#main1").show();
		$("#show").animate({height:"340px",opacity:1},1000);
		});
	$("#hiden").click(function(){
		$("#show").animate({height:0,opacity:0},1000);
		$("#main1").hide(1000);
		});
		
	$(".download > a").click(function(){
		
		
		var id = $(this).siblings("span").text();
		$("#getT").val(id);
		
	    $("#getName").html($(this).text());
	    var getDiscript = $(this).siblings("strong").text();
		$("#getDiscript").html(getDiscript);//获得资源描述
		$("#main2").show();
		$("#show1").animate({height:"340px",opacity:1},1000);
		});
	$("#hiden1").click(function(){
		$("#show1").animate({height:0,opacity:0},1000);
		$("#main2").hide(1000);
		});
});
</script>
<jsp:include page="footer.jsp"/>
</body>
</html>

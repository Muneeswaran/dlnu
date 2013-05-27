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

<link href="css/css-acknowledge.css" rel="stylesheet" type="text/css">
<style type="text/css">
body{
	margin: 0;
	padding: 0;
	width: 960;px;
}
.coffee{
	width: 200px;
	height: 115px;
	position: relative;
	background-image: url(images/coffee.png);
	background-repeat: no-repeat;
	margin-top: 100px;
	margin-right: auto;
	margin-bottom: 0;
	margin-left: auto;
}
.top_c{	
	font-family:Arial, Helvetica, sans-serif;
	font-size:14px;
	width:880px;
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
		<div style="padding:5px;margin-left:200px;font-family:Tahoma, Geneva, sans-serif;font-size:35px;font-weight: bold;">帖子人生</div>
        <div class="container">
        
        </div>
 	</div>


			
            	
            	
      
   
		<div id="top" style="margin-left: 240px; margin-top: 20px;">
        	
            <div class="top_c" >
           	  
					<ul>
                	<li><a href="PageInfoActionfirstPage">首页</a></li>
                     <s:iterator value="categoryList" id="category">
      <li><a href="PageInfoActionsecondPage?categoryId=<s:property value="#category.getId()"/>"><s:property value="#category.getName()"/></a></li>
   </s:iterator>
                </ul>
            </div>
       
      </div>
            	
            	
<div id="main" align="center" style="left: 25px; ">

<div id="main-left">

<a href="PageInfoActiontoCTopicList?categoryId=
            <s:property value='pageInfoVo.getCategoryId()'/>" target="myFrame" class="min-nav">帖子
</a>
<!--<a href="allPost.html" class="min-nav" target="myFrame">php</a>-->
<s:iterator value="getCategoryChildList()" id="categoryChild">
<a href="PageInfoActiontoCHTopicList?categoryChildId=<s:property value='#categoryChild.getId()'/>" class="min-nav" target="myFrame"><s:property value="#categoryChild.getName()"/></a>
</s:iterator>                        
<hr size="1">
<div id="content">

<iframe frameborder="0" height="120%" width="100%" src="PageInfoActiontoCTopicList?categoryId=<s:property value='pageInfoVo.getCategoryId()'/>" name="myFrame" scrolling="no">
</iframe>
</div>

</div><!--#main-left-->
<div id="main-right">
<div id="coffee" class="coffee"></div><!--#coffee-->
<hr size="1">
<div id="downLoad">
<h3>资源</h3>
<s:iterator value="resourcefileList" id="resource">
<p class="download1">
<a><s:property value="#resource.getFileName()"/></a>
<strong class="getDiscript" style="display:none;"> <s:property value="#resource.getState()"/></strong>
<span style="display:none;" class="getId"><s:property value="#resource.getId()"/></span>  
</p>  
</s:iterator>

</div><!--#downLoad-->
</div><!--#main-right-->
<div class="clear"></div>
</div>
<!--#main-->
<hr size="1">
<jsp:include page="footer.jsp"/>


<div id="main2">
<div id="show1">
<span style="width:100%; height:30px; font-size:18px; color:#957C17; display:block; text-indent:2em; background-image:url(images/nav-win.gif); background-repeat:repeat-x;">资源下载<strong style="color:#000; display:inline-block; margin-left:240px; cursor:pointer;" id="hiden1">X</strong></span>
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

<script>
$(document).ready(function(e) {
    _this = this;
	  n=0;
	 var t;

    $(".title").bind("mouseover",function(){
		$(this).addClass("onhover").siblings(".title").removeClass("onhover");
		var index=$(this).index();
		$(".show").eq(index).show().siblings().hide();
		n=index;
	});
	this.loop = function(){
		
		if (n>=4)
		{
			n=0;
			}
		else
		{ 
		$(".title").eq(n).trigger("mouseover");
		n++;
		}	
		
	}
	
	
		$(".show").hover(function(){
			clearInterval(t);	
			
		},function(){
		
			t = setInterval(_this.loop,1500);		
		
			
		});	
	
	
	
	this.factory = function(){
		t = setInterval(this.loop,1500);		
	}
	this.factory();

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
<script language="javascript">
var rows = document.getElementsByTagName('tr');
for (var i=0;i<rows.length;i++){
	rows[i].onmouseover = function(){		//鼠标指针在行上面的时候
		this.className = 'hover';
	}
	rows[i].onmouseout = function(){		//鼠标指针离开时
		this.className = '';
	}
}
</script>
</body>
</html>

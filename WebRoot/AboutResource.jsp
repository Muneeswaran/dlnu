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
<title>搜索专区</title>
<script type="text/javascript" src="js/jQuery.js"></script>

<link href="css/css_about.css" rel="stylesheet" type="text/css">
</head>

<body>
  <div id="main-left">
  <ul>
<p style="padding-left:350px;font-size:16px;font-family: Tahoma, Geneva, sans-serif;	"></>关于<strong><s:property value="key"/></strong>的资源</p>
<s:iterator value="resourcefileList" id="resource">
<li class="date"><s:property value="#resource.date"/></li>
 <li class="download"><a><s:property value="#resource.getFileName()"/></a>
 <strong class="getDiscript" style="display:none;"><s:property value="#resource.state"/></strong>
 <span style="display:none;" class="getId"><s:property value="#resource.id"/></span>  
<%--  <strong class="getDiscript" style="display:none;"> <s:property value="#resourcefile.getState()"/></strong>--%>
<%--     <span style="display:none;" class="getId"><s:property value="#resourcefile.getId()"/></span>  </li>  --%>
<a href="UserActionmakeFriend?friendId=<s:property value='#resource.user.id'/>" class="barname" style="padding-left:500px;"><s:property value="#resource.user.name"/></a>                       
</li>
</s:iterator>
  </ul>
 <script type="text/javascript">
   
     var i = 0;                    
     var size = <s:property value="resourcefileList.size()"/>;//当前拿出来的长度
     var size1 = <s:property value="resourcefilePager.pageSize"/>;  //规定好每页的长度
             
	 var isNext =<s:property value="resourcefilePager.next"/>;
	
	 var isPre = <s:property value="resourcefilePager.pre"/>;
	 var pageNum = <s:property value="resourcefilePager.allPage"/>;

	    var  key = "<s:property value='key'/>";
		
	if(size < size1){
	for(var j = size; j <= size1; j++){
	
	document.write("<br/>");
	}
	}
		
	   	for ( i=1; i<=pageNum; i++){
	   		document.write(" <a href='SearchActiontoAboutResource?key="+key+"&&resourcePageNum="+i+"'>"+i+"</a>&nbsp;");
	   	}                                                         
	
		var t = <s:property value="resourcePageNum"/>;
	   	document.write("<br/>当前第"+t+"页（共"+pageNum+"页）<br/>");

	   if(isPre == 1){
	   var a = t-1;	 
	   document.write(" <a href='SearchActiontoAboutResource?key="+key+"&&resourcePageNum=="+a+"'/>上一页</a>");	   							
	   }
	  
	   if(isNext == 1){
	   var b = t+1;
	   document.write(" <a href='SearchActiontoAboutResource?key="+key+"&&resourcePageNum="+b+"'>下一页</a>");
	   }
	
		document.write("</center>")
	   
</script>
  </div>
 
<div id="main2">
<div id="show1" style="margin-top:1px;">
<span style="width:100%; height:30px; font-size:18px; color:#ccc; display:block; text-indent:2em; background-image:url(images/nav-win.gif); background-repeat:repeat-x;">资源下载<strong style="color:#000; display:inline-block; margin-left:240px; cursor:pointer;" id="hiden1">X</strong></span>
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
</body>
</html>

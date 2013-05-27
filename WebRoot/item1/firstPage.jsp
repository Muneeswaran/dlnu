<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>Tregante</title>

<link href="style.css" rel="stylesheet" type="text/css" />
<link rel="icon" type="image/png" href="images/tregante-fav-icon.png" />






<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>


<script type="text/javascript" src="js/jquery.eislideshow.js"></script><!--菜单-->
<script type="text/javascript" src="js/custom.js"></script><!--待会要改啊的-->



<script type="text/javascript" src="js/jquery.plusslider-min.js"></script>
<script type="text/javascript" src="js/config.js"></script>

<script type="text/javascript" src="js/jquery.sticky.js"></script>
 <script>
    $(window).load(function(){
      $("#header").sticky({ topSpacing: 0, center:true, className:"hey" });
    });
  </script>

<!--这是选择块-->
<script type="text/javascript">
	$( document).ready(function() {
		$('#tab').show();
		$('.rptabs li').each(function(index) {
           
			$(this).click(function(){
				
             if(index==0){
				 $(this).addClass("one");
				 $('.rptabs li:not(:nth-child(1))').removeClass("one");
				 $('#tab:first').css("display","block");
				 $('#tab:nth-child(2)').css("display","none");
				 $('#tab:nth-child(3)').css("display","none");
				 }else if(index==1){
				 $(this).addClass("one");
				 $('.rptabs li:not(:nth-child(2))').removeClass("one");
				 $('#tab:first').css("display","none");
				 $('#tab:nth-child(2)').css("display","block");
				 $('#tab:nth-child(3)').css("display","none");
				 }else{
					 $(this).addClass("one");
					$('.rptabs li:not(:last-child)').removeClass("one");
				 $('#tab:first').css("display","none");
				 $('#tab:nth-child(2)').css("display","none");
				 $('#tab:nth-child(3)').css("display","block");
					 }
     }) 
        });
		
		
		
		});
</script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

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
			 #tagline {
		        border-top: 0 none;
				/*position:relative;*/
    			width: 939px;
			
				}
			.taggy{
				float:left;
				display:block;
				margin-top:3px;
				width:35px;
				height:35px;
				background: url(img/top.png)  no-repeat ;
				font-size:20px;	
    			line-height:35px;
    			text-align:center;
    			color:#fff;
    			font-weight:bold;
    			margin-right:10px;
				}
			.sdesc {
       			font-size: 12px;
    			line-height: 20px;
    			color: #868180;
    			width:80%;
				}
			.box {
    			width:25%;
    			margin-top:40px;
    			margin-bottom:40px;
				margin-left:70px;
    			display:inline-block;
				
			}
			
		<!--Content-->
		
			.container .ten.columns{ width: 580px; }
			/*left*/
			.aboutus p {
    			width:90%;
				font-size: 14px;
    			line-height: 20px;
				padding-left:20px;
				color: #333;
				}
			.aboutus ul li a{
				font-size:12px;}
			.aboutus ul li{
				line-height:10px;
				background:url(img/h4bg.png) repeat-x bottom;
				}
			
			.latestwork {
				margin-top:60px;
				}
			.latestwork a {
				color:#444;
				}
			.latestwork a:hover {
					color:#adc720;
					}
		

			.maincontent{
				width:580px;  
				
				height:900px;
				
				}
			
				/*right*/
			.sidebarhome {
				background: none repeat scroll 0 0 #EAE9E9;
				border: 1px solid #E7E4E4;
				
				min-height: 200px;
				width: 338px !important;
				margin-top:-900px;
				float: right;
				
				 
				}
			.sidebarhome a {
				color:#444;
				
				}
			.sidebarhome a:hover {
				color:#adc760;
				}
			.widget h4 {
				color: #484949;
				font-family: 'Helvetica Neue';
				background: #EAE9E9;
				padding-right:5px;
				font-size: 13px;
				font-weight: bold;
				margin-bottom:15px;
				text-shadow: 1px 1px 1px #EAE9E9;
				float:left;
				}
			.h4bg {
				background:#000;
    			background: url(img/h4bg.png)  repeat-x scroll 0 20px transparent;
    			
    			height: 30px;
    			margin-bottom: 10px;
    			width: 100%;
				position:relative;
				}
			.h4bg h4 {
				font-weight: bold;
				font-size:20px!important;
				margin-top:8px;
				}
			
				
			.widget {
				margin-bottom:35px;
				}
		
			.aboutus h3 ,.latestwork h3{
				margin-top:-10px;	
				width:150px;
				height:30px;
				text-align:center;
				padding:3px 0;
				font-size:25px;
				color:#FFF;
				background:#adc760;
				font-weight:bold;
				-moz-text-shadow: 0.1em 0.1em 0.8 #000;
				-ms-text-shadow: 0.1em 0.1em 0.8 #000;
				-o-text-shadow: 0.1em 0.1em 0.8 #000;
				-webkit-text-shadow: 0.1em 0.1em 0.8 #000;
				text-shadow: 0.1em 0.1em 0.8 #000;
				
				-moz-border-radius: 6px;
				-ms-border-radius: 6px;
				-o-border-radius: 6px;
				-webkit-border-radius: 6px;
				border-radius: 6px;
				
				-moz-box-shadow: 3px 3px 20px #B9B7B7;
				-ms-box-shadow: 3px 3px 20px #B9B7B7;
				-o-box-shadow: 3px 3px 20px #B9B7B7;
				-webkit-box-shadow: 3px 3px 20px #B9B7B7;
				box-shadow: 0px 3px 20px #B9B7B7;
				
				
				}
				
			.texty {
				margin: 5px 15px 5px 20px;
				font-family:  Gadget, sans-serif!important;
				color: #000 !important;
				font-size: 16px;
    			line-height: 20px;
				padding-top:20px;
				padding-bottom:20px;
    			color: #868180;
				
				
				}
				
			.bywho {
				color: #999999;
				font-family: 'Droid Serif';
				font-size: 14px;
				margin-top: 5px;
				text-align: right;
				padding-right:20px;
				
				}

			
			.testimonial {
				background:#fff;
				border-bottom:2px solid #adc720;
				
				}
			.clear {
				  clear: both;
				  display: block;
				  overflow: hidden;
				  visibility: hidden;
				  width: 0;
				  height: 0;
				}
				
			.rptabs li {
				float:left;
				display:block;
				width:22%;
				height:30px;
				background:#fff;
				margin-right:30px;
				}
			.rptabs {
				border-bottom: 2px solid #adc760;
				float: left;
				height: 30px;
				width: 89%;
				margin-bottom:25px;
				}
			.rptabs li a {
				cursor:pointer;
				display: block;
				font-family: 'Helvetica Neue';
				font-weight:bold;
				line-height: 30px;
				text-align: center;
				font-size:12px ;
				color:#333;
				
				
				/*滑块的样式 和动画*/
				-moz-transition: all 250ms ease 0s;
				-ms-transition: all 200ms ease-in 0s;
				-o-transition: all 200ms ease-in 0s;
				-webkit-transition: all 200ms ease-in 0s;
				}
			 a:hover {
				-moz-transition: all 450ms ease 0s;
				-ms-transition: all 200ms ease-in 0s;
				-o-transition: all 200ms ease-in 0s;
				-webkit-transition: all 200ms ease-in 0s;
				}
			.rptabs li a:hover {
				background:#adc760;				
				color:#fff;
				}
			.rptabs .one a {
				
				background:#adc760;
				color:#fff;
				}
			.rptabs li .active {
				background:#adc760;
				color:#fff;
				}


			#tab li{
				border-bottom: 1px dashed #ccc;
				float: left;
				padding-bottom: 10px;
				padding-top:10px;
				}
			.rptabs li:last-child {
				margin-right:0px;
				}
				
			#tab li:last-child{
    			border-bottom:0px;
				}
				
			.thumby img{
				background: none repeat scroll 0 0 #FFFFFF;
				box-shadow: 0 0 2px #BBBBBB;
				float: left;
				height: 50px;
				width:50px;
				padding: 5px;
				}
			.info h3 {
       			float: left;
				font-size: 12px;
				margin-bottom: 0;
				margin-top:5px;;
				margin-left: 10px;
				}
			
			.info p {
				float: left;
				margin-left: 10px;
				font-size:11px;
				width: 228px;
				margin-top:8px;;
				
				
				}
			.mnm {
    			width: 148px !important;
	     		background: none repeat scroll 0 0 #FFFFFF;
    			box-shadow: 0 0 2px #BBBBBB;
    			padding: 5px 5px 2px;
				float:left;
				margin-left:40px;
	    		-moz-transition: all 250ms ease 0s;
    			-ms-transition: all 250ms ease 0s;
				-o-transition: all 250ms ease 0s;
				-webkit-transition: all 250ms ease 0s;
				
				
				-moz-box-shadow: 3px 3px 20px #B9B7B7;
				-ms-box-shadow: 3px 3px 20px #B9B7B7;
				-o-box-shadow: 3px 3px 20px #B9B7B7;
				-webkit-box-shadow: 3px 3px 20px #B9B7B7;
				box-shadow: 0px 2px 10px #B9B7B7;
				
				display:block;
				}
				
			.mnm h4 {
				font-size:13px;
				text-align:center;
				
				line-height: 10px;
				margin-bottom: 10px;
				}
			
			.mnm:hover {
				-moz-transform: rotate(8deg);
				-webkit-transform: rotate(8deg);
				-o-transform: rotate(8deg);
				-ms-transform: rotate(8deg);
				}
			
			.recentitems {
				width:90%;
				margin-left:35px; 	
				}
				
			.recentitems h3 {
				 font-size:12px;
				 font-weight:normal;
				 }
			.recentitems .four, .portfolioitem {
				margin-bottom: 15px !important;
				margin-left: 0 !important;
				margin-right: 15px !important;
			
				border-bottom: 2px solid #ADC720;
				}
			
			.latestwork p{
				font-size:12px;
				color:#666;
				margin-left:20px;}
			



			<!--footer-->
			.footer {
  			   border-top: 3px solid #ADC760;
 			   min-height: 100px;
			   width: 100%;
				}
			
    </style>
    

<body><!--header-->

    <div class="header" id="header">
    
    	<div class="container">
        	<div class="headerinside sixteen columns" >
            	<a href="#"><img class="logo" alt="" src="img/22222.jpg" /></a>
                
                <div class="um" style="background: #FAFAF6; float:left; margin-top: 40px; margin-left: 40px;">
                	  <% if (session.getAttribute("userId") == null) 
        {%>
    <a href="LoginActiontoLoginPage">登录</a>|<a href="RegisterActiontoRegisterPage">注册</a>
    <%} 
			else {%>
			
		  <a href="PageInfoActiontoPersonCenter?userId=<%=session.getAttribute("userId") %>" style="color:red"><%=session.getAttribute("userName") %></a>
<%--		  <a href="PageInfoActiontoPersonCenter?userId=<%=session.getAttribute("userId") %>" class="welcome">您已登录</a>--%>
		   <a href="QuitAction">注销用户</a>
		<%	}  %>
                </div>
                
                
                <ul class="menu">
                    <li><a href="./index.html">Home</a></li>
                    <li><a href="./blog.html">Blog</a>
                    <ul class="sub-menu">
                    <li><a href="./single.html">Blog Single</a></li>
                    <li><a href="./blog.html">Blog Right Sidebar</a></li>
                    <li><a href="./blog-left.html">Blog Left Sidebar</a></li>
                    </ul>
                    </li>
                    <li><a href="#">Pages</a>
                        <ul class="sub-menu">
                        <li><a href="#">Fullwidth Page</a></li>
                        <li><a href="#">Normal Page</a></li>
                        <li><a href="#">Page Left Sidebar</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Portfolio</a>
                        <ul class="sub-menu">
                        <li><a href="#">Portfolio Single</a></li>
                        </ul>
                    </li>
                    <li><a href="#">Our Team</a></li>
                    <li><a href="#">Contact Us</a></li>
                    </ul>

            </div>
        </div>
        
    </div><!--pic-holder-->
    
    
    
    
    <div id="pic-holder" style="margin-top:-20px; position:relative;">
    
    <div id="slider" >
    	<div class="slider-pic" style="background:url(img/slider-1.jpg) no-repeat scroll center center;"></div>
        <div class="slider-pic" style="background:url(img/slider-2.jpg) no-repeat scroll center center;"></div>
        <div class="slider-pic" style="background:url(img/slider-3.jpg) no-repeat scroll center center;"><div class="slider-caption"><p>This is some <a href="##">example</a> html caption.</p></div></div>
        <div class="slider-pic" style="background:url(img/slider-4.jpg) no-repeat scroll center center;"></div>
    </div><!--slider-->
</div><!--pic-holder-->



<div id="tagline" style=" background:#fff; ">
	<div class="container" >
    	
        	<div class="sixteen columns" >
        	  <s:iterator value="categoryList" id="category" status="st">
                <div class="box">
               		<a href="PageInfoActionsecondPage?categoryId=<s:property value='#category.id'/>" style=" text-decoration:none;">
                    <h3><s:property value="name"/> </h3>
               		<div class="sdesc">
                		<span class="taggy"><s:property value="#st.index+1"/></span>
              			<s:property value="describe"/>
                	</div>
                    </a>
                </div>
                </s:iterator>
<!--                <div class="box" >-->
<!--                	<a href="#" style=" text-decoration:none;">-->
<!--                	<h3>Project Planning</h3>-->
<!--                	<div class="sdesc">-->
<!--                		<span class="taggy">2</span>-->
<!--                		Lorem ipsum dolor sit amet, his habeo choro albucius in At sumo-->
<!--                	</div>-->
<!--                    </a>-->
<!--                </div>-->
<!--                <div class="box">-->
<!--                	<a href="#"  style=" text-decoration:none;">-->
<!--               		<h3>Best SEO Results</h3>-->
<!--                	<div class="sdesc">-->
<!--                		<span class="taggy">3</span>-->
<!--                		Lorem ipsum dolor sit amet, his habeo choro albucius in At sumo-->
<!--                	</div>-->
<!--                    </a>-->
<!--                </div>-->
            </div>
       
    </div>

</div>

<div  style=" height:34px;  background: url(img/boxshadow.png) no-repeat bottom;background-size:70%;"></div>


<!--content-->
<div class="main container">
	<div class="ten columns maincontent" ><!--left-->
    	
    	<div class="aboutus">
        	<h3>近期新闻</h3>
            	<ul>
            	<s:iterator value="newsList" id="news">
                	<li>
                    	<h4><s:property value="#news.name"/></h4>
                        <p>sdfsdfsdfsdafsdaf松岛枫撒的sdfsdfsdfsdfsdfsdfsdf发生松岛枫松岛枫是</p>
                        <a href="PageInfoActionreadNewsPage?newsId=<s:property value='#news.id' />">详细>></a>
                    </li>
                    </s:iterator>
                  
                    
                </ul>
            
         </div>
         
        <div class="latestwork">
        	<h3>团队光荣榜</h3>
            <p>团队的力量是无限的</p>
        	<div class="recentitems">
       			 <div class="four columns mnm mnm1">
				 	<a href="#" class="glavni"><img width="150" height="88" title="4746951625_cd20f1e0c4_z" alt="4746951625_cd20f1e0c4_z" class="attachment-portfoliohome wp-post-image" src="tupainaaaa/2010081121325186.jpg" /></a>
				 	<h4><a href="./portfolio-single.html">Port item</a></h4>
				 </div>


                <div class="four columns mnm mnm2">
                 	<a href="#" class="glavni"><img width="150" height="88" title="2876370429_5fa4566a9c_b" alt="2876370429_5fa4566a9c_b" class="attachment-portfoliohome wp-post-image" src="tupainaaaa/2011101920361396.jpg" /></a>
                 	<h4><a href="./portfolio-single.html">Other Project</a></h4>
                 </div>

                <div class="four columns mnm mnm3">
                    <a href="#" class="glavni"><img width="150" height="88" title="2533740559_2086c0b58b_z" alt="2533740559_2086c0b58b_z" class="attachment-portfoliohome wp-post-image" src="tupainaaaa/2011122919545196.jpg" /></a>
                    <h4><a href="./portfolio-single.html">HTML Theme</a></h4>
                </div> 
                
                <div class="four columns mnm mnm4">
                    <a href="#" class="glavni"><img width="150" height="88" title="2871105756_7ff68cfe42_b" alt="2871105756_7ff68cfe42_b" class="attachment-portfoliohome wp-post-image" src="tupainaaaa/2011101920361397.jpg" /></a>
                    <h4><a href="#" style="color: rgb(99, 99, 99);">Awesome site</a></h4>
                </div>
                    
                <div class="four columns mnm mnm4">
                    <a href="#" class="glavni"><img width="150" height="88" title="2871105756_7ff68cfe42_b" alt="2871105756_7ff68cfe42_b" class="attachment-portfoliohome wp-post-image" src="tupainaaaa/2011122919545195.jpg" /></a>
                    <h4><a href="#" style="color: rgb(99, 99, 99);">Awesome site</a></h4>
                </div>
                    
                <div class="four columns mnm mnm4">
                    <a href="#" class="glavni"><img width="150" height="88" title="2871105756_7ff68cfe42_b" alt="2871105756_7ff68cfe42_b" class="attachment-portfoliohome wp-post-image" src="tupainaaaa/m_1365316771104.jpg" /></a>
                    <h4><a href="#" style="color: rgb(99, 99, 99);">Awesome site</a></h4>
                </div>
           
            </div>
        </div>
    </div>
    
    
    <div class="six columns sidebarhome"><!--right-->
    	
        <div class="sidinside">
        
        <div class="widget">
        <div class="h4bg"><img style="margin-top:-20px; float:left;  "src="img/best.png" /><h4>获奖</h4></div>
       
        <div class="testimonial">
        <div class="up">
        </div>
        <p class="texty">
        What can i say? This company is best what happened to me after trying so many of them. 
        I am really satisfied with everything !
        </p>
        <div class="down">
        </div>
        </div>
        <div class="triangle"></div>
        <div class="bywho"><a href="#">获奖人</a></div>
        
        </div>
        
        
        
        
        
        <div class="widget">
        <div class="h4bg"><h4>发布选项卡</h4></div>
        <div class="clear"></div>
        <ul class="rptabs">
            <li class="one"><a>最新帖子 </a></li>
            <li><a >精选文章 </a></li>
            <li><a >热门帖子</a></li>
        </ul>
		
<div class="content">	

<div id="tab">   
 
        <ul >
        <s:iterator value="topicList" id="topic">
            <li>
            <a class="thumby" href="#"><img src="tupainaaaa/2010081121325186.jpg" width="50" height="50" alt="" /></a>
            <div class="info">
            <h3><a href="PageInfoActionreadTopicPage?topicId=<s:property value="#topic.id"/>&&commentPageNum = 1"><s:property value="#topic.title"/></a></h3>
            <p>Some text here lorem ipsum dom lo
            tum en nodredm este en geutota...
            </p>
            </div>
            </li>
            </s:iterator>
		</ul>
	</div>
    
<div id='tab'>

<ul>
<s:iterator value="topicListHot" id="topic">
<li>
<a class="thumby" href="#"><img src="tupainaaaa/2011122919545196.jpg" width="50" height="50" alt="" /></a>
<div class="info">
<h3><a href="PageInfoActionreadTopicPage?topicId=<s:property value="#topic.id"/>&&commentPageNum = 1"><s:property value="#topic.title"/></a></h3>
<p>Some text here lorem ipsum dom lo
tum en fffffffffffffota...
</p>
</div>
</li>
</s:iterator>


</ul>
</div>

<div id='tab'>
<ul>
<s:iterator value="topicListRecomend" id="topic">
<li>
<a class="thumby" href="#"><img src="./images/s1.png" width="50" height="50" alt="" /></a>
<div class="info">
<h3><a href="PageInfoActionreadTopicPage?topicId=<s:property value="#topic.id"/>&&commentPageNum = 1"><s:property value="#topic.title"/></a></h3>
<p>Some text here lorem ipsum dom lo
tum en nodredm este en geutota...
</p>
</div>
</li>
</s:iterator>
</ul>
</div>
</div>	

</div>

</div>
</div>

</div>




<!--footer-->
<div class="footer" style=" border-top: 3px solid #ADC760;min-height: 100px; background:#262626; width: 100%;">

</div>
<div class="" style="background:#1F1F1F;width: 100%;height: 40px;border-top: 1px solid #191919;"></div>
</body>
<html>
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
<title>新闻列表</title>
<link href="topic.css" rel="stylesheet" type="text/css" />
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
		<div style="padding:5px;margin-left:200px;font-family:font-size:30px;font-weight: bold;">新闻:读取校园小事</div>
        <div class="container">
        
        </div>
 	</div>
<div id="nav" style=" background:#fff; height: 690px;">
   
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
      <div id="trans" style="background: #fff;">
      		<a href="PageInfoActionfirstPage"><img src="topic_images/home.png" style="border:none;"/></a>
      		<p>主页</p>
 	
      </div>
      
      <!--内容部分-->
      <div id="cen">
           
            <div class="cen_right">
            	
                <div class="posts">
                	
                    <ul>
                    <s:iterator value="newsList" id="ln">
                    	<li class="date"><s:date name="date" format="yyyy-MM-dd HH:mm:ss"/></li>
                        <li>	<a href="PageInfoActionreadNewsPage?newsId=<s:property value="#ln.getId()"/>&&commentPageNum = 1"><s:property value="#ln.getName()" /></a>
 						                     
                        </li>
                        <li class="underline"></li>
                        </s:iterator>
                        

                    </ul>
                      <div style="margin-top: 40px;">
       <script type="text/javascript">
     var i = 0;
   
	 var isNext =<s:property value="pageInfoVo.getNp().getNext()"/>;
	 var size = <s:property value="newsList.size()"/>;//当前拿出来的长度
     var size1 = <s:property value="pageInfoVo.getNp().getPageSize()"/>;  //规定好每页的长度
      
	 var isPre = <s:property value="pageInfoVo.getNp().getPre()"/>;
	 var pageNum = <s:property value="pageInfoVo.getNp().getAllPage()"/>;

	 if(size < size1){
			for(var j = size; j <= size1; j++){
				document.write("<br/>");
			}
			}
	   	document.write("<center>")
	   	for ( i=1; i<=pageNum; i++){
	   		document.write(" <a href='PageInfoActiontoNewsList?newsPageNum="
	   							+i+
	   							"'>"+i+"</a>&nbsp;");
	   	}
	
		var t = <s:property value="pageInfoVo.getNewsPageNum()"/>;
	   	document.write("<br/>当前第"+t+"页（共"+pageNum+"页）<br/>");

	   if(isPre == 1){
	   var a = t-1;
	 
	   document.write(" <a href='PageInfoActiontoNewsList?newsPageNum="
	   							+a+
	   							"'/>上一页");
	   							
	   }
	  
	   if(isNext == 1){
	   var b = t+1;
	   document.write(" <a href='PageInfoActiontoNewsList?newsPageNum="
	   							+b+
	   							"'/>下一页");
	   }
	   

	   	document.write("</center>")
</script>
      </div>
                    
                    
                </div>
                                  
            </div>
      </div>
  
      <!--页脚-->

    </div>
      <jsp:include page="footer.jsp"/>
</body>
</html>

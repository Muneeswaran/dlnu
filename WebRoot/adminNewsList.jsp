<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" type="text/css" href="skin/css/base.css">
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
</td>
</tr>
</table>
  
<!--  内容列表   -->
  <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
    <tr bgcolor="#E7E7E7">
      <td height="24" colspan="15" background="skin/images/tbg.gif">帖子列表&nbsp;</td>
    </tr>
    <tr align="center" bgcolor="#FAFAF1" height="22">
      <td width="5%">ID</td>
      <td width="20%">新闻标题</td>
      <td width="50%">新闻内容</td>
>
      <td width="10%">新闻时间</td>
      <td width="10%">新闻分类</td>
      <td width="10%">操作</td>
    </tr>
				<s:iterator value="newsList" id="news">
    <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
   <form action="ManagerActiondeleteNews">
      <td>							
	  <s:property value="#news.getId()" />
	  </td>
      <td align="left">
	  <s:property value="#news.getName()" />
	  </td>
      <td style="max-height:100px; max-width:400px; overflow:hidden;">
	  <s:property value="#news.getContent()" />
	  </td>
      <td>
	 	<s:date name="date" format="yyyy-MM-dd HH:mm:ss"/>
</td>
						<input type="hidden" name="newsId"
							value="<s:property value='#news.getId()'/>" />
      <td><s:property value="#news.getCategory().getName()" /></td>
      <td><input type="submit" value="删除" /></td>
      </form>
    </tr>
    </s:iterator>
    <tr bgcolor="#FAFAF1">
      <td height="28" colspan="15">&nbsp; <a href="javascript:selAll()" class="coolbg">更新列表</a> </td>
    </tr>
    <tr align="right" bgcolor="#EEF4EA">
      <td height="36" colspan="15" align="center">
<script type="text/javascript">
     var i = 0;
	 var isNext =<s:property value="managerInfoVo.getNp().getNext()"/>;
	 var size = <s:property value="newsList.size()"/>;//当前拿出来的长度
     var size1 = <s:property value="pageInfoVo.getNp().getPageSize()"/>;  //规定好每页的长度
	 var isPre = <s:property value="managerInfoVo.getNp().getPre()"/>;
	 var pageNum = <s:property value="managerInfoVo.getNp().getAllPage()"/>;
	 if(size < size1){
			for(var j = size; j <= size1; j++){
			document.write("<br/>");
			}
			}
	   	document.write("<center>")
	  	for ( i=1; i<=pageNum; i++){
	   		document.write(" <a href='ManagerActiontoNewsList?newsPage="
	   							+i+
	   							"'>"+i+"</a>&nbsp;");
	   	}

		var t = <s:property value="managerInfoVo.getNewsPage()"/>;
	   	document.write("<br/>当前第"+t+"页（共"+pageNum+"页）<br/>");
	   
	   	
	   	if(isPre == 1){
		   	 var b = t-1;
	   	 document.write("<a href='ManagerActiontoNewsList?newsPage="+b+"'>上一页</a>");
	   	 }
        if(isNext == 1){
          var a = t+1;

          document.write("<a href='ManagerActiontoNewsList?newsPage="+a+"'>下一页</a>");
	   	} 
	   	document.write("</center>")
</script>
	
</td>
    </tr>
  </table>

<!--  搜索表单  -->
<form name='form3' action='' method='get'>
<input type='hidden' name='dopost' value='' />
<table width='98%'  border='0' cellpadding='1' cellspacing='1' bgcolor='#CBD8AC' align="center" style="margin-top:8px">
  <tr bgcolor='#EEF4EA'>
    <td background='skin/images/wbg.gif' align='center'>
      <table border='0' cellpadding='0' cellspacing='0'>
        <tr>
          <td width='90' align='center'>搜索条件：</td>
          <td width='160'>
          <select name='cid' style='width:150'>
              <option value='0'>新闻发布时间</option>
              <option value='1'>标题</option>
          </select>
        </td>
        <td width='70'>
          关键字：
        </td>
        <td width='160'>
          	<input type='text' name='keyword' value='' style='width:150px' />
        </td>
        <td>
          <input name="imageField" type="image" src="skin/images/frame/search.gif" width="45" height="20" border="0" class="np" />
        </td>
       </tr>
      </table>
    </td>
  </tr>
</table>
</form>
</body>
</html>
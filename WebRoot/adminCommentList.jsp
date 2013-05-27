<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

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
      <td height="24" colspan="15" background="skin/images/tbg.gif">评论列表&nbsp;</td>
    </tr>
    <tr align="center" bgcolor="#FAFAF1" height="22">
      <td width="5%">ID</td>
      <td width="60%">评论内容</td>
      <td width="10%">评论人</td>
      <td width="10%">评论时间</td>
      <td width="5%">评论帖子</td>
      <td width="10%">操作</td>
    </tr>
    <s:iterator value="commentList" id="comment">
    <tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22" >
    <form action="ManagerActiondeleteComment">
      <td><s:property value="#comment.getId()"/></td>
      <td align="left" style="max-height:50px; max-width:200px; overflow:hidden; width:150px;"><s:property value="#comment.getContent()"/></td>
      <td><s:property value="#comment.getUser().getName()"/></td>
      <td><s:property value="#comment.getDate()"/></td>
      <td><s:property value="#comment.getTopic().getTitle()"/></td>
       <input type="hidden" value="<s:property value='#comment.getId()'/>" name="commentId"/>
      <td><input type="submit" value="删除"/></td>
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
	 var count = <s:property value="managerInfoVo.getCommentCount()"/>;
	 var pageNum = count / <s:property value="managerInfoVo.getCommentPageNum()"/>;
	   
	   	document.write("<center>")
	   	for ( i=1; i<pageNum+1; i++){
	   		document.write(" <a href='ManagerActiontoShowCommentList?commentPage="
	   							+i+
	   							"'>"+i+"</a>&nbsp;");
	   	}
	   	i--;
		var t = <s:property value="managerInfoVo.getCommentPage()"/>;
	   	document.write("<br/>当前第"+t+"页（共"+i+"页）<br/>");
	   
	   	if(t == 1 && count > 1 && pageNum > 1){
          var a = t+1;
  document.write("<a href='ManagerActiontoShowCommentList?commentPage="+a+"'>下一页</a>");
	   	}else if(t > 1 && t < pageNum){
	   	 
	   	 var a = t+1;
	   	 var b = t-1;
	   	 
	   	 document.write("<a href='ManagerActiontoShowCommentList?commentPage="+b+"'>上一页</a>");
	   	 document.write("<a href='ManagerActiontoShowCommentList?commentPage="+a+"'>下一页</a>");
	   	 }else if(t >= pageNum && count > 1){
		   	 var b = t-1;
	   	 document.write("<a href='ManagerActiontoShowCommentList?commentPage="+b+"'>上一页</a>");
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
              <option value='0'>ID</option>
              <option value='1'>用户名</option>
              <option value='2'>管理员</option>
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
<s:debug></s:debug>
</body>
</html>
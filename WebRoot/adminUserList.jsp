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
		<table width="98%" border="0" cellpadding="0" cellspacing="1"
			bgcolor="#D1DDAA" align="center">
			<tr>
				<td height="26" background="skin/images/newlinebg3.gif">
				</td>
			</tr>
		</table>

		<!--  内容列表   -->
		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="15" background="skin/images/tbg.gif">
					&nbsp;用户列表&nbsp;
				</td>
			</tr>
			<tr align="center" bgcolor="#FAFAF1" height="22">
				<td width="2%">
					ID
				</td>
				<td width="5%">
					用户名
				</td>
				<td width="8%">
					入学时间
				</td>
				<td width="8%">
					专业
				</td>
				<td width="2%">
					性别
				</td>
				<td width="7%">
					密码
				</td>
				<td width="5%">
					权限
				</td>
				<td width="8%">
					邮箱
				</td>
				<td width="3%">
					真实姓名
				</td>
				<td width="5%">
					qq号码
				</td>
				<td width="4%">
					民族
				</td>
				<td width="8%">
					电话号码
				</td>
				<td width="8%">
					出生日期
				</td>
				<td width="10%">
					个人说明
				</td>
				<td width="20%">
					操作
				</td>
			</tr>
			<s:iterator value="userList" id="users">
				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<form action="ManagerActionupdateUser">
						<td>
							<s:property value="#users.getId()" />
						</td>
						<td align="left">
							<a href=''><u><s:property value="#users.getName()" /> </u> </a>
						</td>
						<input name="userId" type="hidden" value="<s:property value="#users.getId()"/>">
						<td>
							<input name="userEntranceYear" type="text"
								value="<s:property value="#users.getEntranceYear()"/>"
								style="width: 80px" />
						</td>
						<td>
							<input name="userMajor" type="text"
								value="<s:property value="#users.getMajor()"/>"
								style="width: 80px" />
						</td>
						<td>
							<select name="userSex">

                                      <s:if test='%{#users.getSex()=="男"}'>

									<option value="男">
										男
									</option>
									<option value="女">
									女
									</option>
								</s:if>

								<s:else>
									<option value="女">
									女
									</option>
									<option value="男">
										男
									</option>
								</s:else>
							</select>
						</td>
						<td>
							<input name="userPassword" type="text"
								value="<s:property value="#users.getPassWord()"/>"
								style="width: 80px" />
						</td>
						<td>
							<select name="userPermission1">

								<s:if test="#users.getPermission() == 0">
									<option value=0>
										普通用户
									</option>
									<option value=4>
										管理员
									</option>
								</s:if>
								<s:else>

									<option value=4>
										管理员
									</option>
									<option value=0>
										普通用户
									</option>
								</s:else>
							</select>
						</td>
						<td>
							<input name="userEmail" type="text"
								value="<s:property value="#users.getEmail()"/>"
								style="width: 80px" />
						</td>
						<td>
							<input name="userTruename" type="text"
								readonly value="<s:property value="#users.getTruename()"/>"
								style="width: 50px" />
						</td>
						<td>
							<input name="userQq" type="text"
								value="<s:property value="#users.getQq()"/>" style="width: 50px" />
						</td>
						<td>
							<input name="userNation" type="text"
								value="<s:property value="#users.getNation()"/>"
								style="width: 30px" />
						</td>
						<td>
							<input name="userTel" type="text"
								value="<s:property value="#users.getTel()"/>"
								style="width: 80px" />
						</td>
						<td>
							<input name="userBirthday" type="date"
								value="<s:property value="#users.getBirthday()"/>"
								style="width: 80px" />
						</td>
						<td>
							<input name="userState" type="text"
								value="<s:property value="#users.getState()"/>"
								style="width: 130px" />
						</td>
						<td>
							<input type="submit" value="确认修改" />
							<br />
							<a href="ManagerActiondeleteUser?userId=<s:property value='#users.getId()'/>">删除</a>
						</td>
					</form>
				</tr>
				
			</s:iterator>
			<tr bgcolor="#FAFAF1">
				<td height="28" colspan="15">
					&nbsp;
					<a href="javascript:selAll()" class="coolbg">更新列表</a>
				</td>
			</tr>
			<tr align="right" bgcolor="#EEF4EA">
				<td height="36" colspan="15" align="center">
				<script type="text/javascript">
     var i = 0;
      var size = <s:property value="topicList.size()"/>;//当前拿出来的长度
     var size1 = <s:property value="pageInfoVo.getTp().getPageSize()"/>;  //规定好每页的长度
	 var isNext =<s:property value="managerInfoVo.getU_p().getNext()"/>;
	
	 var isPre = <s:property value="managerInfoVo.getU_p().getPre()"/>;
	 var pageNum = <s:property value="managerInfoVo.getU_p().getAllPage()"/>;
	   if(size < size1){
			for(var j = size; j <= size1; j++){
			document.write("<br/>");
			}
			}
	   	document.write("<center>")
	   	for ( i=1; i<=pageNum; i++){
	   		document.write(" <a href='ManagerActiontoShowUser?userPage="
	   							+i+
	   							"'>"+i+"</a>&nbsp;");
	   	}
	   	i--;
		var t = <s:property value="managerInfoVo.getUserPage()"/>;
	   	document.write("<br/>当前第"+t+"页（共"+pageNum+"页）<br/>");
	   
	  if(isPre == 1){
		   	 var b = t-1;
	   	 document.write("<a href='ManagerActiontoShowUser?userPage="+b+"'>上一页</a>");
	   	 }
  	if(isNext == 1){
          var a = t+1;

  document.write("<a href='ManagerActiontoShowUser?userPage="+a+"'>下一页</a>");
	   	}
	   	document.write("</center>")
</script>
				</td>
			</tr>
		</table>

		<!--  搜索表单  -->
		<form name='form3' action='' method='get'>
			<input type='hidden' name='dopost' value='' />
			<table width='98%' border='0' cellpadding='1' cellspacing='1'
				bgcolor='#CBD8AC' align="center" style="margin-top: 8px">
				<tr bgcolor='#EEF4EA'>
					<td background='skin/images/wbg.gif' align='center'>
						<table border='0' cellpadding='0' cellspacing='0'>
							<tr>
								<td width='90' align='center'>
									搜索条件：
								</td>
								<td width='160'>
									<select name='cid' style='width: 150'>
										<option value='0'>
											ID
										</option>
										<option value='1'>
											用户名
										</option>
										<option value='2'>
											管理员
										</option>
									</select>
								</td>
								<td width='70'>
									关键字：
								</td>
								<td width='160'>
									<input type='text' name='keyword' value='' style='width: 150px' />
								</td>
								<td>
									<input name="imageField" type="image"
										src="skin/images/frame/search.gif" width="45" height="20"
										border="0" class="np" />
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
<%@ page language="java" import="java.util.*,com.ascent.po.*,com.ascent.util.*" contentType="text/html;charset=gb2312"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>AscentWeb电子商务</title>
<link href="<%=request.getContextPath()%>/css/index.css" rel="stylesheet" type="text/css" />

<script language="javascript">
 
</script>
</head>

<body>

<div class="head">
	<div id="login_1">
	
   </div>
	<div id="login_2"></div>
	<div id="login_3"></div>
	<div class="img"><img src="<%=request.getContextPath()%>/images/web_4.jpg" width="277" height="80"/></div>
	<div class="img"><img src="<%=request.getContextPath()%>/images/web_5.jpg" width="273" height="80"/></div>
	<div class="img"><img src="<%=request.getContextPath()%>/images/web_6.jpg" width="250" height="80"/></div>
	<div id="bannerbj"></div>
	<div id="bannerbj2">
			<div class="banner_wenzi">|&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/index.jsp">首 页</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/product/itservice.jsp">IT 服务</a>&nbsp;&nbsp;&nbsp;&nbsp;|
			&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/product/products.jsp">电子商务系统</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/product/employee.jsp">员工招聘</a>&nbsp;&nbsp;&nbsp;&nbsp;|
			&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/product/ContactUs.jsp">关于我们</a></div>
		</div>
	<div id="bannerbj1"></div>	
</div>
<div class="padding">
<br>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr> 
<%
	Usr u = (Usr)session.getAttribute("usr");
	if(u!=null&&u.getSuperuser().equals("3")){  //管理员
%>
<td width="20%"><div align="left">|&nbsp;&nbsp;欢迎,<%=u.getUsername() %>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/clearSession.action" class="table_t">注销</a>&nbsp;&nbsp;|</div></td>
<td width="20%"><div align="center"><a href="<%=request.getContextPath()%>/pageShowProductManagerAction.action"><img src="<%=request.getContextPath()%>/images/productslist.jpg" width="75" height="17" border="0"/></a></div></td>
<td width="20%"><div align="center"><a href="<%=request.getContextPath()%>/product/pageusrManagerAction.action"><img src="<%=request.getContextPath()%>/images/userlist.jpg"  border="0"/></a></div></td>
<td width="20%"><div align="center"><a href="<%=request.getContextPath()%>/pageShowProductManagerAction.action"><img src="<%=request.getContextPath()%>/images/productslist.jpg"  border="0"/></a></div></td>
<td width="20%"><div align="center"><a href="<%=request.getContextPath()%>/product/adminShowOrdersManagerAction.action"><img src="<%=request.getContextPath()%>/images/ShowOrders.jpg"  border="0"/></a></div></td>
<%}%>
</tr>
</table>
<br><br>	
<%
	
	List adminorderList = (List)session.getAttribute("adminorderlist");
	if(adminorderList==null||adminorderList.size()<1){
%>

<center><h3>系统暂时没有订单！</h3></center>
<% }else{ %>
<!-- 订单列表 -->
<center>
<table width="40%" border="1" cellspacing="0" cellpadding="0" class="mars">
  <tr bgcolor="#fba661" height="30"> 
    <td><div align="center">编号</div></td>
    <td><div align="center">用户ID</div></td>
    <td><div align="center">查看</div></td>
    <td><div align="center">删除</div></td>
  </tr>
 <s:iterator value="#session['adminorderlist']" status="index">
 <s:if test="#index.odd==true">
  	<tr bgcolor="#f3f3f3" > 
 </s:if>
 <s:else>
 	<tr bgcolor="#e4f1fe" > 
 </s:else>
 
 	<td><div align="center"><s:property value="ordernumber"/></div></td>
 	<td><div align="center"><a href="<%=request.getContextPath()%>/product/findByUidusrManagerAction.action?uid=<s:property value="usrid"/>"><s:property value="usrid"/></a></div></td>
	<td><div align="center"><a href="<%=request.getContextPath()%>/product/showOrderitemManagerAction.action?orderid=<s:property value="id"/>" >查看</a></div></td>
 	<td><div align="center"><a href="<%=request.getContextPath()%>/product/deleteOrdersManagerAction.action?orderid=<s:property value="id"/>" >删除</a></div></td>
  </tr>
  </s:iterator>
</table>   
<CENTER><H3><s:property value="tip"/></H3></CENTER>
</center> 
</div>


<%}%>

<div>
	<img src="<%=request.getContextPath()%>/images/banquan.jpg" width="800" height="35" border="0"/>
</div>
</body>
</html>

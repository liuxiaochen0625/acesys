<%@ page language="java" import="java.util.*,com.ascent.po.*,com.ascent.util.*" contentType="text/html;charset=gb2312"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>AscentWeb��������</title>
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
			<div class="banner_wenzi">|&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/index.jsp">�� ҳ</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/product/itservice.jsp">IT ����</a>&nbsp;&nbsp;&nbsp;&nbsp;|
			&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/product/products.jsp">��������ϵͳ</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/product/employee.jsp">Ա����Ƹ</a>&nbsp;&nbsp;&nbsp;&nbsp;|
			&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/product/ContactUs.jsp">��������</a></div>
		</div>
	<div id="bannerbj1"></div>	
</div>
<div class="padding">
<br>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr> 
<%
	Usr u = (Usr)session.getAttribute("usr");
	if(u!=null&&u.getSuperuser().equals("3")){  //����Ա
%>
<td width="20%"><div align="left">|&nbsp;&nbsp;��ӭ,<%=u.getUsername() %>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/clearSession.action" class="table_t">ע��</a>&nbsp;&nbsp;|</div></td>
<td width="20%"><div align="center"><a href="<%=request.getContextPath()%>/pageShowProductManagerAction.action"><img src="<%=request.getContextPath()%>/images/productslist.jpg" width="75" height="17" border="0"/></a></div></td>
<td width="20%"><div align="center"><a href="<%=request.getContextPath()%>/product/pageusrManagerAction.action"><img src="<%=request.getContextPath()%>/images/userlist.jpg"  border="0"/></a></div></td>
<td width="20%"><div align="center"><a href="<%=request.getContextPath()%>/pageShowProductManagerAction.action"><img src="<%=request.getContextPath()%>/images/productslist.jpg"  border="0"/></a></div></td>
<td width="20%"><div align="center"><a href="<%=request.getContextPath()%>/product/adminShowOrdersManagerAction.action"><img src="<%=request.getContextPath()%>/images/ShowOrders.jpg"  border="0"/></a></div></td>
<%}
%>

</tr>
</table>
<br><br>	
<%
	
	Usr orderuser = (Usr)session.getAttribute("uid_puser");
	if(orderuser==null){
%>

<center><h3>û�ҵ����û�</h3></center>
<% }else{ %>
<!-- �����б� -->
<center>
<table width="40%" border="1" cellspacing="0" cellpadding="0" class="mars">
  <tr bgcolor="#fba661" height="30"> 
    
    <td><div align="center">�û�ID</div></td>
    <td><div align="center">�û�����</div></td>
    <td><div align="center">Email</div></td>
  </tr>
 <tr bgcolor="#e4f1fe" > 
 	<td><div align="center"><%=orderuser.getId() %></div></td>
 	<td><div align="center"><%=orderuser.getUsername() %></div></td>
	<td><div align="center"><%=orderuser.getEmail() %></div></td>
  </tr>
</table>   
<CENTER><H3><s:property value="tip"/></H3></CENTER>
</div>
</center> 

<%}%>

<div>
	<img src="<%=request.getContextPath()%>/images/banquan.jpg" width="800" height="35" border="0"/>
</div>

</body>
</html>

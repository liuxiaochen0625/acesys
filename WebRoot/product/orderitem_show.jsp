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
<div id="middlebody">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr> 
<%
	String orderid = (String)session.getAttribute("orderid");
	Usr u = (Usr)session.getAttribute("usr");
	if(u!=null&&u.getSuperuser().equals("3")){  //����Ա
%>
<td width="30%"><div align="left">|&nbsp;&nbsp;��ӭ,<%=u.getUsername() %>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/clearSession.action" class="table_t">ע��</a>&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:history.back()"><<< ����</a></div></td>
<td width="20%"><div align="center"><a href="<%=request.getContextPath()%>/pageShowProductManagerAction.action"><img src="<%=request.getContextPath()%>/images/productslist.jpg" width="75" height="17" border="0"/></a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/Product_Search.jsp">��Ʒ��ѯ</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/adminShowOrdersManagerAction.action">��������</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/cartShowCartManagerAction.action">�鿴���ﳵ</a></div></td>
<%}
	else if(u!=null&&u.getSuperuser().equals("2")){  //��Ȩ���û�
 %>
 <td width="30%"><div align="left">|&nbsp;&nbsp;��ӭ,<%=u.getUsername() %>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/clearSession.action" class="table_t">ע��</a>&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:history.back()"><<< ����</a></div></td>
<td width="20%"><div align="center"><a href="<%=request.getContextPath()%>/product/userProductsProductManagerAction.action">�鿴�ѷ����Ʒ</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/Product_Search.jsp">��Ʒ��ѯ</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/showOrdersManagerAction.action">�鿴����</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/cartShowCartManagerAction.action">�鿴���ﳵ</a></div></td>
<%}
	else if(u!=null&&u.getSuperuser().equals("1")){  //��ע���û�
 %>
 <td width="30%"><div align="left">|&nbsp;&nbsp;��ӭ,<%=u.getUsername() %>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/clearSession.action" class="table_t">ע��</a>&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:history.back()"><<< ����</a></div></td>
<td width="15%"><div align="center">&nbsp;</div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/Product_Search.jsp">��Ʒ��ѯ</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/showOrdersManagerAction.action">�鿴����</a></div></td>
<td width="20%"><div align="center"><a href="<%=request.getContextPath()%>/product/cartShowCartManagerAction.action">�鿴���ﳵ</a></div></td>
<%}
	else if(u==null){  //δע���û�
 %>
 <td width="30%"><div align="left">|&nbsp;&nbsp;��ӭ,�ο�&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/product/register.jsp" class="table_t">ע��</a>&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:history.back()"><<< ����</a></div></td>
<td width="15%"><div align="center">&nbsp;</div></td>
<td width="15%"><div align="center">&nbsp;</div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/Product_Search.jsp">��Ʒ��ѯ</a></div></td>
<td width="20%"><div align="center"><a href="<%=request.getContextPath()%>/product/cartShowCartManagerAction.action">�鿴���ﳵ</a></div></td>
<%}%>
</tr>
</table>
<br><br>	

<!-- ��Ʒ�б� --> 
<table width="100%" border="1" cellspacing="0" cellpadding="0" class="mars">
  <tr bgcolor="#fba661" height="30"> 
    <td><div align="center">���</div></td>
    <td><div align="center">����</div></td>
    <td><div align="center">���</div></td>
    <td><div align="center">MDL</div></td>
    <td><div align="center">CAS</div></td>
    <td><div align="center">Weight</div></td>
    <td><div align="center">���</div></td>
    <td><div align="center">ͼƬ</div></td>
 <%
 if(u!=null&&u.getSuperuser().equals("3")){  //����Ա
  %>
    <td><div align="center">ɾ��</div></td>
 <%} %>
  </tr>
 
  <s:iterator value="#session['orderitemlist']" status="index">
 <s:if test="#index.odd==true">
  	<tr bgcolor="#f3f3f3" > 
 </s:if>
 <s:else>
 	<tr bgcolor="#e4f1fe" > 
 </s:else>
 <s:if test="productnumber==null||productnumber==''">
  	<td><div align="center">&nbsp;</div></td>
 </s:if>
 <s:else>
 	<td><div align="center"><s:property value="productnumber"/></div></td>
 </s:else>
    <s:if test="productname==null||productname==''">
  	<td><div align="center">&nbsp;</div></td>
 </s:if>
 <s:else>
 	<td><div align="center"><s:property value="productname"/></div></td>
 </s:else>
    <s:if test="category==null||category==''">
  	<td><div align="center">&nbsp;</div></td>
 </s:if>
 <s:else>
 	<td><div align="center"><s:property value="category"/></div></td>
 </s:else>
    <s:if test="mdlint==null||mdlint==''">
  	<td><div align="center">&nbsp;</div></td>
 </s:if>
 <s:else>
 	<td><div align="center"><s:property value="mdlint"/></div></td>
 </s:else>
     <s:if test="cas==''||cas==null">
  	<td><div align="center">&nbsp;</div></td>
 </s:if>
 <s:else>
 	<td><div align="center"><s:property value="cas"/></div></td>
 </s:else>
     <s:if test="weight==''||weight==null">
  	<td><div align="center">&nbsp;</div></td>
 </s:if>
 <s:else>
 	<td><div align="center"><s:property value="weight"/></div></td>
 </s:else>
    <s:if test="realstock==null||realstock==''">
  	<td><div align="center">&nbsp;</div></td>
 </s:if>
 <s:else>
 	<td><div align="center"><s:property value="realstock"/></div></td>
 </s:else>
 <s:if test="imagepath==null||imagepath==''">
  <td><div align="center">&nbsp;</div></td>
 </s:if>
 <s:else>
 	<td><div align="center"><img src="<%=request.getContextPath()%>/upload/<s:property value="imagepath"/>" width="60" height="30" hspace="0" border="0"/></div></td>
 </s:else>
 <%
 if(u!=null&&u.getSuperuser().equals("3")){  //����Ա
  %>   
    <td><div align="center"><a href="<%=request.getContextPath()%>/product/deleteOrderitemManagerAction.action?pid=<s:property value="id"/>&orderid=<%=orderid %>" >ɾ��</a></div></td>
  <%} %>   
  </tr>
  </s:iterator>
</table>   

</div>
<div>
	<img src="<%=request.getContextPath()%>/images/banquan.jpg" width="800" height="35" border="0"/>
</div>
</body>
</html>

<%@ page language="java" import="java.util.*,com.ascent.po.*,com.ascent.util.*" contentType="text/html;charset=gb2312"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>AscentWeb��������</title>
<link href="<%=request.getContextPath()%>/css/index.css" rel="stylesheet" type="text/css" />

<script language="javascript">
 function check(){
	if(form.username.value == "")
    {
       alert("�û�������Ϊ�գ�"); 
       form.username.focus();
        return false;
    }
    if(form.tel.value!=""){
    	 var mobilereg = /^(((13[0-9]{1})+\d{8}))|(((15[0-9]{1})+\d{8}))$/;
    	 var telreg = /^(((0[0-9]{2})+(\-)+\d{8}))|(((0[0-9]{3})+(\-)+\d{8}))|(((0[0-9]{3})+(\-)+\d{7}))$/;    
  		 var bl1=mobilereg.test(form.tel.value);
  		 var bl2=telreg.test(form.tel.value);
  		 if(bl1||bl2){
  		 	return true;
  		 }else{
  		 	alert("��������ȷ�ֻ���0xx-xxxxxxxx��ʽ�绰");
  		 	form.tel.focus();
  		 	return false;
  		 }
    }
   
    if(form.email.value == "")
    {
        alert("�������ʼ� ��");
        form.email.focus();
         return false;
    }
    
 var regm = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;//��֤Mail��������ʽ,^[a-zA-Z0-9_-]:��ͷ����Ϊ��ĸ,�»���,����,
  if (form.email.value!="" && !form.email.value.match(regm) )
   		 {
     		alert("�ʼ���ʽ���ԣ������������룡");
	     	form.email.focus();
             return false;
   		 }  
  else 
    return true;
}
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
	Usr u = (Usr)session.getAttribute("usr");
	if(u!=null&&u.getSuperuser().equals("3")){  //����Ա
%>
<td width="30%"><div align="left">|&nbsp;&nbsp;��ӭ,<%=u.getUsername() %>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/clearSession.action" class="table_t">ע��</a>&nbsp;&nbsp;|</div></td>
<td width="20%"><div align="center"><a href="<%=request.getContextPath()%>/pageShowProductManagerAction.action"><img src="<%=request.getContextPath()%>/images/productslist.jpg" width="75" height="17" border="0"/></a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/adminShowOrdersManagerAction.action">��������</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/guestPageShowProductManagerAction.action">��������</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/checkout.jsp">��������</a></div></td>
<%}
	else if(u!=null&&u.getSuperuser().equals("2")){  //��Ȩ���û�
 %>
 <td width="30%"><div align="left">|&nbsp;&nbsp;��ӭ,<%=u.getUsername() %>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/clearSession.action" class="table_t">ע��</a>&nbsp;&nbsp;|</div></td>
<td width="20%"><div align="center"><a href="<%=request.getContextPath()%>/product/userProductsProductManagerAction.action">�鿴�ѷ����Ʒ</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/showOrdersManagerAction.action">�鿴����</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/guestPageShowProductManagerAction.action">��������</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/checkout.jsp">��������</a></div></td>
<%}
	else if(u!=null&&u.getSuperuser().equals("1")){  //��ע���û�
 %>
 <td width="30%"><div align="left">|&nbsp;&nbsp;��ӭ,<%=u.getUsername() %>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/clearSession.action" class="table_t">ע��</a>&nbsp;&nbsp;|</div></td>
<td width="20%"><div align="center">&nbsp;</div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/showOrdersManagerAction.action">�鿴����</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/guestPageShowProductManagerAction.action">��������</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/checkout.jsp">��������</a></div></td>
<%}
	else if(u==null){  //δע���û�
 %>
 <td width="30%"><div align="left">|&nbsp;&nbsp;��ӭ,�ο�&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/product/register.jsp" class="table_t">ע��</a>&nbsp;&nbsp;|</div></td>
<td width="20%"><div align="center">&nbsp;</div></td>
<td width="15%"><div align="center">&nbsp;</div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/guestPageShowProductManagerAction.action">��������</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/checkout.jsp">��������</a></div></td>
<%}%>
</tr>
</table>
<br><br>	
<%
	
	Collection col = (Collection)session.getAttribute("cartshowlist");
	if(col==null||col.size()<1){
%>

<center><h3>�������桰�������ѡ����Ʒ����������</h3></center>
<% }else{ %>
<!-- ��Ʒ�б� --> 
<table width="100%" border="1" cellspacing="0" cellpadding="0" class="mars">
  <tr bgcolor="#fba661" height="30"> 
    <td><div align="center">���</div></td>
    <td><div align="center">����</div></td>
    <td><div align="center">���</div></td>
    <td><div align="center">���</div></td>
    <td><div align="center">����</div></td>
  </tr>
 <s:iterator value="#session['cartshowlist']" status="index">
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
    
    <s:if test="realstock==null||realstock==''">
  	<td><div align="center">&nbsp;</div></td>
 </s:if>
 <s:else>
 	<td><div align="center"><s:property value="realstock"/></div></td>
 </s:else>
 <s:if test="quantity==null||quantity==''">
  <td><div align="center"><input type="text" name="quantity" value="" size="4" readonly="readonly"/></div></td>
 </s:if>
 <s:else>
 	<td><div align="center"><input type="text" name="quantity"   size="4" value="<s:property value="quantity"/>" readonly="readonly"/></div></td>
 </s:else>
   
  </tr>
  </s:iterator>
</table>   
<CENTER><H3><s:property value="tip"/></H3></CENTER>


<form name="form" method="post" action="checkoutOrdersManagerAction.action">

<%
if(u!=null){ //��½�û�
 %>
	<input type="hidden" name="uid" value="<%=u.getId() %>">
  <table width="80%" border="0" cellspacing="0" cellpadding="0">
    <tr bgcolor="cccccc" height="20">
      <td>&nbsp;&nbsp;<font size="2">�û���Ϣ��</font></td>
    </tr>
    <tr>
      <td><div align="center">
          <table width="40%" border="0" cellspacing="0" cellpadding="0">
            <tr> 
              <td><div align="right">�û����ƣ�</div></td>
              <td><input name="username" type="text" id="username" value="<%=u.getUsername() %>"></td>
            </tr>
            <tr> 
              <td><div align="right">���õ绰��</div></td>
              <%if(u.getTel()==null||"".equals(u.getTel())){ %>
              <td><input name="tel" type="text" id="tel" value=""></td>
              <%}else{ %>
              <td><input name="tel" type="text" id="tel" value="<%=u.getTel() %>"></td>
              <%} %>
            </tr>
            <tr> 
              <td><div align="right">�������䣺</div></td>
              <td><input name="email" type="text" id="email" value="<%=u.getEmail()%>"></td>
            </tr>
            <tr> 
              <td><div align="right">��˾���ƣ�</div></td>
              
            <%if(u.getCompanyname()==null||"".equals(u.getCompanyname())){ %>
              <td><input name="companyname" type="text" id="companyname" value=""></td>
              <%}else{ %>
              <td><input name="companyname" type="text" id="companyname" value="<%=u.getCompanyname()%>"></td>
              <%} %>
            </tr>
            <tr> 
              <td><div align="right">��˾��ַ��</div></td>
              
            <%if(u.getCompanyaddress()==null||"".equals(u.getCompanyaddress())){ %>
              <td><input name="companyaddress" type="text" id="companyaddress" value=""></td>
              <%}else{ %>
              <td><input name="companyaddress" type="text" id="companyaddress" value="<%=u.getCompanyaddress() %>"></td>
              <%} %>
            </tr>
            <tr> 
              <td colspan="2"> <div align="center">
                  <input type="submit" name="Submit" value="�ύ">&nbsp;&nbsp;&nbsp;&nbsp;
                  <input name="reset" type="reset" id="reset" value="ȡ��">
                </div></td>
            </tr>
          </table>
        </div></td>
    </tr>
  </table>

<%}
else{//δ��½�û�
 %> 
 <table width="80%" border="0" cellspacing="0" cellpadding="0">
    <tr bgcolor="cccccc" height="20">
      <td>&nbsp;&nbsp;<font size="3">�û���Ϣ��</font><font color="red">(ע���û����Ե�½����������/δע���û�����ע���½��ֱ����д��Ϣ)</font></td>
    </tr>
    <tr>
      <td><div align="center">
          <table width="40%" border="0" cellspacing="0" cellpadding="0">
            <tr> 
              <td><div align="right">�û����ƣ�</div></td>
              <td><input name="username" type="text" id="username" value=""></td>
            </tr>
            <tr> 
              <td><div align="right">���õ绰��</div></td>
              <td><input name="tel" type="text" id="tel" value=""></td>
            </tr>
            <tr> 
              <td><div align="right">�������䣺</div></td>
              <td><input name="email" type="text" id="email" value=""></td>
            </tr>
            <tr> 
              <td><div align="right">��˾���ƣ�</div></td>
              <td><input name="companyname" type="text" id="companyname" value=""></td>
            </tr>
            <tr> 
              <td><div align="right">��˾��ַ��</div></td>
              <td><input name="companyaddress" type="text" id="companyaddress" value=""></td>
            </tr>
            <tr> 
              <td colspan="2"> <div align="center">
                  <input type="submit" name="Submit" value="�ύ" onclick="return check();">&nbsp;&nbsp;&nbsp;&nbsp;
                  <input name="reset" type="reset" id="reset" value="ȡ��">
                </div></td>
            </tr>
          </table>
        </div></td>
    </tr>
  </table>
 
<%}} %>
</form> 
</div>
<div>
	<img src="<%=request.getContextPath()%>/images/banquan.jpg" width="800" height="35" border="0"/>
</div>
</body>
</html>

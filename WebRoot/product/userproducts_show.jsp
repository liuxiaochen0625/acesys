<%@ page language="java" import="java.util.*,com.ascent.po.*,com.ascent.util.*" contentType="text/html;charset=gb2312"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>AscentWeb��������</title>
<link href="<%=request.getContextPath()%>/css/index.css" rel="stylesheet" type="text/css" />

<script language="javascript">
 function addshop(str){
   var pid = str;
   send_request('<%=request.getContextPath()%>/product/addCartManagerAction.action?pid='+pid);
  } 
  
  var http_request = false;
	function send_request(url)
	{ //��ʼ����ָ��������������������ĺ���
	   //alert("url\t"+url);
		http_request = false;
		//��ʼ��ʼ��XMLHttpRequest����
		if(window.XMLHttpRequest) 
		{ //Mozilla �����
			http_request = new XMLHttpRequest();
			if(http_request.overrideMimeType) 
			{//����MiME���
				http_request.overrideMimeType('text/xml');
			}
		}
		else if(window.ActiveXObject) 
		{ // IE�����
			try 
			{
				http_request = new ActiveXObject("Msxml2.XMLHTTP");
			} 
			catch(e) 
			{
				try 
				{
					http_request = new ActiveXObject("Microsoft.XMLHTTP");
				}
				catch(e){}
			}
		}
		if(!http_request) 
		{ // �쳣����������ʵ��ʧ��
			window.alert("���ܴ���XMLHttpRequest����ʵ��.");
			return false;
		}
		http_request.onreadystatechange = processRequest;
		// ȷ����������ķ�ʽ��URL�Լ��Ƿ�ͬ��ִ���¶δ���
		http_request.open("POST", url, true);
		http_request.send(null);
	}
	// ����������Ϣ�ĺ���
    function processRequest() 
    {
        if (http_request.readyState == 4) 
        { // �ж϶���״̬
            if (http_request.status == 200) 
            { // ��Ϣ�Ѿ��ɹ����أ���ʼ������Ϣ
               var divhtml = http_request.responseText;
			   alert(divhtml);
            }
        }
       
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
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/pageShowProductManagerAction.action"><img src="<%=request.getContextPath()%>/images/productslist.jpg" width="75" height="17" border="0"/></a></div></td>

<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/adminShowOrdersManagerAction.action">��������</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/Product_Search.jsp">��Ʒ��ѯ</a></div></td>
<td width="20%"><div align="center"><a href="<%=request.getContextPath()%>/product/cartShowCartManagerAction.action">�鿴���ﳵ</a></div></td>
<%}
	else if(u!=null&&u.getSuperuser().equals("2")){  //��Ȩ���û�
 %>
 <td width="30%"><div align="left">|&nbsp;&nbsp;��ӭ,<%=u.getUsername() %>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/clearSession.action" class="table_t">ע��</a>&nbsp;&nbsp;|</div></td>
<td width="20%"><div align="center"><a href="<%=request.getContextPath()%>/product/userProductsProductManagerAction.action">�鿴�ѷ����Ʒ</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/Product_Search.jsp">��Ʒ��ѯ</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/showOrdersManagerAction.action">�鿴����</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/cartShowCartManagerAction.action">�鿴���ﳵ</a></div></td>
<%}
	else if(u!=null&&u.getSuperuser().equals("1")){  //��ע���û�
 %>
 <td width="30%"><div align="left">|&nbsp;&nbsp;��ӭ,<%=u.getUsername() %>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/clearSession.action" class="table_t">ע��</a>&nbsp;&nbsp;|</div></td>
<td width="15%"><div align="center">&nbsp;</div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/Product_Search.jsp">��Ʒ��ѯ</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/showOrdersManagerAction.action">�鿴����</a></div></td>
<td width="20%"><div align="center"><a href="<%=request.getContextPath()%>/product/cartShowCartManagerAction.action">�鿴���ﳵ</a></div></td>
<%}
	else if(u==null){  //δע���û�
 %>
 <td width="30%"><div align="left">|&nbsp;&nbsp;��ӭ,�ο�&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/product/register.jsp" class="table_t">ע��</a>&nbsp;&nbsp;|</div></td>
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
    <td><div align="center">catalogno</div></td>
    <td><div align="center">MDLNumber</div></td>
    <td><div align="center">CAS</div></td>
    <td><div align="center">MW</div></td>
    <td><div align="center">���</div></td>
    <td><div align="center">�۸�1</div></td>
    <td><div align="center">�۸�2</div></td>
    <td><div align="center">ͼƬ</div></td>
    <td><div align="center">����</div></td>
  </tr>
 
  <s:iterator value="#session['userproductslist']" status="index">
 <s:if test="#index.odd==true">
  	<tr bgcolor="#f3f3f3" > 
 </s:if>
 <s:else>
 	<tr bgcolor="#e4f1fe" > 
 </s:else>
 <s:if test="productId==null||productId==''">
  	<td><div align="center">&nbsp;</div></td>
 </s:if>
 <s:else>
 	<td><div align="center"><s:property value="productId"/></div></td>
 </s:else>
    <s:if test="productname==null||productname==''">
  	<td><div align="center">&nbsp;</div></td>
 </s:if>
 <s:else>
 	<td><div align="center"><s:property value="productname"/></div></td>
 </s:else>
    <s:if test="catalogno==null||catalogno==''">
  	<td><div align="center">&nbsp;</div></td>
 </s:if>
 <s:else>
 	<td><div align="center"><s:property value="catalogno"/></div></td>
 </s:else>
    <s:if test="mdlnumber==null||mdlnumber==''">
  	<td><div align="center">&nbsp;</div></td>
 </s:if>
 <s:else>
 	<td><div align="center"><s:property value="mdlnumber"/></div></td>
 </s:else>
     <s:if test="cas==''||cas==null">
  	<td><div align="center">&nbsp;</div></td>
 </s:if>
 <s:else>
 	<td><div align="center"><s:property value="cas"/></div></td>
 </s:else>
     <s:if test="mw==''||mw==null">
  	<td><div align="center">&nbsp;</div></td>
 </s:if>
 <s:else>
 	<td><div align="center"><s:property value="mw"/></div></td>
 </s:else>
    <s:if test="realstock==null||realstock==''">
  	<td><div align="center">&nbsp;</div></td>
 </s:if>
 <s:else>
 	<td><div align="center"><s:property value="realstock"/></div></td>
 </s:else>
    <s:if test="price1==null||price1==''">
  	<td><div align="center">&nbsp;</div></td>
 </s:if>
 <s:else>
 	<td><div align="center"><s:property value="price1"/></div></td>
 </s:else>
    <s:if test="price2==null||price2==''">
  	<td><div align="center">&nbsp;</div></td>
 </s:if>
 <s:else>
 	<td><div align="center"><s:property value="price2"/></div></td>
 </s:else>
 <s:if test="structure==null||structure==''">
  <td><div align="center">&nbsp;</div></td>
 </s:if>
 <s:else>
 	<td><div align="center"><img src="<%=request.getContextPath()%>/upload/<s:property value="structure"/>" width="60" height="30" hspace="0" border="0"/></div></td>
 </s:else>
    
    <td><div align="center"><a href="#" onclick="return addshop(<s:property value="pid"/>)">����</a></div></td>
    
  </tr>
  </s:iterator>
</table>   
 

</div>
<div>
	<img src="<%=request.getContextPath()%>/images/banquan.jpg" width="800" height="35" border="0"/>
</div>
</body>
</html>
<%@ page language="java" import="java.util.*,com.ascent.po.Usr" contentType="text/html;charset=gb2312"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title><s:text name="page"/></title>
<link href="<%=request.getContextPath()%>/css/index.css" rel="stylesheet" type="text/css" />
<!-- script type="text/javascript">
	function check(){
		if(form.username.value==""){
			alert("�û�������Ϊ��");
			form.username.focus();
			return false;
		}
		if(form.password.value==""){
			alert("�û�������Ϊ��");
			form.password.focus();
			return false;
		}
		return true;
	}
</script-->
</head>

<body>

<div class="head">
  <div id="login_1"></div>
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
<div class="head">
  <div class="left_products">
	<div class="img"><img src="<%=request.getContextPath()%>/images/products_02.jpg" width="189" height="32"/></div>
<div class="left_bj">
		<div class="big_k">
		<%
			Usr u =(Usr)session.getAttribute("usr");
			if(u==null){
		%><s:form name="form" method="post" action="usrLoginAction.action">
			<s:textfield name="username" key="user" size="15"/>
			<s:password name="password" key="password" size="15"/>
			<s:submit name="submit" key="submit" />
			</s:form>
			�������<a href="<%=request.getContextPath()%>/product/register.jsp">ע��</a>
			<div class="loading_p"><s:property value="tip"/></div>
			
		<%
			}
			else{
		%>
		
		<div class="loading_p">��ӭ����<%=u.getUsername()%></div>
		<div class="loading_p">���䣺<%=u.getEmail()%></div>
		<div class="loading_p"><a href="<%=request.getContextPath()%>/clearSession.action">ע��</a></div>
		<% if(u.getSuperuser().equals("3")){%>
		<div class="loading_p"><a href="<%=request.getContextPath()%>/product/pageProductuserManagerAction.action">�û�����</a></div>
		
		<%}}%>
		</div>
	</div>
</div>

<div class="right_proaducts">�ҵ�λ�� >> �����������  </div>
<div class="p_ny">
	<div class="md_wenzi">��Ʒ��Ϣ </div>
</div>
<div class="border"></div>
<div class="p_wenzikuang">
	<div class="md_wenzi">
  astaTech�� Inc.�ṩȫ������ҩ������Ƽ���agroche micalҩ���о�&��չ���Ƚ�����ӱ���м��塣
  ���ǵı�Ŀ��������1500��ҩ�����Ʒ�� ������ʮ���µĻ�����ÿ�������ӵ���Ʒ�����������Ƚ����м���Ŀ������ͣ�
  ������ľ����ӱ�İ���������İ������Ȼ�İ����ᡢͪ����ȩ��heterocycles��isatoic����boroinc�������
  ���м�����ܼ�������ҩ���о����̡�AstaTechҲ�ṩ�����м���(10����)������м���(�Զ�)��ʹԭ���Ϻ����ǵ�
  �м����������������ļ۸������Ʒ�ʡ� 
  ��ι�<a href="<%=request.getContextPath()%>/product/guestPageShowProductManagerAction.action">�����Ʒҳ</a>��
  <br> ��Ŀ���������ϱ��ۿ�������<a href="<%=request.getContextPath()%>/product/Product_Search.jsp">��ѯ��Ʒ�����Ʒ</a>
  ����ϲ�������Ͻ������ǵı�Ŀ��(��PDF��SD��ʽ)��������ʼ�����.
  </div>

</div>
<div>
	<img src="<%=request.getContextPath()%>/images/banquan.jpg" width="800" height="35" border="0"/>
</div>



</body>

</html>

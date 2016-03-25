<%@ page language="java" import="java.util.*,com.ascent.po.*,com.ascent.util.*" contentType="text/html;charset=gb2312"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>AscentWeb电子商务</title>
<link href="<%=request.getContextPath()%>/css/index.css" rel="stylesheet" type="text/css" />

<script language="javascript">
 function check(){
	if(form.username.value == "")
    {
       alert("用户名不能为空！"); 
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
  		 	alert("您输入正确手机或0xx-xxxxxxxx格式电话");
  		 	form.tel.focus();
  		 	return false;
  		 }
    }
   
    if(form.email.value == "")
    {
        alert("请输入邮件 ！");
        form.email.focus();
         return false;
    }
    
 var regm = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;//验证Mail的正则表达式,^[a-zA-Z0-9_-]:开头必须为字母,下划线,数字,
  if (form.email.value!="" && !form.email.value.match(regm) )
   		 {
     		alert("邮件格式不对，检查后重新输入！");
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
			<div class="banner_wenzi">|&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/index.jsp">首 页</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/product/itservice.jsp">IT 服务</a>&nbsp;&nbsp;&nbsp;&nbsp;|
			&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/product/products.jsp">电子商务系统</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/product/employee.jsp">员工招聘</a>&nbsp;&nbsp;&nbsp;&nbsp;|
			&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/product/ContactUs.jsp">关于我们</a></div>
		</div>
	<div id="bannerbj1"></div>	
</div>
<div class="padding">
<div id="middlebody">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
<tr> 
<%
	Usr u = (Usr)session.getAttribute("usr");
	if(u!=null&&u.getSuperuser().equals("3")){  //管理员
%>
<td width="30%"><div align="left">|&nbsp;&nbsp;欢迎,<%=u.getUsername() %>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/clearSession.action" class="table_t">注销</a>&nbsp;&nbsp;|</div></td>
<td width="20%"><div align="center"><a href="<%=request.getContextPath()%>/pageShowProductManagerAction.action"><img src="<%=request.getContextPath()%>/images/productslist.jpg" width="75" height="17" border="0"/></a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/adminShowOrdersManagerAction.action">订单管理</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/guestPageShowProductManagerAction.action">继续购物</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/checkout.jsp">结算中心</a></div></td>
<%}
	else if(u!=null&&u.getSuperuser().equals("2")){  //高权限用户
 %>
 <td width="30%"><div align="left">|&nbsp;&nbsp;欢迎,<%=u.getUsername() %>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/clearSession.action" class="table_t">注销</a>&nbsp;&nbsp;|</div></td>
<td width="20%"><div align="center"><a href="<%=request.getContextPath()%>/product/userProductsProductManagerAction.action">查看已分配产品</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/showOrdersManagerAction.action">查看订单</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/guestPageShowProductManagerAction.action">继续购物</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/checkout.jsp">结算中心</a></div></td>
<%}
	else if(u!=null&&u.getSuperuser().equals("1")){  //刚注册用户
 %>
 <td width="30%"><div align="left">|&nbsp;&nbsp;欢迎,<%=u.getUsername() %>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/clearSession.action" class="table_t">注销</a>&nbsp;&nbsp;|</div></td>
<td width="20%"><div align="center">&nbsp;</div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/showOrdersManagerAction.action">查看订单</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/guestPageShowProductManagerAction.action">继续购物</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/checkout.jsp">结算中心</a></div></td>
<%}
	else if(u==null){  //未注册用户
 %>
 <td width="30%"><div align="left">|&nbsp;&nbsp;欢迎,游客&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/product/register.jsp" class="table_t">注册</a>&nbsp;&nbsp;|</div></td>
<td width="20%"><div align="center">&nbsp;</div></td>
<td width="15%"><div align="center">&nbsp;</div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/guestPageShowProductManagerAction.action">继续购物</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/checkout.jsp">结算中心</a></div></td>
<%}%>
</tr>
</table>
<br><br>	
<%
	
	Collection col = (Collection)session.getAttribute("cartshowlist");
	if(col==null||col.size()<1){
%>

<center><h3>请点击上面“继续购物”选择商品后再来结算</h3></center>
<% }else{ %>
<!-- 产品列表 --> 
<table width="100%" border="1" cellspacing="0" cellpadding="0" class="mars">
  <tr bgcolor="#fba661" height="30"> 
    <td><div align="center">编号</div></td>
    <td><div align="center">名称</div></td>
    <td><div align="center">类别</div></td>
    <td><div align="center">库存</div></td>
    <td><div align="center">质量</div></td>
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
if(u!=null){ //登陆用户
 %>
	<input type="hidden" name="uid" value="<%=u.getId() %>">
  <table width="80%" border="0" cellspacing="0" cellpadding="0">
    <tr bgcolor="cccccc" height="20">
      <td>&nbsp;&nbsp;<font size="2">用户信息：</font></td>
    </tr>
    <tr>
      <td><div align="center">
          <table width="40%" border="0" cellspacing="0" cellpadding="0">
            <tr> 
              <td><div align="right">用户名称：</div></td>
              <td><input name="username" type="text" id="username" value="<%=u.getUsername() %>"></td>
            </tr>
            <tr> 
              <td><div align="right">常用电话：</div></td>
              <%if(u.getTel()==null||"".equals(u.getTel())){ %>
              <td><input name="tel" type="text" id="tel" value=""></td>
              <%}else{ %>
              <td><input name="tel" type="text" id="tel" value="<%=u.getTel() %>"></td>
              <%} %>
            </tr>
            <tr> 
              <td><div align="right">常用邮箱：</div></td>
              <td><input name="email" type="text" id="email" value="<%=u.getEmail()%>"></td>
            </tr>
            <tr> 
              <td><div align="right">公司名称：</div></td>
              
            <%if(u.getCompanyname()==null||"".equals(u.getCompanyname())){ %>
              <td><input name="companyname" type="text" id="companyname" value=""></td>
              <%}else{ %>
              <td><input name="companyname" type="text" id="companyname" value="<%=u.getCompanyname()%>"></td>
              <%} %>
            </tr>
            <tr> 
              <td><div align="right">公司地址：</div></td>
              
            <%if(u.getCompanyaddress()==null||"".equals(u.getCompanyaddress())){ %>
              <td><input name="companyaddress" type="text" id="companyaddress" value=""></td>
              <%}else{ %>
              <td><input name="companyaddress" type="text" id="companyaddress" value="<%=u.getCompanyaddress() %>"></td>
              <%} %>
            </tr>
            <tr> 
              <td colspan="2"> <div align="center">
                  <input type="submit" name="Submit" value="提交">&nbsp;&nbsp;&nbsp;&nbsp;
                  <input name="reset" type="reset" id="reset" value="取消">
                </div></td>
            </tr>
          </table>
        </div></td>
    </tr>
  </table>

<%}
else{//未登陆用户
 %> 
 <table width="80%" border="0" cellspacing="0" cellpadding="0">
    <tr bgcolor="cccccc" height="20">
      <td>&nbsp;&nbsp;<font size="3">用户信息：</font><font color="red">(注册用户可以登陆后再来结算/未注册用户可以注册登陆或直接填写信息)</font></td>
    </tr>
    <tr>
      <td><div align="center">
          <table width="40%" border="0" cellspacing="0" cellpadding="0">
            <tr> 
              <td><div align="right">用户名称：</div></td>
              <td><input name="username" type="text" id="username" value=""></td>
            </tr>
            <tr> 
              <td><div align="right">常用电话：</div></td>
              <td><input name="tel" type="text" id="tel" value=""></td>
            </tr>
            <tr> 
              <td><div align="right">常用邮箱：</div></td>
              <td><input name="email" type="text" id="email" value=""></td>
            </tr>
            <tr> 
              <td><div align="right">公司名称：</div></td>
              <td><input name="companyname" type="text" id="companyname" value=""></td>
            </tr>
            <tr> 
              <td><div align="right">公司地址：</div></td>
              <td><input name="companyaddress" type="text" id="companyaddress" value=""></td>
            </tr>
            <tr> 
              <td colspan="2"> <div align="center">
                  <input type="submit" name="Submit" value="提交" onclick="return check();">&nbsp;&nbsp;&nbsp;&nbsp;
                  <input name="reset" type="reset" id="reset" value="取消">
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

<%@ page language="java" import="java.util.*,com.ascent.po.*,com.ascent.util.*" contentType="text/html;charset=gb2312"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>AscentWeb电子商务</title>
<link href="<%=request.getContextPath()%>/css/index.css" rel="stylesheet" type="text/css" />

<script language="javascript">
 function addshop(str){
   var pid = str;
   send_request('<%=request.getContextPath()%>/product/addCartManagerAction.action?pid='+pid);
  } 
  
  var http_request = false;
	function send_request(url)
	{ //初始化、指定处理函数、发送请求的函数
	   //alert("url\t"+url);
		http_request = false;
		//开始初始化XMLHttpRequest对象
		if(window.XMLHttpRequest) 
		{ //Mozilla 浏览器
			http_request = new XMLHttpRequest();
			if(http_request.overrideMimeType) 
			{//设置MiME类别
				http_request.overrideMimeType('text/xml');
			}
		}
		else if(window.ActiveXObject) 
		{ // IE浏览器
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
		{ // 异常，创建对象实例失败
			window.alert("不能创建XMLHttpRequest对象实例.");
			return false;
		}
		http_request.onreadystatechange = processRequest;
		// 确定发送请求的方式和URL以及是否同步执行下段代码
		http_request.open("POST", url, true);
		http_request.send(null);
	}
	// 处理返回信息的函数
    function processRequest() 
    {
        if (http_request.readyState == 4) 
        { // 判断对象状态
            if (http_request.status == 200) 
            { // 信息已经成功返回，开始处理信息
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
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/pageShowProductManagerAction.action"><img src="<%=request.getContextPath()%>/images/productslist.jpg" width="75" height="17" border="0"/></a></div></td>

<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/adminShowOrdersManagerAction.action">订单管理</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/Product_Search.jsp">商品查询</a></div></td>
<td width="20%"><div align="center"><a href="<%=request.getContextPath()%>/product/cartShowCartManagerAction.action">查看购物车</a></div></td>
<%}
	else if(u!=null&&u.getSuperuser().equals("2")){  //高权限用户
 %>
 <td width="30%"><div align="left">|&nbsp;&nbsp;欢迎,<%=u.getUsername() %>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/clearSession.action" class="table_t">注销</a>&nbsp;&nbsp;|</div></td>
<td width="20%"><div align="center"><a href="<%=request.getContextPath()%>/product/userProductsProductManagerAction.action">查看已分配产品</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/Product_Search.jsp">商品查询</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/showOrdersManagerAction.action">查看订单</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/cartShowCartManagerAction.action">查看购物车</a></div></td>
<%}
	else if(u!=null&&u.getSuperuser().equals("1")){  //刚注册用户
 %>
 <td width="30%"><div align="left">|&nbsp;&nbsp;欢迎,<%=u.getUsername() %>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/clearSession.action" class="table_t">注销</a>&nbsp;&nbsp;|</div></td>
<td width="15%"><div align="center">&nbsp;</div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/Product_Search.jsp">商品查询</a></div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/showOrdersManagerAction.action">查看订单</a></div></td>
<td width="20%"><div align="center"><a href="<%=request.getContextPath()%>/product/cartShowCartManagerAction.action">查看购物车</a></div></td>
<%}
	else if(u==null){  //未注册用户
 %>
 <td width="30%"><div align="left">|&nbsp;&nbsp;欢迎,游客&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/product/register.jsp" class="table_t">注册</a>&nbsp;&nbsp;|</div></td>
<td width="15%"><div align="center">&nbsp;</div></td>
<td width="15%"><div align="center">&nbsp;</div></td>
<td width="15%"><div align="center"><a href="<%=request.getContextPath()%>/product/Product_Search.jsp">商品查询</a></div></td>
<td width="20%"><div align="center"><a href="<%=request.getContextPath()%>/product/cartShowCartManagerAction.action">查看购物车</a></div></td>
<%}%>
</tr>
</table>
<br><br>	

<!-- 产品列表 --> 
<table width="100%" border="1" cellspacing="0" cellpadding="0" class="mars">
  <tr bgcolor="#fba661" height="30"> 
    <td><div align="center">编号</div></td>
    <td><div align="center">名称</div></td>
    <td><div align="center">catalogno</div></td>
    <td><div align="center">MDLNumber</div></td>
    <td><div align="center">CAS</div></td>
    <td><div align="center">MW</div></td>
    <td><div align="center">库存</div></td>
    <td><div align="center">价格1</div></td>
    <td><div align="center">价格2</div></td>
    <td><div align="center">图片</div></td>
    <td><div align="center">购买</div></td>
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
    
    <td><div align="center"><a href="#" onclick="return addshop(<s:property value="pid"/>)">购买</a></div></td>
    
  </tr>
  </s:iterator>
</table>   
 

</div>
<div>
	<img src="<%=request.getContextPath()%>/images/banquan.jpg" width="800" height="35" border="0"/>
</div>
</body>
</html>

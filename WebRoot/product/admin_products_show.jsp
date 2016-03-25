<%@ page language="java" import="java.util.*,com.ascent.util.*,com.ascent.po.*" pageEncoding="GB2312" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>AscentWeb电子商务</title>
<link href="<%=request.getContextPath()%>/css/index.css" rel="stylesheet" type="text/css" />

<script>
	function selectAll()
{
    if(form.check1.checked)
    {
        if(form.infoid.length>1)
        {
            for(var i=0;i<form.infoid.length;i++)
            {
                form.infoid[i].checked=true;
            }
        }
        else
        {
            form.infoid.checked=true;
        }
    }
    else
    {
        if(form.infoid.length>1)
        {
            for(var i=0;i<form.infoid.length;i++)  
            {
                form.infoid[i].checked=false;
            }
        }
        else
        {
            form.infoid.checked=false;
            
        }
    }
}
</script> 


<script language="javascript">
	function deleteproduct(){
	var from = form.infoid;
	var ch="";  
	var checkNum =0; 
  for(var i=0;i<form.infoid.length;i++)   
  {  
 if(form.infoid[i].type == "checkbox")
   {
    if (form.infoid[i].checked)
    {
     checkNum++;
     break;
    }
  }
 }   
if(checkNum < 1)
   {
		alert("Please select！");
        return;
    }
    else
    {
		if(window.confirm("Are you sure?") == false)
        {
			return;
        }
        else
        {
			form.action="<%=request.getContextPath()%>/admindeleteproduct.do";
            form.submit();
        }
    }
	
	}
	
	
	function addnewproduct(){
	
	var from = form.infoid;
	var ch="";  
	var checkNum =0; 
  for(var i=0;i<form.infoid.length;i++)   
  {  
 if(form.infoid[i].type == "checkbox")
   {
    if (form.infoid[i].checked)
    {
     checkNum++;
     break;
    }
  }
 }   
	if(checkNum < 1)
   {
		alert("Please select！");
        return;
    }else{
	
	form.action="<%=request.getContextPath()%>/addnewproduct.do";
	form.submit();
	
}
    }
    
    
    function confirm_oper(){
		if (!confirm("确定该操作吗？")) return false;
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
	<table width="800">
		<tr>
		<td height="20" colspan="6" background="" class="" border="0"><div class="table_t" id="result_box" dir="ltr">
		  <div align="right">　　 </div>
		</div></td>

<%
	Usr u = (Usr)session.getAttribute("usr");
	if(u!=null&&u.getSuperuser().equals("3")){
%>
<td height="20"><div class="table_t">|&nbsp;&nbsp;欢迎,<%=u.getUsername()%>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/clearSession.action" class="table_t">注销</a>&nbsp;&nbsp;|</div></td>
 <td><div> <a href="<%=request.getContextPath()%>/product/pageusrManagerAction.action"><img src="<%=request.getContextPath()%>/images/userlist.jpg"  border="0"/></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/pageShowProductManagerAction.action"><img src="<%=request.getContextPath()%>/images/productslist.jpg"  border="0"/></a>&nbsp;&nbsp;&nbsp;&nbsp; <a href="<%=request.getContextPath()%>/product/adminShowOrdersManagerAction.action"><img src="<%=request.getContextPath()%>/images/ShowOrders.jpg"  border="0"/></a>  &nbsp;&nbsp;&nbsp;&nbsp;  <a href="<%=request.getContextPath()%>/product/add_products_admin.jsp"> <img src="<%=request.getContextPath()%>/images/addProduct.jpg"  border="0"/> </a>&nbsp;&nbsp;&nbsp;&nbsp;  <a href="<%=request.getContextPath()%>/product/add_products_excel_admin.jsp" > <img src="<%=request.getContextPath()%>/images/ExcelAdd.jpg"  border="0"/> </a>     </div></td>
</tr>

<!-- 产品列表 --> 
<table width="100%" border="1" cellspacing="0" cellpadding="0" class="mars">
  <tr bgcolor="#fba661" height="30"> 
    <td><div align="center">编号</div></td>
    <td><div align="center">名称</div></td>
    <td><div align="center">catalogno</div></td>
    <td><div align="center">MDLNumber</div></td>
    <td><div align="center">价钱1</div></td>
    <td><div align="center">价钱2</div></td>
    <td><div align="center">库存</div></td>
    <td><div align="center">图片</div></td>
    <td><div align="center">修改</div></td>
    <td><div align="center">删除</div></td>
  </tr>
  <%
 PageBean pBean = (PageBean)session.getAttribute("product_page_list");
 %>
  <s:iterator value="dataList" status="index">
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
     <s:if test="price1==''||price1==null">
  	<td><div align="center">&nbsp;</div></td>
 </s:if>
 <s:else>
 	<td><div align="center"><s:property value="price1"/></div></td>
 </s:else>
     <s:if test="price2==''||price2==null">
  	<td><div align="center">&nbsp;</div></td>
 </s:if>
 <s:else>
 	<td><div align="center"><s:property value="price2"/></div></td>
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
    
    <td><div align="center"><a href="find_updateProductManagerAction.action?pid=<s:property value="id"/>" ><img src="<%=request.getContextPath()%>/images/update1.gif" width="20" height="20" border="0" alt="修改"/></a></div></td>
    <td><div align="center"><a href="deleteProductManagerAction.action?pid=<s:property value="id"/>" onclick="return confirm_oper();"><img src="<%=request.getContextPath()%>/images/sz_tu02.gif" border="0" alt="删除"/></a></div></td>
  </tr>
  </s:iterator>
</table>   
 <%
 if(pBean.totalPage!=1){  
 %>   
       <form name="pageForm" action="pageShowProductManagerAction.action" method="post">         
      <%@ include file="page.jsp" %>   
      </form>         
      <%} 
 }else	//最上面的if的else
{ 
%>
<br><br><br><br><br><br>
<center><h3>对不起，您没有权限查看！！！</h3></center>
<br><br><br><br><br><br>
<br><br><br><br><br><br>
<%} %>     
</table>
</div>
<div>
	<img src="<%=request.getContextPath()%>/images/banquan.jpg" width="800" height="35" border="0"/>
</div>
</body>
</html>

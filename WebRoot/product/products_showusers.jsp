<%@ page language="java" import="java.util.*,com.ascent.po.Usr,com.ascent.util.PageBean" pageEncoding="GB2312" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<% String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>AscentWeb电子商务</title>
<link href="<%=request.getContextPath()%>/css/index.css" rel="stylesheet" type="text/css" />

<script language="javascript">

function updaetusertype(Obj)
  {
  	///var proid = Obj.value;
  	var proid = Obj.name;
  	if(window.confirm("Are you sure?") == false)
        {
			return;
        }
        else
        {
            send_request('<%=path%>/update_usertype.do?title='+proid);
        }
  }


function deleteuser()
{
   var from = form.infoid;
   var checkNum = 0; 
 for(var i=0;i<form.infoid.length;i++)   
   {  
     if(form.infoid[i].type == "checkbox")
    {
      if (form.infoid[i].checked)
      {
        checkNum++;
        alert(checkNum);
        break;
      }
   }
  }   
 if(checkNum < 1)
    {
		alert("Please select information to delete");
        return;
    }
    else
    {
		if(window.confirm("Are you sure? ") == false)
        {
			return;
        }
        else
        {
            form.action="<%=request.getContextPath()%>/deleteproductuser.do";
		    form.submit();
        }
    }	
}



function addproject(Obj){
  	var proid = Obj.name;
  	var strs = window.showModalDialog('<%=request.getContextPath()%>/useraddproduct.do?id='+proid+'',window,'dialogWidth:300pt;dialogHeight:240pt;status:no;help:no;scroll:auto;');
  }
function updateuser(Obj){
  	var proid = Obj.name;
  	////var strs = window.showModalDialog('useraddproduct.do?id='+proid+'',window,'dialogWidth:300pt;dialogHeight:240pt;status:no;help:no;scroll:auto;');
    //form.action="<%=request.getContextPath()%>/updateadmin.do?id="+proid;
	//form.submit();
  }  
  
 function  returnresult()
 {
  alert("chenggong");
 }
 function selectAll()
{
    if(form.allck.checked)
    {
        if(form.infoid.length>0)
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
        if(form.infoid.length>0)
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
 
 function openwin(uid) { 
	//alert("openwin"+uid);
	window.open ("<%=request.getContextPath()%>/product/allProducts.jsp?uid="+uid, "newwindow", " top=50 , left=400 ,height=300, width=400, toolbar=no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no") ;
	//写成一行 
	//window.showModalDialog("<%=request.getContextPath()%>/product/allProducts.jsp?uid="+uid,window,'dialogWidth:300pt;dialogHeight:240pt;status:no;help:no;scroll:auto;');

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
<div id="div1"> 
	<%
		Usr u = (Usr)session.getAttribute("usr");
		if(u!=null&&u.getSuperuser().equals("3")){
	%>
<tr>
<td height="20"><div class="table_t">|&nbsp;&nbsp;欢迎,<%=u.getUsername()%>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/clearSession.action" class="table_t">注销</a>&nbsp;&nbsp;|</div></td>
</tr>
</div>
<br/>

<div> <a href="<%=request.getContextPath()%>/product/pageusrManagerAction.action"><img src="<%=request.getContextPath()%>/images/userlist.jpg"  border="0"/></a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/pageShowProductManagerAction.action"><img src="<%=request.getContextPath()%>/images/productslist.jpg"  border="0"/></a> &nbsp;&nbsp;&nbsp;&nbsp;   <a href="<%=request.getContextPath()%>/product/mailmanager.jsp"><img src="<%=request.getContextPath()%>/images/mailmanager.jpg"  border="0"/> </a></div>

<br/>

<!-- 下面是用户列表 --> 
<table width="100%" border="1" cellspacing="0" cellpadding="0" class="mars" >
  <tr bgcolor="#fba661" height="25"> 
    <td width="10%"><div align="center">用户名</div></td>
    <td width="13%"><div align="center">Email</div></td>
    <td width="12%"><div align="center">电话</div></td>
    <td width="13%"><div align="center">公司名称</div></td>
    <td width="13%"><div align="center">角色</div></td>
    <td width="9%"><div align="center">修改</div></td>
    <td width="10%"><div align="center">角色修改</div></td>
    <td width="10%"><div align="center">授权商品</div></td>
    <td width="10%"><div align="center">状态</div></td>
  </tr>
  <%
 PageBean pBean = (PageBean)session.getAttribute("product_page_list");
 %>
<s:iterator value="dataList" status="index">
 <s:if test="#index.odd==true">
  	<tr bgcolor="#f3f3f3" height="25"> 
 </s:if>
 <s:else>
 	<tr bgcolor="#e4f1fe" height="25"> 
 </s:else>
 	<td><div align="center"><s:property value="username"/></div></td>
	<td><div align="center"><s:property value="email"/></div></td>
    <td><div align="center">
    <s:if test="''.equals(tel)||tel==null">
    	&nbsp;
    </s:if>
    <s:else>
    <s:property value="tel"/>
    </s:else>
    </div></td>
    <td><div align="center">
    
     <s:if test="''.equals(companyname)||companyname==null">
    	&nbsp;
    </s:if>
    <s:else>
    <s:property value="companyname"/>
    </s:else>
    </div></td>
    <td><div align="center">
   <s:if test="superuser==1">
    	普通用户
    </s:if>
    <s:elseif test="superuser==2">
    	高权用户
    </s:elseif>
    <s:elseif test="superuser==3">
    	管理员
    </s:elseif>
    <s:else>
    	<s:property value="superuser"/>
    </s:else>
    </div></td>
  <td><div align="center"><a href="find_updateusrManagerAction.action?uid=<s:property value="id"/>"><img src="<%=request.getContextPath()%>/images/update1.gif" width="20" height="20" border="0" alt="修改"/></a></div></td>
    <td><div align="center"><a href="<%=request.getContextPath()%>/product/changesuperuser.jsp?uid=<s:property value="id"/>&superuser=<s:property value="superuser"/>"><img src="<%=request.getContextPath()%>/images/Changeuser.gif" width="20" height="20" border="0" alt="角色修改"/></a></div></td>
	<s:if test="superuser==2&&delsoft==0">
	<td><div align="center"><a href="#" onclick="openwin(<s:property value="id"/>)"><img src="<%=request.getContextPath()%>/images/perm.gif" width="20" height="14" border="0" alt="授权商品"/></a></div></td>
    </s:if> 
	<s:else>
	<td><div align="center"><img src="<%=request.getContextPath()%>/images/exception.gif" width="20" height="20" border="0" alt="无权限"/></div></td>
	</s:else>
<s:if test="superuser==3">
    	<td><div align="center">无操作</div></td>
</s:if> 
<s:else>
    <s:if test="delsoft==0">
    	<td><div align="center"><a href="deleteusrManagerAction.action?uid=<s:property value="id"/>" onclick="return confirm_oper();"><img src="<%=request.getContextPath()%>/images/sz_tu01.gif" border="0" alt="删除"/></a></div></td>
    </s:if>
    <s:elseif test="delsoft==1">
    	<td><div align="center"><a href="restoreusrManagerAction.action?uid=<s:property value="id"/>" onclick="return confirm_oper();"><img src="<%=request.getContextPath()%>/images/sz_tu02.gif" border="0" alt="恢复"/></a></div></td>
    </s:elseif>
</s:else>     
    </tr>
</s:iterator> 
</table> 

 <%
 if(pBean.totalPage!=1){  
 %>   
       <form name="pageForm" action="pageusrManagerAction.action" method="post">         
      <%@ include file="page.jsp" %>   
      </form>         
      <%} %>    



<%}
else	//最上面的if的else
{ 
%>
<br><br><br><br><br><br>
<center><h3>对不起，您没有权限查看！！！</h3></center>
<br><br>
<%} %>     
</div>
<div>
	<img src="<%=request.getContextPath()%>/images/banquan.jpg" width="800" height="35" border="0"/>
</div>
</body>
</html>

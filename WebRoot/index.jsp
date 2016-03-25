<%@ page language="java" import="java.util.*" pageEncoding="GB2312" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>AscentWeb电子商务</title>

<link href="<%=request.getContextPath()%>/css/index.css" rel="stylesheet" type="text/css" />

<script language="javascript">
	function denglu(){
	if(form.username.value == "")
    {
        alert("用户名不能为空");
        form.username.focus();
        return false;
    }
    if(form.password.value == "")
    {
        alert("密码不能为空");
        form.password.focus();
        return false;
    }
		form.action="<%=request.getContextPath()%>/usrLoginAction.action";
		form.submit();
	}

</script>

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
<%
 
           
%>
<form name="form" method="post" action="<%=request.getContextPath() %>/usrLoginAction.action">
<div class="head">
	
<div id="login_1">
	<div id="login_1_n">
	    <div id="login_1_wz"></div>
        <div class="lodaing_w"></div>
        <div class="lodaing_ww"></div>
        <div class="lodaing_i"></div>


</div>
   </div>
	<div id="login_2">
      <div id="Layer1" style="position:absolute; width:300px; height:37px; z-index:1; left: 550px; top:20px;"> 
        <table width="300" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="132" valign="middle"> <img src="<%=request.getContextPath()%>/images/username.jpg" width="61" height="17" align="bottom" /> 
              <input name="username" type="text" size="6"/>
            </td>
            <td width="131"><img src="<%=request.getContextPath()%>/images/password.jpg" width="61" height="17" /> 
              <input name="password" type="password" size="6" />
            </td>
            <td width="37"><input type="image" src="<%=request.getContextPath()%>/images/login_1_7.jpg" onclick="return denglu()" width="44" height="17" border="0" alt="登录"/></td>
          
          </tr>
        </table>
      </div>
    </div>
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
<div class="head">
<div id="left">
	<div class="duiqi"></div>
	
		<div class="magin">
		<img src="<%=request.getContextPath()%>/images/lxrycyy.gif" />
		</div>
</div>
<div id="middle">
	<div class="img"></div>
	<div id="md_wenzik">
  <div class="md_wenzi">
  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;亚思晟商务科技有限公司（简称 &quot;亚思晟科技&quot;），是由海外归国IT专业技术人士在中关村海淀留学生创业园创办成立。
公司总部位于北京，在加拿大，美国，日本及国内的石家庄，长春，秦皇岛，吉林，廊坊等地设有分部。凭借着卓越的技术水平、经验丰富的管理团队，
强大的资源整合能力和“诚信、开放、创新、卓越”的经营理念，亚思晟科技奠定了公司在本地和海外IT服务市场的优势地位，获得了客户的一致认可和好评，
并与客户建立了长期的战略合作伙伴关系。公司立足于中国IT的现实和特点，利用国际先进成熟的技术和经验，提供高端优质的IT服务,包括软件高端培训、
软件开发及维护、软件外包、软件产品研发和本地化等。 
公司具有突出的技术优势，包括：具备北美电子应用平台技术；通过北京中关村科技园高科技产品认证，公司还具有突出的人才优势，拥有美国MBA,
纽约华尔街及加拿大证券交易中心认证管理专家；以及其它加拿大IT技术移民和海外留学人员。
  </div>
  </div>
</div>
<div class="right">
	<div class="img"><img src="<%=request.getContextPath()%>/images/home_14.jpg" width="203" height="26"/></div>
	<div id="miaobian">
<MARQUEE id=scrollArea1 onmouseover="javascript:this.stop()"
                  onmouseout="javascript:this.start()" scrollAmount=1 scrollDelay=60
                  direction=up width="178" height=250 border="0">
<s:action name="newProductsProductManagerAction"/>
<s:iterator value="#session['newproductslist']" status="index">         
	<div class="rt_wenzi">
	<a href="<%=request.getContextPath()%>/productDetailProductManagerAction.action?pid=<s:property value="id"/>"><s:property value="productname"/></a>
	</div>
	<div class="rt_img"><a href="#" onclick="return addshop(<s:property value="id"/>)"><img src="<%=request.getContextPath()%>/images/buy.gif" width="20" height="16" border="0"/></a></div>
</s:iterator>
	
</MARQUEE>
	</div>
</div>

</div>
</form>
<div>
	<img src="<%=request.getContextPath()%>/images/banquan.jpg" width="800" height="35" border="0"/>
</div>
</body>
</html>

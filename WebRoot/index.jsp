<%@ page language="java" import="java.util.*" pageEncoding="GB2312" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>AscentWeb��������</title>

<link href="<%=request.getContextPath()%>/css/index.css" rel="stylesheet" type="text/css" />

<script language="javascript">
	function denglu(){
	if(form.username.value == "")
    {
        alert("�û�������Ϊ��");
        form.username.focus();
        return false;
    }
    if(form.password.value == "")
    {
        alert("���벻��Ϊ��");
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
            <td width="37"><input type="image" src="<%=request.getContextPath()%>/images/login_1_7.jpg" onclick="return denglu()" width="44" height="17" border="0" alt="��¼"/></td>
          
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
			<div class="banner_wenzi">|&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/index.jsp">�� ҳ</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/product/itservice.jsp">IT ����</a>&nbsp;&nbsp;&nbsp;&nbsp;|
			&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/product/products.jsp">��������ϵͳ</a>&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/product/employee.jsp">Ա����Ƹ</a>&nbsp;&nbsp;&nbsp;&nbsp;|
			&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/product/ContactUs.jsp">��������</a></div>
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
  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;��˼������Ƽ����޹�˾����� &quot;��˼�ɿƼ�&quot;�������ɺ�����ITרҵ������ʿ���йش庣����ѧ����ҵ԰���������
��˾�ܲ�λ�ڱ������ڼ��ô��������ձ������ڵ�ʯ��ׯ���������ػʵ������֣��ȷ��ȵ����зֲ���ƾ����׿Խ�ļ���ˮƽ������ḻ�Ĺ����Ŷӣ�
ǿ�����Դ���������͡����š����š����¡�׿Խ���ľ�Ӫ�����˼�ɿƼ��춨�˹�˾�ڱ��غͺ���IT�����г������Ƶ�λ������˿ͻ���һ���Ͽɺͺ�����
����ͻ������˳��ڵ�ս�Ժ�������ϵ����˾�������й�IT����ʵ���ص㣬���ù����Ƚ�����ļ����;��飬�ṩ�߶����ʵ�IT����,���������߶���ѵ��
����������ά�������������������Ʒ�з��ͱ��ػ��ȡ� 
��˾����ͻ���ļ������ƣ��������߱���������Ӧ��ƽ̨������ͨ�������йش�Ƽ�԰�߿Ƽ���Ʒ��֤����˾������ͻ�����˲����ƣ�ӵ������MBA,
ŦԼ�����ּ����ô�֤ȯ����������֤����ר�ң��Լ��������ô�IT��������ͺ�����ѧ��Ա��
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
<%@ page language="java" import="java.util.*,com.ascent.util.PageBean" pageEncoding="gb2312"%>
<%
 PageBean pb = (PageBean)session.getAttribute("product_page_list");
 %>
  <script language="JavaScript">
    function Jumping(){
       document.pageForm.submit();         
    }    
    function gotoPage(pagenum){
    	//alert(pagenum);
    	//alert(document.pageForm.jumpPage.value);
       document.pageForm.jumpPage.value = pagenum;
       document.pageForm.submit();       
    }
  </script>    
		<table>  
		  <tr>
		    <td>ÿҳ<%=pb.rowsPage%>��</td>
		    <td>��<%=pb.totalRows%>��</td>
		    <td>��<%=pb.currentPage%>ҳ</td><td>��<%=pb.totalPage%>ҳ</td>
		    <td>
		    	<%if(pb.currentPage==1){out.print("��ҳ����һҳ");}else{%>
		      <a href="javascript:gotoPage(1)">��ҳ</a>
		      <a href="javascript:gotoPage(<%=pb.currentPage-1%>)">��һҳ</a>
		      <%
		      }
		       %> 
		       <%if(pb.currentPage==pb.totalPage){out.print("��һҳ��βҳ");}else{%>
		       <a href="javascript:gotoPage(<%=pb.currentPage+1%>)">��һҳ</a>
		       <a href="javascript:gotoPage(<%=pb.totalPage%>)">βҳ</a>
		       <%} %>
		    </td>
		    <td>		    	
				     ת����<select name="jumpPage" onchange="Jumping()">
				      <%for(int i=1;i<=pb.totalPage;i++){
				          if(i==pb.currentPage){
				      %>
				      
				      <option selected value=<%=i%>><%=i%></option>
				      <%
				      }
				      else
				      {
				       %>
				       <option value=<%=i%>><%=i%></option>
				       <%
				       }
				       }
				        %>
				        </select>ҳ
		      </td>
		  </tr>
		</table>
      
        
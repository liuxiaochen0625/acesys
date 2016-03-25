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
		    <td>每页<%=pb.rowsPage%>行</td>
		    <td>共<%=pb.totalRows%>行</td>
		    <td>第<%=pb.currentPage%>页</td><td>共<%=pb.totalPage%>页</td>
		    <td>
		    	<%if(pb.currentPage==1){out.print("首页　上一页");}else{%>
		      <a href="javascript:gotoPage(1)">首页</a>
		      <a href="javascript:gotoPage(<%=pb.currentPage-1%>)">上一页</a>
		      <%
		      }
		       %> 
		       <%if(pb.currentPage==pb.totalPage){out.print("下一页　尾页");}else{%>
		       <a href="javascript:gotoPage(<%=pb.currentPage+1%>)">下一页</a>
		       <a href="javascript:gotoPage(<%=pb.totalPage%>)">尾页</a>
		       <%} %>
		    </td>
		    <td>		    	
				     转到第<select name="jumpPage" onchange="Jumping()">
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
				        </select>页
		      </td>
		  </tr>
		</table>
      
        
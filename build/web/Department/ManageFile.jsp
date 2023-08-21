<%@page import="java.sql.*"%>
<%@page import="FileTrack.MyLib"%>
<h1>Manage Admins</h1>
<h3><a href="DepartmentHome.jsp">Back</a></h3>
<%
   Connection cn=new MyLib().getConnection();
   String sql="select * from Filedata ";
   PreparedStatement p1=cn.prepareStatement(sql);
   ResultSet r1=p1.executeQuery();
   while(r1.next())
   {
       String a,b,c,d,e,f,g;
       a=r1.getString("fid");
       b=r1.getString("filename");
       c=r1.getString("subject");
       d=r1.getString("related_dept");
       e=r1.getString("file_date");
       f=r1.getString("pages");
       g=r1.getString("file_desc");
    %>
      <h2><%=b %></h2>
         
      <p><%=a%></p>
      <p><%=c%></p>
      <p><%=d%></p>
      <p><%=e%></p>
      <p><%=f%></p>
      <p><%=g%></p>
      
      <table>
          
              <tr>
                  
                  <td>
                        <form action="Edit.jsp" method="post">
                        <input type="hidden" name="H1" value="<%=e%>">
                       <input type="submit" name="B1" id="Btn2" value="Edit">
                       </form>
                  </td>
                     
                  <td>
                    <form action="Delete.jsp" method="post">   
                    <input type="hidden" name="H1" value="<%=e%>">
                    <input type="submit" name="B1" value="Delete">
                     </form>
                  </td>
             
              </tr>  
         
      </table>
      <%
   }
 
%>

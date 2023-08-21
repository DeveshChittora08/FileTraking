
<%@page import="java.sql.*"%>
<%@page import="FileTrack.MyLib"%>
<h1>Manage Admins</h1>
<h3><a href="AdminHome.jsp">Back</a></h3>
<%
   Connection cn=new MyLib().getConnection();
   String sql="select * from Adminlogin ";
   PreparedStatement p1=cn.prepareStatement(sql);
   ResultSet r1=p1.executeQuery();
   while(r1.next())
   {
       String a,b,c,d,e;
       a=r1.getString("name");
       b=r1.getString("dept_name");
       c=r1.getString("address");
       d=r1.getString("contact");
       e=r1.getString("email");
    %>
      <h2><%=b %></h2>
         
      <p><%=a%></p>
      <p><%=c%></p>
      <p><%=d%></p>
      <p><%=e%></p>
      
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

<%@page import="java.sql.*"%>
<%@page import="FileTrack.MyLib"%>
<%
    String email=request.getParameter("H1");
    if(email==null)
    {
        %>
        <h3><a href="ManageAdmins.jsp">Select Admins</a></h3>
        <%
    }
    else
    {
    Connection cn=new MyLib().getConnection();
    String sql="select * from adminlogin where email=?";
    PreparedStatement p1=cn.prepareStatement(sql);
    p1.setString(1, email);
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
         <form action="Edit_1.jsp" method="post">
        
          <table>   
        <tr>
            <td>Name:</td>
            <td><input type="text" name="T1" id="txt1" value="<%=a%>"></td>
        </tr>
         <tr>
            <td>Department_Name:</td>
            <td><input type="text" name="T2" id="txt2" value="<%=b%>"></td>
        </tr>
         <tr>
            <td>Address:</td>
            <td><input type="text" name="T3" id="txt3" value="<%=c%>"></td>
        </tr>
         <tr>
            <td>Contact:</td>
            <td><input type="text" name="T4" id="txt4" value="<%=d%>"></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="T4" id="txt4" value="<%=e%>"></td>
        </tr>
        
        
        <tr>
            <td></td>
            <td><input type="submit" value="Edit" name="B1"></td>
        
        </tr>
          </table>
         </form>
        <%
     }
     
    }
%>

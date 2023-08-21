
<%@page import="FileTrack.MyLib"%>
<%@page import="java.sql.*"%>
<% 
   String email=request.getParameter("H1");
   
   Connection cn=new MyLib().getConnection();
   String s1="Delete from adminlogin where email=?";
   String s2="Delete from logindata where email=?";
   PreparedStatement p1=cn.prepareStatement(s1);
   PreparedStatement p2=cn.prepareStatement(s2);
    p1.setString(1,email);
    p2.setString(1,email);
    
   int a=p1.executeUpdate();
   int b=p2.executeUpdate();
   
   String msg="";
   if(a==1 && b==1)
   {
       msg="Data Delete Secessfully";
   }
   else
   {
       msg="Error: Data Not Deleted";
   }
%>
<h2><%=msg%></h2>
<h3> <a href="ManageAdmins.jsp">Continue</a></h3>
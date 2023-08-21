
<%@page import="FileTrack.MyLib"%>
<%@page import="java.sql.*"%>
<% 
    String name,dept_name,address,contact,email;
    name=request.getParameter("T1");
    dept_name=request.getParameter("T2");
    address=request.getParameter("T3");
    contact=request.getParameter("T4");
    email=request.getParameter("H1");
   
   Connection cn=new MyLib().getConnection();
   String s1="update adminlogin set name=?,dept_name=?,address=?,contact=? where email=?";

   PreparedStatement p1=cn.prepareStatement(s1);
   
    p1.setString(1,name);
    p1.setString(2,dept_name);
    p1.setString(3,address);
    p1.setString(4,contact);
    p1.setString(5,email);
    
   
    
   int a=p1.executeUpdate();
   
   
   String msg="";
   if(a==1)
   {
       msg="Data chabges Secessfully";
   }
   else
   {
       msg="Error: Data Not Changes";
   }
%>
<h2><%=msg%></h2>
<h3> <a href="ManageAdmins.jsp">Continue</a></h3>
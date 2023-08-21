
<%@page import="FileTrack.MyLib"%>
<%@page import="java.sql.*"%>
<%
   MyLib obj=new MyLib();
   Connection cn=obj.getConnection();
   String emai,pass;
   emai=request.getParameter("T1");
   pass=request.getParameter("T2");
   String sql="Select * from logindata where email=? and password=?";
   PreparedStatement p1=cn.prepareStatement(sql);
   p1.setString(1,emai);
   p1.setString(2,pass);
   ResultSet r1=p1.executeQuery();
   if(r1.next())
   {
       String ut=r1.getString("usertype");
       
       session=request.getSession(true);
       
       session.setAttribute("email", emai);
       session.setAttribute("usertype", ut);
       
       if(ut.equalsIgnoreCase("Admin"))
       {
           response.sendRedirect("Admin/AdminHome.jsp");
       }
       else if(ut.equalsIgnoreCase("Department"))
        {
            response.sendRedirect("Department/FileHome.jsp");    
        }
        else
        {
            out.println("Contact to admin");
        }
    }
    else
    {
        response.sendRedirect("loginError.jsp");
    }
%>
        
   
   
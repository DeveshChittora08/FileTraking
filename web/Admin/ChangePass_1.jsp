 <%@page import="java.sql.*"%>
<%@page import="FileTrack.MyLib"%>
<h1>change Password</h1>
<%
    //check existance of session
    String ut="",e1="";
    session=request.getSession(false);
    if(session==null)
    {
        response.sendRedirect("../AuthorizationError.jsp");
    }
    else
    {
        try
        {
            ut=session.getAttribute("usertype").toString();
            e1=session.getAttribute("email").toString();
            if(ut.equalsIgnoreCase("admin")==false)
            {
                response.sendRedirect("../AuthorizationError.jsp");
            }
        }
        catch(NullPointerException e)
        {
            response.sendRedirect("../AuthorizationError.jsp");
        }
    }
%>

 <%
     
    String op,np,confirm_p;
    op=request.getParameter("T1");
    np=request.getParameter("T2");
    confirm_p=request.getParameter("T3");
  
    Connection cn=new MyLib().getConnection();
    String sql="update logindata set password=? where email=? and password=?";
    PreparedStatement P1=cn.prepareStatement(sql);
    
    P1.setString(1,np);
    P1.setString(2,e1);
    P1.setString(3,op);
   
    int a=P1.executeUpdate();
    
    String msg="";
    if(a==1)
    {
        msg="Password changed successfully";
    }
    else
    {
        msg="Invalid old password";
    }
 %>
 <h2><%= msg %></h2>
 <h3><a href="AdminHome.jsp">Back To Home</a></h3>

<%@page import="FileTrack.MyLib"%>
<%@page import="java.sql.*"%>
<h1>Welcome to Admin Block</h1>
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
 
    Connection cn=new MyLib().getConnection();
    String sql="select * from adminlogin where email=?";
   PreparedStatement p1=cn.prepareStatement(sql);
   p1.setString(1, e1);
   ResultSet r1=p1.executeQuery();
   if(r1.next())
   {
       String a,b,c,d,e;
       a=r1.getString("name");
       b=r1.getString("dept_name");
       c=r1.getString("address");
       d=r1.getString("contact");
       e=r1.getString("email");
       
       %>
       <h3><%=b%></h3>
       <p>
           Name: <%=a%><br>
           Address:<%=c%><br>
           Contact:<%=d%><br>
           Email:<%=e%>
       </p>
       <p>
       <a href="EditProfile.jsp"><button>Edit</button></a>
       <a href="ChangePass.jsp"><button>Change Pasword</button></a>
       </p>
       <%
   }
   else
   {
       %>
       <h2>No Profile Found</h2>
       <%
   }
    
%>
<h3><a href="../login.jsp">login</h3>


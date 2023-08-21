package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import FileTrack.MyLib;
import java.sql.*;

public final class AdminHome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<h1>Welcome to Admin Block</h1>\r\n");

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

      out.write("\r\n");
      out.write("\r\n");
 
 
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
       
       
      out.write("\r\n");
      out.write("       <h3>");
      out.print(b);
      out.write("</h3>\r\n");
      out.write("       <p>\r\n");
      out.write("           Name: ");
      out.print(a);
      out.write("<br>\r\n");
      out.write("           Address:");
      out.print(c);
      out.write("<br>\r\n");
      out.write("           Contact:");
      out.print(d);
      out.write("<br>\r\n");
      out.write("           Email:");
      out.print(e);
      out.write("\r\n");
      out.write("       </p>\r\n");
      out.write("       <p>\r\n");
      out.write("       <a href=\"EditProfile.jsp\"><button>Edit</button></a>\r\n");
      out.write("       <a href=\"ChangePass.jsp\"><button>Change Pasword</button></a>\r\n");
      out.write("       </p>\r\n");
      out.write("       ");

   }
   else
   {
       
      out.write("\r\n");
      out.write("       <h2>No Profile Found</h2>\r\n");
      out.write("       ");

   }
    

      out.write("\r\n");
      out.write("<h3><a href=\"../login.jsp\">login</h3>\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import FileTrack.MyLib;
import java.sql.*;

public final class EditProfile_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');

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

      out.write('\n');
      out.write('\n');
 
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
    p1.setString(5,e1);
    
   
    
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

      out.write("\n");
      out.write("<h2>");
      out.print(msg);
      out.write("</h2>\n");
      out.write("<h3> <a href=\"AdminHome.jsp\">Continue</a></h3>");
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

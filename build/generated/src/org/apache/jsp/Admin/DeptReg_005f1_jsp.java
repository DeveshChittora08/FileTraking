package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import FileTrack.MyLib;

public final class DeptReg_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
 
    String name,dept_name,address,contact,email,password,confirm;
    name=request.getParameter("T1");
    dept_name=request.getParameter("T2");
    address=request.getParameter("T3");
    contact=request.getParameter("T4");
    email=request.getParameter("T5");
    password=request.getParameter("T6");
    confirm=request.getParameter("T7");
    String usertype="Admin";
    String msg="";
    if(name==null||name.trim().equals(""))
    {
        msg="Enter Name";
    }
    else if(dept_name.trim().equals(""))
    {
        msg="Enter Deptartment Name";
    }
    else if(address.trim().equals(""))
    {
        msg="Enter Address";
    }
    else if(contact.trim().equals(""))
    {
        msg="Enter contact";
    }
    else if(email.trim().equals(""))
    {
        msg="Enter Email";
    }
    else if(password.trim().equals(""))
    {
        msg="Enter password";
    }
    else if(confirm.trim().equals(""))
    {
        msg="Enter Confirm Passsword";
    }
    else if(password.equals(confirm)==false)
    {
        msg="Confirm POassword Not Match";
    }
    else
    {
    
    Connection cn=new MyLib().getConnection();
    String s1="insert into adminlogin values(?,?,?,?,?)";
    String s2="insert into logindata values(?,?,?)";
    PreparedStatement p1=cn.prepareStatement(s1);
    PreparedStatement p2=cn.prepareStatement(s2);
     p1.setString(1, name);
     p1.setString(2, dept_name);
     p1.setString(3, address);
     p1.setString(4, contact);
     p1.setString(5, email);
     
     p2.setString(1, email);
     p2.setString(2, password);
     p2.setString(3, usertype);
     
     int a=p1.executeUpdate();
     int b=p2.executeUpdate();
    if(a==1 && b==1)
    {
        msg="Data is saved & Login is created ";
    }
    else if(a==1)
            {
                msg="Only Data Saved";
            }
    
    else if(b==1)
    {
        msg="Only login is created";
    }
    else
    {
        msg="No data is saved & No login is saved";
    }
  }
    
      out.write("\n");
      out.write("    \n");
      out.write("    <h2>");
      out.print(msg);
      out.write("</h2>\n");
      out.write("    <h3>\n");
      out.write("        <a href=\"DeptReg.jsp\">continue</a>\n");
      out.write("    </h3>    ");
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

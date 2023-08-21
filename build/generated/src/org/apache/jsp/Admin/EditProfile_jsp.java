package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import FileTrack.MyLib;

public final class EditProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
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
 
   Connection cn=new MyLib().getConnection();
    String sql="select * from adminlogin where email=?";
    PreparedStatement p1=cn.prepareStatement(sql);
    p1.setString(1, e1);
    ResultSet r1=p1.executeQuery();
     while(r1.next())
     {
         String a,b,c,d,e;
         a=r1.getString("name");
         b=r1.getString("dept_name");
         c=r1.getString("address");
         d=r1.getString("contact");
         e=r1.getString("email");
         
      out.write("\n");
      out.write("         <form action=\"EditProfile_1.jsp\" method=\"post\">\n");
      out.write("            \n");
      out.write("          <table>   \n");
      out.write("        <tr>\n");
      out.write("            <td>Name:</td>\n");
      out.write("            <td><input type=\"text\" name=\"T1\" id=\"txt1\" value=\"");
      out.print(a);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("         <tr>\n");
      out.write("            <td>Department_Name:</td>\n");
      out.write("            <td><input type=\"text\" name=\"T2\" id=\"txt2\" value=\"");
      out.print(b);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("         <tr>\n");
      out.write("            <td>Address:</td>\n");
      out.write("            <td><input type=\"text\" name=\"T3\" id=\"txt3\" value=\"");
      out.print(c);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("         <tr>\n");
      out.write("            <td>Contact:</td>\n");
      out.write("            <td><input type=\"text\" name=\"T4\" id=\"txt4\" value=\"");
      out.print(d);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("          <tr>\n");
      out.write("            <td>Email:</td>\n");
      out.write("            <td><input type=\"text\" name=\"T4\" id=\"txt4\" value=\"");
      out.print(e);
      out.write("\"></td>\n");
      out.write("        </tr>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <tr>\n");
      out.write("            <td></td>\n");
      out.write("            <td><input type=\"submit\" value=\"Edit\" name=\"B1\"></td>\n");
      out.write("        \n");
      out.write("        </tr>\n");
      out.write("          </table>\n");
      out.write("         </form>\n");
      out.write("        ");

     }

      out.write('\n');
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

package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import FileTrack.MyLib;

public final class ManageAdmins_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<h1>Manage Admins</h1>\n");
      out.write("<h3><a href=\"AdminHome.jsp\">Back</a></h3>\n");

   Connection cn=new MyLib().getConnection();
   String sql="select * from Adminlogin ";
   PreparedStatement p1=cn.prepareStatement(sql);
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
      out.write("      <h2>");
      out.print(b );
      out.write("</h2>\n");
      out.write("         \n");
      out.write("      <p>");
      out.print(a);
      out.write("</p>\n");
      out.write("      <p>");
      out.print(c);
      out.write("</p>\n");
      out.write("      <p>");
      out.print(d);
      out.write("</p>\n");
      out.write("      <p>");
      out.print(e);
      out.write("</p>\n");
      out.write("      \n");
      out.write("      <table>\n");
      out.write("          \n");
      out.write("              <tr>\n");
      out.write("                  \n");
      out.write("                  <td>\n");
      out.write("                        <form action=\"Edit.jsp\" method=\"post\">\n");
      out.write("                        <input type=\"hidden\" name=\"H1\" value=\"");
      out.print(e);
      out.write("\">\n");
      out.write("                       <input type=\"submit\" name=\"B1\" id=\"Btn2\" value=\"Edit\">\n");
      out.write("                       </form>\n");
      out.write("                  </td>\n");
      out.write("                     \n");
      out.write("                  <td>\n");
      out.write("                    <form action=\"Delete.jsp\" method=\"post\">   \n");
      out.write("                    <input type=\"hidden\" name=\"H1\" value=\"");
      out.print(e);
      out.write("\">\n");
      out.write("                    <input type=\"submit\" name=\"B1\" value=\"Delete\">\n");
      out.write("                     </form>\n");
      out.write("                  </td>\n");
      out.write("             \n");
      out.write("              </tr>  \n");
      out.write("         \n");
      out.write("      </table>\n");
      out.write("      ");

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

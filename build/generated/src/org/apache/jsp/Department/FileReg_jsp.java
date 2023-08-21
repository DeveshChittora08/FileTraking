package org.apache.jsp.Department;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class FileReg_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<h1>File Registration</h1>\n");
      out.write("<form action=\"FileReg_1.jsp\" method=\"post\">\n");
      out.write("    <table>\n");
      out.write("     \n");
      out.write("         <tr>\n");
      out.write("            <td>File Name:</td>\n");
      out.write("            <td><input type=\"text\" name=\"T1\" id=\"txt2\"></td>\n");
      out.write("        </tr>\n");
      out.write("         <tr>\n");
      out.write("            <td>Subject:</td>\n");
      out.write("            <td><input type=\"text\" name=\"T2\" id=\"txt3\"></td>\n");
      out.write("        </tr>\n");
      out.write("         <tr>\n");
      out.write("            <td>Department:</td>\n");
      out.write("            <td><input type=\"text\" name=\"T3\" id=\"txt4\"></td>\n");
      out.write("        </tr>\n");
      out.write("      \n");
      out.write("         <tr>\n");
      out.write("            <td>Pages:</td>\n");
      out.write("            <td><input type=\"text\" name=\"T4\" id=\"txt6\"></td>\n");
      out.write("        </tr>\n");
      out.write("         <tr>\n");
      out.write("            <td>Decription:</td>\n");
      out.write("            <td><textarea  name=\"T5\" id=\"txt7\"></textarea></td>\n");
      out.write("        </tr>\n");
      out.write("         <tr>\n");
      out.write("            <td></td>\n");
      out.write("            <td><input type=\"submit\" value=\"Submit\" name=\"B1\" id=\"btn1\"></td>\n");
      out.write("        </tr>\n");
      out.write("        \n");
      out.write("    </table>\n");
      out.write("</form>");
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

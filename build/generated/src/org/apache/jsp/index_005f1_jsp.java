package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import FileTrack.MyLib;
import java.sql.*;

public final class index_005f1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<h1>Welcome to File Tracker Systematic</h1>\n");

    String filename=request.getParameter("T1");

      out.write("\n");
      out.write("<form method=\"post\" action=\"Index.jsp\">\n");
      out.write("    File Name <input value=\"");
      out.print(filename);
      out.write("\" type=\"text\" name=\"T1\"/>\n");
      out.write("    <input type=\"submit\" name=\"B1\" value=\"Search\"/>    \n");
      out.write("</form>\n");
      out.write("    ");

        if(filename!=null)
        {
          MyLib obj=new MyLib();
          Connection cn=obj.getConnection();
          String sql="select *from filereg-department where filename LIKE '%"+filename+"%'";
          PreparedStatement p1=cn.prepareStatement(sql);
          
          ResultSet r1=p1.executeQuery();
          
          
      out.write("\n");
      out.write("          <table width=\"100%\">\n");
      out.write("              ");

                while(r1.next())
        {
            //fetch column of current row
            String mname,company,des,price,medical,owner,address,contact,landmark;
            mname=r1.getString("med_name");
            company=r1.getString("company");
            des=r1.getString("description");
            price=r1.getString("price");
            medical=r1.getString("name");
            owner=r1.getString("owner");
            address=r1.getString("address");
            contact=r1.getString("contact");
            landmark=r1.getString("landmark");
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>\n");
      out.write("                    <h3> Medicine Name:");
      out.print(mname);
      out.write("</h3>\n");
      out.write("                    <p>\n");
      out.write("\n");
      out.write("                        Company:");
      out.print( company );
      out.write(" </br>\n");
      out.write("                        Description:");
      out.print( des );
      out.write(" </br>\n");
      out.write("                        Unit Price:");
      out.print( price );
      out.write("</br>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </p>\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                    Medical Name : ");
      out.print( medical );
      out.write("<br/>\n");
      out.write("                    Contact Person : ");
      out.print( owner );
      out.write("<br/>\n");
      out.write("                    Address : ");
      out.print( address );
      out.write("<br/>\n");
      out.write("                    Contact : ");
      out.print( contact );
      out.write("<br/>\n");
      out.write("                    Landmark : ");
      out.print( landmark );
      out.write("\n");
      out.write("                </td>\n");
      out.write("            ");

            
        }
        
      out.write("\n");
      out.write("        </table>\n");
      out.write("        ");

    }

      out.write("\n");
      out.write("\n");
      out.write("              %>\n");
      out.write("          </table>\n");
      out.write("          \n");
      out.write("          \n");
      out.write("        }\n");
      out.write("    %>");
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
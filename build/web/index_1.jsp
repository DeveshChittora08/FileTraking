<%@page import="FileTrack.MyLib"%>
<%@page import="java.sql.*"%>

<h1>Welcome to File Tracker Systematic</h1>
<%
    String filename=request.getParameter("T1");
%>
<form method="post" action="Index.jsp">
    File Name <input value="<%=filename%>" type="text" name="T1"/>
    <input type="submit" name="B1" value="Search"/>    
</form>
    <%
        if(filename!=null)
        {
          MyLib obj=new MyLib();
          Connection cn=obj.getConnection();
          String sql="select *from filereg-department where filename LIKE '%"+filename+"%'";
          PreparedStatement p1=cn.prepareStatement(sql);
          
          ResultSet r1=p1.executeQuery();
          
          %>
          <table width="100%">
              <%
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
            %>
            <tr>
                <td>
                    <h3> Medicine Name:<%=mname%></h3>
                    <p>

                        Company:<%= company %> </br>
                        Description:<%= des %> </br>
                        Unit Price:<%= price %></br>


                    </p>
                </td>
                <td>
                    Medical Name : <%= medical %><br/>
                    Contact Person : <%= owner %><br/>
                    Address : <%= address %><br/>
                    Contact : <%= contact %><br/>
                    Landmark : <%= landmark %>
                </td>
            <%
            
        }
        %>
        </table>
        <%
    }
%>

              %>
          </table>
          
          
        }
    %>
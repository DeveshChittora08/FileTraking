<%@page import="java.sql.*"%>
<%@page import="FileTrack.MyLib"%>
<% 
    String filename,subject,dept,pages,desc;
    filename=request.getParameter("T1");
    subject=request.getParameter("T2");
    dept=request.getParameter("T3");
    pages=request.getParameter("T4");
    
    desc=request.getParameter("T5");
    
    String usertype="Department";
    String msg="";
    
    if(filename.trim().equals(""))
    {
        msg="Enter  fileName";
    }
    else if(subject.trim().equals(""))
    {
        msg="Enter Subject";
    }
    else if(dept.trim().equals(""))
    {
        msg="Enter Department";
    }
    
    else if(pages.trim().equals(""))
    {
        msg="Enter pages";
    }
    else if(desc.trim().equals(""))
    {
        msg="Enter desc";
    }
   
    else
    {
    
       Class.forName("com.mysql.jdbc.Driver");
       String dbpath= "jdbc:mysql://localhost:3306/filetracker";
       String dbuser="root";
       String dbpass="";
           
     Connection cn=DriverManager.getConnection(dbpath,dbuser,dbpass);
    String s1="insert into filedata values(0,?,?,?,?,?,?)";
  
    PreparedStatement p1=cn.prepareStatement(s1);
   

     p1.setString(1, filename);
     p1.setString(2, subject);
     p1.setString(3, dept);
     p1.setLong(4, System.currentTimeMillis());
     p1.setString(5, pages);
     p1.setString(6, desc);
     
     int a=p1.executeUpdate();
     
    if(a==1)
    {
        msg="Data is saved";
    }
  
    else
    {
        msg="No data is saved & No login is saved";
    }
  }
    %>
    
    <h2><%=msg%></h2>
    <h3>
        <a href="FileReg.jsp">continue</a>
    </h3>    
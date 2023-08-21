
<%@page import="java.sql.*"%>
<%@page import="FileTrack.MyLib"%>
<% 
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
    
       Class.forName("com.mysql.jdbc.Driver");
       String dbpath= "jdbc:mysql://localhost:3306/filetracker";
       String dbuser="root";
       String dbpass="";
           
     Connection cn=DriverManager.getConnection(dbpath,dbuser,dbpass);
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
    %>
    
    <h2><%=msg%></h2>
    <h3>
        <a href="AdminReg.jsp">continue</a>
    </h3>    
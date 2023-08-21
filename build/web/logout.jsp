
<%
    //check exixtance of session
    
    session=request.getSession(false);
    //false->use only existing session
    
    if(session==null)
    {
        response.sendRedirect("index_1.jsp");
    }
    else
    {
        try
        {
            //remove parametres of session
            session.removeAttribute("email");
            session.removeAttribute("usertype");
            
            //remove session
            session.invalidate();
            response.sendRedirect("index_1.jsp");
        }
        catch(NullPointerException e)
        {
            response.sendRedirect("index_1.jsp");
        }
    }
%>

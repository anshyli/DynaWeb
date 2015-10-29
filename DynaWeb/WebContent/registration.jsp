<%@ page import ="java.sql.*" %>
<%
    String user = request.getParameter("loginname");    
    String pwd = request.getParameter("password");
    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
    String email = request.getParameter("email");
    Class.forName("oracle.jdbc.driver.OracleDriver");
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:system/password@localhost",
            "testuserdb", "password");
    Statement st = con.createStatement();
    String sql = "insert into members(firstname, lastname, email, loginname, password, registrationdate) values ('" 
			+ fname + "','" + lname + "','" + email + "','" + user + "','" + pwd + "', to_char(sysdate,'mm-dd-yyyy'))";
	out.println("sql: " + sql);
    //ResultSet rs;
    int i = st.executeUpdate(sql);
    if (i > 0) {
        session.setAttribute("userid", user);
        response.sendRedirect("welcome.jsp");
       // out.print("Registration Successfull!"+"<a href='index.jsp'>Go to Login</a>");
    } else {
        response.sendRedirect("index.html");
    }
%>
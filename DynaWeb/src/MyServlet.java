import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MyServlet extends HttpServlet {
   
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException 
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(true);

        Integer counter2 = (Integer) getServletContext().getAttribute ("counter2");

        if (counter2 == null) {
            counter2 = new Integer(1);
        } else {
            counter2 = new Integer(counter2.intValue() + 1);
        }

        getServletContext().setAttribute("counter2", counter2);

        Integer counter = (Integer) session.getAttribute("counter");

        if (counter == null) {
            counter = new Integer(1);
        } else {
            counter = new Integer(counter.intValue() + 1);
        } 

        session.setAttribute("counter", counter);

        out.println("<HTML>");
        out.println("<HEAD>");
        out.println("<TITLE>");
        out.println("Using Contexts");
        out.println("</TITLE>");
        out.println("</HEAD>");
        out.println("<BODY>");
        out.println("<H1>Using Contexts</H1>");

        out.println("Welcome! You have been here " + counter + " times.<BR>");

        out.println("Total page accesses: " + counter2 + "<BR>");

        if(session.isNew()){
            out.println("This is a new session.<BR>");
        } else {
            out.println("This is not a new session.<BR>");
        }

        out.println("The session ID: " + session.getId() + "<BR>");
        out.println("Last time accessed: " + new Date(session.getLastAccessedTime()) + "<BR>"); 
        out.println("Creation time: " + new Date(session.getCreationTime()) + "<BR>");
        out.println("Timeout length: " + session.getMaxInactiveInterval() + " seconds<BR>");

        out.println("</BODY>");
        out.println("</HTML>");
    } 
}
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/StudentServlet")
public class Servlet12 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve form values
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String course = request.getParameter("course");
        String gender = request.getParameter("gender");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Display formatted details
        out.println("<html><body>");
        out.println("<h2>Student Registration Details</h2>");
        out.println("<table border='1' cellpadding='10'>");
        out.println("<tr><th>Name</th><td>" + name + "</td></tr>");
        out.println("<tr><th>Age</th><td>" + age + "</td></tr>");
        out.println("<tr><th>Course</th><td>" + course + "</td></tr>");
        out.println("<tr><th>Gender</th><td>" + gender + "</td></tr>");
        out.println("</table>");
        out.println("</body></html>");
    }
}
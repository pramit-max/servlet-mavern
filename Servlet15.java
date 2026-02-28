import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/EmployeeServlet")
public class Servlet15 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve form values
        String name = request.getParameter("name");
        String salary = request.getParameter("salary");
        String department = request.getParameter("department");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Display details in table format
        out.println("<html><body>");
        out.println("<h2>Employee Registration Details</h2>");
        out.println("<table border='1' cellpadding='10'>");
        out.println("<tr><th>Name</th><td>" + name + "</td></tr>");
        out.println("<tr><th>Salary</th><td>" + salary + "</td></tr>");
        out.println("<tr><th>Department</th><td>" + department + "</td></tr>");
        out.println("</table>");
        out.println("</body></html>");
    }
}
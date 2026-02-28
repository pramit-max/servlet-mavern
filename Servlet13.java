import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/MultiplyServlet")
public class Servlet13 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get numbers from form
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));

        // Perform multiplication
        int result = num1 * num2;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Display result
        out.println("<html><body>");
        out.println("<h2>Multiplication Result</h2>");
        out.println("<p>" + num1 + " × " + num2 + " = <b>" + result + "</b></p>");
        out.println("</body></html>");
    }
}
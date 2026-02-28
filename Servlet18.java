import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/RedirectServlet")   // ✅ must start with "/"
public class Servlet18 extends HttpServlet {   // ✅ class name matches mapping
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Simple validation (hardcoded for demo)
        if ("admin".equals(username) && "1234".equals(password)) {
            // ✅ Redirect to success.html
            response.sendRedirect("success.html");
        } else {
            response.setContentType("text/html");
            response.getWriter().println("<p style='color:red;'>Invalid username or password!</p>");
        }
    }
}
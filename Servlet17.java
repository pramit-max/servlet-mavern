import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ValidationServlet")
public class Servlet17 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        boolean hasError = false;

        if (username == null || username.trim().isEmpty()) {
            out.println("<p style='color:red;'>Username cannot be empty!</p>");
            hasError = true;
        }

        if (email == null || email.trim().isEmpty()) {
            out.println("<p style='color:red;'>Email cannot be empty!</p>");
            hasError = true;
        }

        if (!hasError) {
            out.println("<h2>Form Submitted Successfully!</h2>");
            out.println("<p><strong>Username:</strong> " + username + "</p>");
            out.println("<p><strong>Email:</strong> " + email + "</p>");
        }

        out.println("</body></html>");
    }
}
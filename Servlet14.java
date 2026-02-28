import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FeedbackServlet")
public class Servlet14 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve form values
        String name = request.getParameter("name");
        String comments = request.getParameter("comments");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Display feedback message
        out.println("<html><body>");
        out.println("<h2>Thank you for your feedback!</h2>");
        out.println("<p><strong>Name:</strong> " + name + "</p>");
        out.println("<p><strong>Comments:</strong> " + comments + "</p>");
        out.println("</body></html>");
    }
}
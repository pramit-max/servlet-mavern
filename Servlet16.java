import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/HobbyServlet")
public class Servlet16 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve multiple selected values
        String[] hobbies = request.getParameterValues("hobby");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Your Selected Hobbies:</h2>");

        if (hobbies != null) {
            out.println("<ul>");
            for (String h : hobbies) {
                out.println("<li>" + h + "</li>");
            }
            out.println("</ul>");
        } else {
            out.println("<p>No hobbies selected.</p>");
        }

        out.println("</body></html>");
    }
}
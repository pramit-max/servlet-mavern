import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RectangleServlet")
public class Servlet19 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get values from form
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));

        // Calculate area
        int area = length * width;

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Display result
        out.println("<html><body>");
        out.println("<h2>Rectangle Area Result</h2>");
        out.println("<p>Length: " + length + "</p>");
        out.println("<p>Width: " + width + "</p>");
        out.println("<p><b>Area = " + area + "</b></p>");
        out.println("</body></html>");
    }
}
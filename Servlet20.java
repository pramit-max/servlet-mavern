import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CommonServlet")
public class Servlet20 extends HttpServlet {

    // Common method for both GET and POST
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String lengthStr = request.getParameter("length");
        String widthStr = request.getParameter("width");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Rectangle Area Result</h2>");

        if (lengthStr != null && widthStr != null) {
            int length = Integer.parseInt(lengthStr);
            int width = Integer.parseInt(widthStr);
            int area = length * width;

            out.println("<p>Length: " + length + "</p>");
            out.println("<p>Width: " + width + "</p>");
            out.println("<p><b>Area = " + area + "</b></p>");
        } else {
            out.println("<p style='color:red;'>Please provide both length and width!</p>");
        }

        out.println("</body></html>");
    }

    // Handle GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    // Handle POST
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
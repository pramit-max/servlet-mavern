package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

// This maps the URL "submitStudent" to this specific Java class
@WebServlet("/student_details")
public class student_details extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieving parameters from the GET request
        String name = request.getParameter("name");
        String roll = request.getParameter("roll");
        String course = request.getParameter("course");

        out.println("<html><head><title>Student Result</title></head><body>");
        out.println("<h2>Submitted Student Details</h2>");

        // Simple table to display the data
        out.println("<table border='1' cellpadding='10' style='border-collapse: collapse;'>");
        out.println("<tr style='background-color: #f2f2f2;'><th>Field</th><th>Value</th></tr>");
        out.println("<tr><td><strong>Name</strong></td><td>" + (name != null ? name : "N/A") + "</td></tr>");
        out.println("<tr><td><strong>Roll No</strong></td><td>" + (roll != null ? roll : "N/A") + "</td></tr>");
        out.println("<tr><td><strong>Course</strong></td><td>" + (course != null ? course : "N/A") + "</td></tr>");
        out.println("</table>");

        out.println("<br><a href='index.html'>Back to Form</a>");
        out.println("</body></html>");
    }
}

package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/course")
public class Course extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Set the content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // 2. Retrieve the value from the dropdown
        // The string "selectedCourse" matches the 'name' attribute in the HTML <select>
        String course = request.getParameter("selectedCourse");

        // 3. Generate the response
        out.println("<html><body style='font-family: Arial, sans-serif; text-align: center;'>");

        if (course != null && !course.isEmpty()) {
            out.println("<h1 style='color: #2c3e50;'>Selection Successful!</h1>");
            out.println("<h3>You have selected the course: <span style='color: #e67e22;'>" + course + "</span></h3>");
            out.println("<p>Our academic counselor will contact you shortly with the syllabus.</p>");
        } else {
            out.println("<h3 style='color: red;'>No course was selected.</h3>");
        }

        out.println("<br><a href='course_selection.html'>Back to Selection</a>");
        out.println("</body></html>");
    }
}

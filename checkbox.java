package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/skillServlet")
public class SkillServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve multiple values as an array
        String[] selectedSkills = request.getParameterValues("skills");

        out.println("<html><body style='font-family: sans-serif;'>");
        out.println("<h2>Skills Profile</h2>");

        if (selectedSkills != null && selectedSkills.length > 0) {
            out.println("<p>You have selected the following <strong>" + selectedSkills.length + "</strong> skills:</p>");
            out.println("<ul>");

            // Iterate through the array to display each value
            for (String skill : selectedSkills) {
                out.println("<li>" + skill + "</li>");
            }

            out.println("</ul>");
        } else {
            out.println("<p style='color:red;'>No skills were selected. Please go back and try again.</p>");
        }

        out.println("<br><a href='index.html'>Back to Form</a>");
        out.println("</body></html>");
    }
}

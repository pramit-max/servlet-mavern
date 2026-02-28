package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// This annotation maps the servlet to the URL "/greater" matching your HTML form action
@WebServlet("/greater")
public class GreaterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int num1 = Integer.parseInt(request.getParameter("num1"));
            int num2 = Integer.parseInt(request.getParameter("num2"));

            int greater = (num1 > num2) ? num1 : num2;

            out.println("<html><body><center>");
            out.println("<h2>The greater number is: " + greater + "</h2>");
            out.println("<a href='index.html'>Go Back</a>"); // Added a back button for convenience
            out.println("</center></body></html>");

        } catch (NumberFormatException e) {
            out.println("<html><body><center>");
            out.println("<h2 style='color:red;'>Invalid input. Please enter valid numbers.</h2>");
            out.println("<a href='index.html'>Go Back</a>");
            out.println("</center></body></html>");
        }
    }
}

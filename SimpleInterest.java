package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Maps this servlet to match the HTML form's action
@WebServlet("/Simple_Interest")
public class SimpleInterest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Set response type to render as a web page
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Retrieve parameters and convert them to Double
            double principal = Double.parseDouble(request.getParameter("principal"));
            double rate = Double.parseDouble(request.getParameter("rate"));
            double time = Double.parseDouble(request.getParameter("time"));

            // Calculate Simple Interest and Total Amount
            double simpleInterest = (principal * rate * time) / 100;
            double totalAmount = principal + simpleInterest;

            // Generate HTML response
            out.println("<html><body>");
            out.println("<h2>Calculation Results</h2>");
            out.println("<ul>");
            out.println("<li><strong>Principal:</strong> Rs" + principal + "</li>");
            out.println("<li><strong>Rate:</strong> " + rate + "%</li>");
            out.println("<li><strong>Time:</strong> " + time + " years</li>");
            out.println("</ul>");
            out.println("<h3 style='color:green;'>Simple Interest: Rs" + simpleInterest + "</h3>");
            out.println("<h3>Total Amount to Pay: Rs" + totalAmount + "</h3>");
            out.println("<br><a href='index.html'>Calculate Again</a>");
            out.println("</body></html>");

        } catch (NumberFormatException e) {
            // Handle cases where the user messes with the URL parameters
            out.println("<html><body>");
            out.println("<h2 style='color:red;'>Invalid input. Please enter valid numerical values.</h2>");
            out.println("<a href='index.html'>Go Back</a>");
            out.println("</body></html>");
        }
    }
}

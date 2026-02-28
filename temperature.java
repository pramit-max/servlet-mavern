package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CelsiusToFahrenheit")
public class CelsiusToFahrenheit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String celsiusStr = request.getParameter("celsius");

            out.println("<html><body>");
            if (celsiusStr != null && !celsiusStr.isEmpty()) {
                try {
                    double celsius = Double.parseDouble(celsiusStr);
                    double fahrenheit = (celsius * 9.0 / 5.0) + 32;
                    out.println("<h2>Result:</h2>");
                    out.println("<p>" + celsius + " °C = " + fahrenheit + " °F</p>");
                } catch (NumberFormatException e) {
                    out.println("<p>Please enter a valid number.</p>");
                }
            } else {
                out.println("<p>No input provided.</p>");
            }
            out.println("</body></html>");
        }
    }
}

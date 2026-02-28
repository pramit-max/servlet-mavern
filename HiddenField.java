package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

// Renamed to follow Java naming conventions (PascalCase)
@WebServlet("/submitProfile")
public class hidden extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String userId = req.getParameter("userid");
        String name = req.getParameter("name");

        if (userId == null || name == null) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing form data.");
            return;
        }

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Success</title></head>");
        out.println("<body style='text-align:center; font-family:sans-serif;'>");
        out.println("<h2>Data Received Successfully</h2>");
        out.println("<p><strong>User ID (from hidden field):</strong> " + userId + "</p>");
        out.println("<p><strong>Name (from text input):</strong> " + name + "</p>");
        out.println("<br><a href='index.html'>Go Back</a>");
        out.println("</body></html>");
    }
}

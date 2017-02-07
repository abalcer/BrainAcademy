package com.brainacademy.gae.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Enumeration<String> headerNames = req.getHeaderNames();
        resp.setHeader("Content-type", "text/html");

        PrintWriter writer = resp.getWriter();
        writer.println("<html><head><title>Simple page</title></head><body>");

        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            writer.println(headerName + ": " + req.getHeader(headerName) + "<br>");
        }
        writer.println("----------------------------------------------------------");

        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            writer.println(parameterName + ": " + req.getParameter(parameterName) + "<br>");
        }

        writer.println("</body></html>");
    }
}

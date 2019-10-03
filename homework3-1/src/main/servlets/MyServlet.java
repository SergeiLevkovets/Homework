package main.servlets;

import main.Validation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

public class MyServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        Map<String, String[]> parameterMap = Validation.validationMap(request);
        for (String param : parameterMap.keySet()) {
            for (String value : parameterMap.get(param)) {
                writer.print(param + " = ");
                System.out.print(param + " = ");
                writer.println(value);
                System.out.println(value);
            }
        }
        writer.close();
    }
}

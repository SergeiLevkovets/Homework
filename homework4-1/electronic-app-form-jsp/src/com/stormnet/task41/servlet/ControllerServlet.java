package com.stormnet.task41.servlet;

import com.stormnet.task41.util.Validation;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;

@WebServlet("/controller.html")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");

        Validation validation = new Validation();
        validation.validation(request);

        if (validation.isInvalidate()) {
            request.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(request, response);
        }

        LinkedList<String> attributeNames = validation.getParamForValidationFull();
        request.setAttribute("attributeNamesList", attributeNames);

        request.getRequestDispatcher("WEB-INF/pages/result.jsp").forward(request, response);
    }
}

package com.stormnet.task41.servlet;

import com.stormnet.task41.util.Validation;
import com.stormnet.task41.util.ValidationImpl;

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

        Validation validation = new ValidationImpl();

        validation.validate(request.getParameterMap());

        if (validation.isInvalidate()) {
        Map<String, String> resultMap = validation.getResultMap();
        for (String paramName : resultMap.keySet()) {
            request.setAttribute(paramName, resultMap.get(paramName));
        }
            request.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(request, response);
        }

        LinkedList<String> attributeNames = validation.getParamForValidationFull();
        request.setAttribute("attributeNamesList", attributeNames);

        request.getRequestDispatcher("WEB-INF/pages/result.jsp").forward(request, response);
    }
}

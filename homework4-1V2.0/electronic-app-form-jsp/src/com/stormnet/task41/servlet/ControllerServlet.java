package com.stormnet.task41.servlet;

import com.stormnet.task41.util.Validation;
import com.stormnet.task41.util.ValidationImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/controller.html")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");

        Validation validation = new ValidationImpl();
        validation.validate(request.getParameterMap());

        if (validation.isValidate()) {
        request.getRequestDispatcher("WEB-INF/pages/result.jsp").forward(request, response);
        }

        Map<String, String> errorsMap = validation.getErrorsMap();
        for (String errorName : errorsMap.keySet()) {
            request.setAttribute(errorName, errorsMap.get(errorName));
        }
            request.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(request, response);
    }
}

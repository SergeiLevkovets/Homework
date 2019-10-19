package com.stormnet.task38.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/index.html")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        List<Integer> list = (List<Integer>) session.getAttribute("param");
        Integer count = (Integer) session.getAttribute("count");
        Integer price = (Integer) session.getAttribute("price");

        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html lang=\"en\">");
        writer.println("<head>");
        writer.println(" <meta charset=\"UTF-8\">");
        writer.println("<title>Electronic application form servlet</title>");
        writer.println("<link rel=\"stylesheet\" href=\"css/style.css\">");
        writer.println("<script type=\"text/javascript\" src=\"scripts/script.js\" defer></script>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<div class=\"form_div\">");
        writer.println("<form class=\"form\"  method=\"post\" action=\"/index.html\">");
        writer.println("<div>");
        writer.println("<input type=\"text\" name=\"param\" width=\"300px\">");
        writer.println("<input type=\"submit\" name=\"\">");
        writer.println("</div>");
        writer.println("</form>");
        writer.println("<div class=\"result\">");
        if (count != null) {
            writer.println("<p>Общее количество гистограм: " + count + "</p>");
        }
        if (price != null) {
            writer.println("<p>Всего нарисовано гистограмм на сумму: " + price + "</p>");
        }

        if (list != null) {
            for (Integer param : list) {
                writer.println("<div class=\"gis\" style=\" width: " + (param >= 620 ? 620 : param) + "px\" >" + param.toString() + "</div>");
            }
        }

        writer.println("</div>");
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();


        Integer price = (Integer) session.getAttribute("price");
        if (price == null) {
            price = 0;
        }

        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 0;
        }


        List<Integer> paramList = new ArrayList<>();
        String param = request.getParameter("param");
        if (param != "") {
            String[] paramArr = param.trim().split(" ");

            for (String elem : paramArr) {
                int value = Integer.parseInt(elem);
                paramList.add(value);

                price += value;
                count++;
            }
        }

        session.setAttribute("param", paramList);
        session.setAttribute("price", price);
        session.setAttribute("count", count);
        response.sendRedirect("/index.html");
    }
}



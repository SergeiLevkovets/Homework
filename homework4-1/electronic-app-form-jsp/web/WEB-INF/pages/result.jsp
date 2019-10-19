<%@ page import="java.util.LinkedList" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset=\"UTF-8\">
    <title>Result</title>
    <link rel=\"stylesheet\" href="../../css/style.css">
</head>
<body>
<table class=\"result_table\">
    <tbody>
    <tr>
        <th>Name</th>
        <th>Value</th>

<%
    for (String attributeName : (LinkedList<String>)request.getAttribute("attributeNamesList")) {
        if (attributeName.equals("other_course[]") || attributeName.equals("sources")) {
            for (String value : request.getParameterValues(attributeName)) {
                %><tr><td><%=attributeName%></td><td><%=value%></td></tr><%
            }
            continue;
        }
        %><tr><td><%=attributeName%></td><td><%=request.getParameter(attributeName)%></td></tr><%
    }
%>
    </tr>
    </tbody>
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Search Results</title>
</head>
<body>
    <h2>Search Results</h2>
    <ul>
        <%
            java.util.List<String> results = (java.util.List<String>) request.getAttribute("results");
            if (results != null && !results.isEmpty()) {
                for (String item : results) {
        %>
                    <li><%= item %></li>
        <%
                }
            } else {
        %>
                <li>No results found</li>
        <%
            }
        %>
    </ul>
    <a href="index.jsp">Back to Search</a>
</body>
</html>

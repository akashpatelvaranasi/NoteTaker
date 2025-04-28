package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // Sample data
    private static final List<String> items = new ArrayList<>();

    static {
        items.add("title");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       
    	String query = request.getParameter("query");
        List<String> results = new ArrayList<>();

        if (query != null && !query.trim().isEmpty()) {
            results = items.stream()
                           .filter(item -> item.toLowerCase().contains(query.toLowerCase()))
                           .collect(Collectors.toList());
        }

        request.setAttribute("results", results);
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }
}

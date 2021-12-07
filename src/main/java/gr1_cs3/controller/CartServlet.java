package gr1_cs3.controller;

import gr1_cs3.model.Invoice;
import gr1_cs3.service.InvoiceService;
import gr1_cs3.service.implement.InvoiceServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/Cart")
public class CartServlet extends HttpServlet {

    InvoiceService invoiceService = new InvoiceServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "augment":
                augment(request, response);
                break;
            case "reduce":
                reduce(request, response);
                break;
            case "addToCart":
                addToCart(request, response);
                break;
            default:
                try {
                    findAll(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/cart.jsp");
        String user = request.getParameter("username");
        int edit = Integer.parseInt(request.getParameter("edit"));
        int id = Integer.parseInt(request.getParameter("id"));
        int result = 0;
        invoiceService.editCart(id, user,edit);
        List<Invoice> products = invoiceService.findAll(user);
        for (Invoice in : products
        ) {
            result += (in.getProduct_quantity() * in.getPrice());
        }
        request.setAttribute("product", products);
        request.setAttribute("result", result);
        request.setAttribute("username", user);
        requestDispatcher.forward(request, response);
    }
    private void reduce(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/cart.jsp");
        String user = request.getParameter("username");
        int id = Integer.parseInt(request.getParameter("id"));
        int result = 0;
        invoiceService.reduceToCart(id, user);
        List<Invoice> products = invoiceService.findAll(user);
        for (Invoice in : products
        ) {
            result += (in.getProduct_quantity() * in.getPrice());
        }
        request.setAttribute("product", products);
        request.setAttribute("result", result);
        request.setAttribute("username", user);
        requestDispatcher.forward(request, response);
    }

    private void augment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/cart.jsp");
        String user = request.getParameter("username");
        int id = Integer.parseInt(request.getParameter("id"));
        int result = 0;
        invoiceService.augToCart(id, user);
        List<Invoice> products = invoiceService.findAll(user);
        for (Invoice in : products
        ) {
            result += (in.getProduct_quantity() * in.getPrice());
        }
        request.setAttribute("product", products);
        request.setAttribute("result", result);
        request.setAttribute("username", user);
        requestDispatcher.forward(request, response);
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/cart.jsp");
        String user = request.getParameter("username");
        int id = Integer.parseInt(request.getParameter("id"));
        int result = 0;
        invoiceService.augToCart(id, user);
        List<Invoice> products = invoiceService.findAll(user);
        for (Invoice in : products
        ) {
            result += (in.getProduct_quantity() * in.getPrice());
        }
        request.setAttribute("product", products);
        request.setAttribute("result", result);
        request.setAttribute("username", user);
        requestDispatcher.forward(request, response);
    }

    private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/cart.jsp");
        String user = request.getParameter("username");
        int result = 0;
        List<Invoice> products = invoiceService.findAll(user);
        for (Invoice in : products
        ) {
            result += (in.getProduct_quantity() * in.getPrice());
        }
        request.setAttribute("username", user);
        request.setAttribute("product", products);
        request.setAttribute("result", result);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "augment":
                augment(request, response);
                break;
            case "reduce":
                reduce(request, response);
                break;
            case "edit":
                edit(request, response);
                break;
            case "addToCart":
                addToCart(request, response);
                break;
            default:
                try {
                    findAll(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
}

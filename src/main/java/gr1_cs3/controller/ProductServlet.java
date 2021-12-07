package gr1_cs3.controller;

import gr1_cs3.model.Product;
import gr1_cs3.service.implement.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "ProductServlet", value = "/products")

public class ProductServlet extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "list-view":
                showAll(request, response);
                break;
            case "addToCart":
                try {
                    addToCart(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    showUserView(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    private void showAll(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
//        List<Product> products = new ArrayList<>();
//        products = productService.printAll();
//        request.setAttribute("products", products);
//        request.setAttribute("product", products.get(0));
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showUserView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
//        String name = request.getParameter("name");
//        if (name == null) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("member/userView.jsp");
        List<Product> newProducts = new ArrayList<>();
        List<Product> topThreeProducts = new ArrayList<>();
        newProducts = productService.printFourProduct();
        topThreeProducts = productService.getThreeProduct();
        request.setAttribute("newProducts", newProducts);
        request.setAttribute("topThreeProducts", topThreeProducts);
        requestDispatcher.forward(request, response);
    }
    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/cart.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Product products = productService.addToCart(id);
        request.setAttribute("product", products);

        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":

        }
    }
}

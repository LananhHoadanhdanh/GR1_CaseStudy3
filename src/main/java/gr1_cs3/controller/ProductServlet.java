package gr1_cs3.controller;

import gr1_cs3.model.Product;
import gr1_cs3.service.ProductService;
import gr1_cs3.service.implement.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
//            case "addToCart":
//                try {
//                    addToCart(request, response);
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//                break;
            default:
                try {
                    showList(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
//        String name = request.getParameter("name");
//        if (name == null) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/home.jsp");
        List<Product> products = new ArrayList<>();
        products = productService.printAll();
        request.setAttribute("products", products);
        request.setAttribute("product", products.get(0));
        requestDispatcher.forward(request, response);
//        }
//        else {
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
//            List<Product> listProduct = new ArrayList<>();
//            listProduct = productService.findByName(name);
//            request.setAttribute("listProduct", listProduct);
//            requestDispatcher.forward(request, response);
//        }
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

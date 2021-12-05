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
            case "l":
                try {
                    ashowList(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
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
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/demo.jsp");
            List<Product> products = productService.printAll();
            request.setAttribute("products", products);
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
    private void ashowList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
//        String name = request.getParameter("name");
//        if (name == null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("a.jsp");
            List<Product> products = productService.printAll();
            request.setAttribute("products", products);
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

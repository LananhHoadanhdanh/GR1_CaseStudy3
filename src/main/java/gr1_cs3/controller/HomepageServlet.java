//package gr1_cs3.controller;
//
//import gr1_cs3.model.Product;
//import gr1_cs3.service.ProductService;
//import gr1_cs3.service.implement.ProductServiceImpl;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebServlet(name = "HomepageServlet", value = "")
//public class HomepageServlet extends HttpServlet {
//    ProductService productService = new ProductServiceImpl();
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/home.jsp");
//        List<Product> products = null;
//        try {
//            products = productService.printAll();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        request.setAttribute("products", products);
//        request.setAttribute("product", products.get(0));
//        requestDispatcher.forward(request, response);
//    }
//
//    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/home.jsp");
//        List<Product> products = productService.printAll();
//        request.setAttribute("products", products);
//        request.setAttribute("product", products.get(0));
//        requestDispatcher.forward(request, response);
//    }
//
//    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
//        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/cart.jsp");
//        int id = Integer.parseInt(request.getParameter("id"));
//        Product products = productService.addToCart(id);
//        request.setAttribute("product", products);
//        requestDispatcher.forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//}

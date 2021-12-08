package gr1_cs3.controller;

import gr1_cs3.model.Product;
import gr1_cs3.service.MemberService;
import gr1_cs3.service.ProductService;
import gr1_cs3.service.implement.MemberServiceImpl;
import gr1_cs3.service.implement.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    MemberService memberService = new MemberServiceImpl();
    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showLoginPage(request, response);
    }

    private void showLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("member/login.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            checkLogin(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void checkLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (memberService.checkAdmin(username, password)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("member/adminView.jsp");
            List<Product> products = productService.findAll();
            request.setAttribute("products", products);
            dispatcher.forward(request, response);
        } else if (memberService.checkLogin(username, password)) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("member/userView.jsp");
            request.setAttribute("username", username);
            List<Product> newProducts = productService.printFourProduct();
            List<Product> topThreeProducts = productService.getThreeProduct();
            request.setAttribute("newProducts", newProducts);
            request.setAttribute("topThreeProducts", topThreeProducts);
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect("/login");
        }
    }
}

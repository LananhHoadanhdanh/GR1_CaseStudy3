package gr1_cs3.controller;

import gr1_cs3.model.Brand;
import gr1_cs3.model.Category;
import gr1_cs3.model.Member;
import gr1_cs3.model.Product;
import gr1_cs3.service.BrandService;
import gr1_cs3.service.CategoryService;
import gr1_cs3.service.MemberService;
import gr1_cs3.service.ProductService;
import gr1_cs3.service.implement.BrandServiceImpl;
import gr1_cs3.service.implement.CategoryServiceImpl;
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
    CategoryService categoryService = new CategoryServiceImpl();
    BrandService brandService = new BrandServiceImpl();

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
        Member member = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        member = memberService.getMemberByUsername(username);
        if (member == null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("member/login.jsp");
            requestDispatcher.forward(request, response);
        } else {
            if (memberService.checkLogin(username, password)) {
                HttpSession session = request.getSession();
                session.setAttribute("acc", member);
                String txtSearch = request.getParameter("Search");
                if (txtSearch == null) {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/home.jsp");
                    List<Product> newProducts = productService.printFourProduct();
                    List<Product> products = productService.findAll();
                    List<Product> upComingProducts = productService.getUpcomingProduct();
                    List<Category> categories = categoryService.findAll();
                    List<Brand> brands = brandService.findAll();
                    request.setAttribute("newProducts", newProducts);
                    request.setAttribute("products", products);
                    request.setAttribute("upComingProducts", upComingProducts);
                    request.setAttribute("listCategory", categories);
                    request.setAttribute("listBrand", brands);
                    requestDispatcher.forward(request, response);
                } else {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/home.jsp");
                    List<Product> products = productService.findByName(txtSearch);
                    request.setAttribute("products", products);
                    requestDispatcher.forward(request, response);
                }
            } else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("member/login.jsp");
                requestDispatcher.forward(request, response);
            }
        }
    }
}

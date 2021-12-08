package gr1_cs3.controller;

import gr1_cs3.model.Brand;
import gr1_cs3.model.Category;
import gr1_cs3.model.Product;
import gr1_cs3.service.BrandService;
import gr1_cs3.service.CategoryService;
import gr1_cs3.service.ProductService;
import gr1_cs3.service.implement.BrandServiceImpl;
import gr1_cs3.service.implement.CategoryServiceImpl;
import gr1_cs3.service.implement.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "LogoutServlet", value = "/logout")
public class LogoutServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("acc");
        String txtSearch = request.getParameter("Search");
        if (txtSearch == null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/home.jsp");
            List<Product> newProducts = null;
            try {
                newProducts = productService.printFourProduct();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
            List<Product> products = null;
            try {
                products = productService.findByName(txtSearch);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("products", products);
            requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package gr1_cs3.controller;

import gr1_cs3.model.Brand;
import gr1_cs3.model.Category;
import gr1_cs3.model.Product;
import gr1_cs3.service.BrandService;
import gr1_cs3.service.CategoryService;
import gr1_cs3.service.implement.BrandServiceImpl;
import gr1_cs3.service.implement.CategoryServiceImpl;
import gr1_cs3.service.implement.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListViewServlet", value = "/list-view")
public class ListViewServlet extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "list-view":
                break;
            case "huong-dan-mua-hang":
                showShoppingGuide(request, response);
                break;
            case "gioi-thieu":
                showAboutUs(request, response);
                break;
            default:
                try {
                    showList(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    private void showAboutUs(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("general/shoppingGuide.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showShoppingGuide(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("general/shoppingGuide.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
        List<Product> products = null;
        List<Category> categories = new ArrayList<>();
        List<Brand> brands = new ArrayList<>();
        products = productService.findAll();
        categories = categoryService.findAll();
        brands = brandService.findAll();
        request.setAttribute("products", products);
        request.setAttribute("listCategory", categories);
        request.setAttribute("listBrand", brands);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

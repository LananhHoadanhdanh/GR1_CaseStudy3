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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HomepageServlet", value = "")
public class HomepageServlet extends HttpServlet {
    public static ProductService productService = new ProductServiceImpl();
    public static CategoryService categoryService = new CategoryServiceImpl();
    public static BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "huong-dan-mua-hang":
                showShoppingGuide(request, response);
                break;
            case "gioi-thieu":
                showAboutUs(request, response);
                break;
            case "show-product-by-category":
                showProductByCID(request, response);
                break;
            case "show-product-by-brand":
                showProductByBID(request, response);
                break;
            default:
                try {
                    showHomePage(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    private void showProductByCID(HttpServletRequest request, HttpServletResponse response) {
        int categoryId = Integer.parseInt(request.getParameter("cid"));
        List<Product> upComingProducts = productService.getUpcomingProduct();
        List<Product> products = categoryService.getProductByCID(categoryId);
        List<Category> categories = categoryService.findAll();
        List<Brand>  brands = brandService.findAll();
        request.setAttribute("products", products);
        request.setAttribute("upComingProducts", upComingProducts);
        request.setAttribute("listCategory", categories);
        request.setAttribute("listBrand", brands);
        request.setAttribute("tag", categoryId);
        try {
            request.getRequestDispatcher("product/home.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showProductByBID(HttpServletRequest request, HttpServletResponse response) {
        int categoryId = Integer.parseInt(request.getParameter("bid"));
        List<Product> upComingProducts = productService.getUpcomingProduct();
        List<Product> products = brandService.getProductByBID(categoryId);
        List<Category> categories = categoryService.findAll();
        List<Brand>  brands = brandService.findAll();
        request.setAttribute("products", products);
        request.setAttribute("upComingProducts", upComingProducts);
        request.setAttribute("listCategory", categories);
        request.setAttribute("listBrand", brands);
        request.setAttribute("tag", categoryId);
        try {
            request.getRequestDispatcher("product/home.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showAboutUs(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("general/shoppingGuide.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showShoppingGuide(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("general/shoppingGuide.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void showHomePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String txtSearch = request.getParameter("Search");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/home.jsp");
        List<Product> newProducts = productService.printFourProduct();
        List<Product> upComingProducts = productService.getUpcomingProduct();
        List<Category> categories = categoryService.findAll();
        List<Brand> brands = brandService.findAll();
        request.setAttribute("newProducts", newProducts);
        request.setAttribute("upComingProducts", upComingProducts);
        request.setAttribute("listCategory", categories);
        request.setAttribute("listBrand", brands);
        List<Product> products = new ArrayList<>();
        if (txtSearch == null) {
            products = productService.findAll();
        } else {
            products = productService.findByName(txtSearch);
        }
        request.setAttribute("products", products);
        requestDispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}

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

@WebServlet(name = "CategoryServlet", urlPatterns = "/category")
public class CategoryServlet extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();
    BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("/action");
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
            case "product-detail":
                showProductDetail(request, response);
                break;
        }
        int categoryId = Integer.parseInt(request.getParameter("cid"));
        List<Product> newProducts = null;
        try {
            newProducts = productService.printFourProduct();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Product> upComingProducts = productService.getUpcomingProduct();
        List<Product> products = categoryService.getProductByCID(categoryId);
        List<Category> categories = categoryService.findAll();
        List<Brand>  brands = brandService.findAll();
        request.setAttribute("newProducts", newProducts);
        request.setAttribute("products", products);
        request.setAttribute("upComingProducts", upComingProducts);
        request.setAttribute("listCategory", categories);
        request.setAttribute("listBrand", brands);
        request.setAttribute("tag", categoryId);
        request.getRequestDispatcher("product/home.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void showProductDetail(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/productDetail.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Product productDetail = productService.findProductById(id);
        request.setAttribute("productDetail", productDetail);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
}

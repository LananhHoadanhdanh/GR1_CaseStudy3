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
@WebServlet(name = "ProductServlet", value = "/products")

public class ProductServlet extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();
    BrandService brandService = new BrandServiceImpl();
    CategoryService categoryService = new CategoryServiceImpl();

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
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                try {
                    showEditForm(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                try {
                    deleteProduct(request, response);
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

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("member/adminView.jsp");
        List<Product> products = productService.findAll();
        request.setAttribute("products", products);
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findProductById(id);
        List<Brand> brands = brandService.findAll();
        List<Category> categories = categoryService.findAll();
        request.setAttribute("brands", brands);
        request.setAttribute("categories", categories);
        request.setAttribute("product", product);
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        List<Brand> brands = brandService.findAll();
        List<Category> categories = categoryService.findAll();
        request.setAttribute("brands", brands);
        request.setAttribute("categories", categories);
        dispatcher.forward(request, response);
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
                break;
            case "create":
                try {
                    createProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    editProduct(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String image = request.getParameter("image");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        int brandId = Integer.parseInt(request.getParameter("brandId"));
        Product product = new Product(id, name, price, quantity, categoryId, image, brandId, description);
        productService.edit(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("member/adminView.jsp");
        List<Product> products = productService.findAll();
        request.setAttribute("products", products);
        dispatcher.forward(request, response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        int brandId = Integer.parseInt(request.getParameter("brandId"));
        String image = "productImg/logo.png";
        Product product = new Product(name, price, quantity, categoryId, image, brandId, description);
        productService.add(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("member/adminView.jsp");
        List<Product> products = productService.findAll();
        request.setAttribute("products", products);
        dispatcher.forward(request, response);
    }
}

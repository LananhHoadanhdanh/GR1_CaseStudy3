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
            case "view":
                showProductDetail(request, response);
                break;
            case "addBrand":
                showAddBrandForm(request, response);
                break;
            case "addCategory":
                showAddCategoryForm(request, response);
                break;
            default:
                try {
                    HomepageServlet.showHomePage(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    private void showAddCategoryForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/addCategory.jsp");
        List<Category> categories = categoryService.findAll();
        List<Brand>  brands = brandService.findAll();
        request.setAttribute("listCategory", categories);
        request.setAttribute("listBrand", brands);
        requestDispatcher.forward(request, response);
    }

    private void showAddBrandForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/addBrand.jsp");
        List<Category> categories = categoryService.findAll();
        List<Brand>  brands = brandService.findAll();
        request.setAttribute("listCategory", categories);
        request.setAttribute("listBrand", brands);
        requestDispatcher.forward(request, response);
    }

    private void showProductDetail(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/productDetail.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Product productDetail = productService.findProductById(id);
        request.setAttribute("productDetail", productDetail);
        List<Category> categories = categoryService.findAll();
        List<Brand> brands = brandService.findAll();
        request.setAttribute("listCategory", categories);
        request.setAttribute("listBrand", brands);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.delete(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/successfullyDelete.jsp");
        List<Category> categories = categoryService.findAll();
        List<Brand> brands = brandService.findAll();
        request.setAttribute("listCategory", categories);
        request.setAttribute("listBrand", brands);
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findProductById(id);
        List<Category> categories = categoryService.findAll();
        List<Brand> brands = brandService.findAll();
        request.setAttribute("listCategory", categories);
        request.setAttribute("listBrand", brands);
        request.setAttribute("product", product);
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        List<Category> categories = categoryService.findAll();
        List<Brand> brands = brandService.findAll();
        request.setAttribute("listCategory", categories);
        request.setAttribute("listBrand", brands);
        dispatcher.forward(request, response);
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
            case "addBrand":
                try {
                    addBrand(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "addCategory":
                try {
                    addCategory(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void addCategory(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        Category category = new Category(name);
        categoryService.add(category);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/successfullyCreate.jsp");
        List<Category> categories = categoryService.findAll();
        List<Brand>  brands = brandService.findAll();
        request.setAttribute("listCategory", categories);
        request.setAttribute("listBrand", brands);
        dispatcher.forward(request, response);
    }

    private void addBrand(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        Brand brand = new Brand(name);
        brandService.add(brand);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/successfullyCreate.jsp");
        List<Category> categories = categoryService.findAll();
        List<Brand>  brands = brandService.findAll();
        request.setAttribute("listCategory", categories);
        request.setAttribute("listBrand", brands);
        dispatcher.forward(request, response);
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/successfullyEdit.jsp");
        List<Category> categories = categoryService.findAll();
        List<Brand>  brands = brandService.findAll();
        request.setAttribute("listCategory", categories);
        request.setAttribute("listBrand", brands);
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/successfullyCreate.jsp");
        List<Category> categories = categoryService.findAll();
        List<Brand>  brands = brandService.findAll();
        request.setAttribute("listCategory", categories);
        request.setAttribute("listBrand", brands);
        dispatcher.forward(request, response);
    }
}

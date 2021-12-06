package gr1_cs3.controller;

import gr1_cs3.model.Product;
import gr1_cs3.service.InvoiceService;
import gr1_cs3.service.ProductService;
import gr1_cs3.service.implement.InvoiceServiceImpl;
import gr1_cs3.service.implement.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CartServlet", value = "/Cart")
public class CartServlet extends HttpServlet {
    InvoiceService invoiceService = new InvoiceServiceImpl();
    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {

            default:
                try {
                    addToCart(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
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

    }
}

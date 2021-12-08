package gr1_cs3.service;

import gr1_cs3.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService extends GeneralService<Product> {
    List<Product> findAll();
    List<Product> printFourProduct() throws SQLException;
    List<Product> printAllOrderByPrice() throws SQLException;
    List<Product> findByName(String name) throws SQLException;
    List<Product> findByCategory(String category) throws SQLException;
    List<Product> findByBrand(String brand) throws SQLException;
    Product addToCart(int id);
    Product findProductById(int id);
    List<Product> getUpcomingProduct();
}

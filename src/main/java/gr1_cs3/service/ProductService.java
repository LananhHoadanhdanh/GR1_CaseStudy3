package gr1_cs3.service;

import gr1_cs3.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService extends GeneralService<Product> {
    List<Product> printFourProduct() throws SQLException;
    List<Product> printAllOrderByPrice() throws SQLException;
    List<Product> findByName(String name) throws SQLException;
    Product addToCart(int id);
    List<Product> getThreeProduct();
    List<Product> findAll();
}

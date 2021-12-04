package gr1_cs3.service.implement;

import gr1_cs3.model.Product;
import gr1_cs3.service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Override
    public List<Product> printAll() throws SQLException {
        return null;
    }

    @Override
    public List<Product> printAllOrderByPrice() throws SQLException {
        return null;
    }

    @Override
    public List<Product> findByName(String name) throws SQLException {
        return null;
    }

    @Override
    public void add(Product product) throws SQLException {

    }

    @Override
    public void edit(Product product) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public int findById(int id) throws SQLException {
        return 0;
    }
}

package gr1_cs3.service.implement;

import gr1_cs3.model.Product;
import gr1_cs3.service.ProductService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs3_g1?allowPublicKeyRetrieval=true&useSSL=false", "root", "123456");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
    @Override
    public List<Product> printAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("select *from product");) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("categoryId");
                String image = rs.getString("image");
                int brandId = rs.getInt("brandId");
                String description = rs.getString("description");
                products.add(new Product(id, name, price, quantity,  categoryId,  image,  brandId,  description ));
            }
        } catch (SQLException ignored) {
        }
        return products;
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

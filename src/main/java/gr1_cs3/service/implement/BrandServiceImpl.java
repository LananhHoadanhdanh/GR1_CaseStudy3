package gr1_cs3.service.implement;

import gr1_cs3.model.Brand;
import gr1_cs3.model.Category;
import gr1_cs3.model.Product;
import gr1_cs3.service.BrandService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BrandServiceImpl implements BrandService {
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
    public List<Brand> findAll() {
        List<Brand> brands = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from brand");) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                brands.add(new Brand(id, name));
            }
        } catch (SQLException ignored) {
        }
        return brands;
    }

    @Override
    public void add(Brand brand) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into brand (name) value (?)");) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, brand.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException ignored) {
        }
    }

    @Override
    public void edit(Brand brand) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public int findById(int id) throws SQLException {
        return 0;
    }

    @Override
    public List<Product> getProductByBID(int bId) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select *from product where product.brandId = ?");) {
            preparedStatement.setInt(1, bId);
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
                products.add(new Product(id, name, price, quantity, categoryId, image, brandId, description));
            }
        } catch (SQLException ignored) {
        }
        return products;
    }
}

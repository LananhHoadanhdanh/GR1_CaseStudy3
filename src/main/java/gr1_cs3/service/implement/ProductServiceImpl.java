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

    public int viewPay(int price, int quantity){
        return price*quantity;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product");) {
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
    public List<Product> printFourProduct() throws SQLException {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product limit 4");) {
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

    public List<Product> getThreeProduct(){
        List<Product> topThreeProduct = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product ORDER BY RAND() limit 3");) {
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
                topThreeProduct.add(new Product(id, name, price, quantity,  categoryId,  image,  brandId,  description ));
            }
        } catch (SQLException ignored) {
        }
        return topThreeProduct;
    }

    @Override
    public Product findProductById(int id) {
        Product product = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id = ?");) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("categoryId");
                String image = rs.getString("image");
                int brandId = rs.getInt("brandId");
                String description = rs.getString("description");
                product = new Product(id, name, price, quantity,  categoryId,  image,  brandId,  description );
            }
        } catch (SQLException e) {
        }
        return product;
    }

    @Override
    public List<Product> printAllOrderByPrice() throws SQLException {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product order by price");) {
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
    public List<Product> findByName(String key) throws SQLException {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product where name like ?");) {
            preparedStatement.setString(1, "%" + key + "%");
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
    public List<Product> findByCategory(String category) throws SQLException {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product where category like ?");) {
            preparedStatement.setString(1, category);
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
    public List<Product> findByBrand(String brand) throws SQLException {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from product where brand like ?");) {
            preparedStatement.setString(1, brand);
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
    public Product addToCart(int id) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("select * from product");) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int idData = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("categoryId");
                String image = rs.getString("image");
                int brandId = rs.getInt("brandId");
                String description = rs.getString("description");
                products.add(new Product(idData, name, price, quantity,  categoryId,  image,  brandId,  description ));
            }
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId() == id) {
                    return products.get(i);
                }
            }
        } catch (SQLException e) {
        }
        return null;
    }

    @Override
    public void add(Product product) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into product(name, price, quantity, categoryId, image, brandId, description) value (?, ?, ?, ?, ?, ?, ?)");) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setInt(4, product.getCategoryId());
            preparedStatement.setString(5, product.getImage());
            preparedStatement.setInt(6, product.getBrandId());
            preparedStatement.setString(7, product.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException ignored) {
        }
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

package gr1_cs3.service.implement;

import gr1_cs3.model.Invoice;
import gr1_cs3.model.Product;
import gr1_cs3.service.InvoiceService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InvoiceServiceImpl implements InvoiceService<Invoice> {
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
    public void add(Invoice invoice) throws SQLException {

    }

    @Override
    public void edit(Invoice invoice) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public int findById(int id) throws SQLException {
        return 0;
    }

    @Override
    public List<Invoice> invoice() {
       return null;
    }

    @Override
    public List<Invoice> addToCart() {
        List<Invoice> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * \n" +
                     "from product\n" +
                     "         inner join orderdetail on orderdetail.productId = product.id\n" +
                     "         inner join `order` on orderdetail.orderId = `order`.id");) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("categoryId");
                String image = rs.getString("image");
                int brandId = rs.getInt("brandId");
                int productquantity = rs.getInt("product_quantity");
                String description = rs.getString("description");
                products.add(new Invoice(id, name, price, quantity,  categoryId,  image,  brandId,  description ,productquantity));
            }
        } catch (SQLException ignored) {
        }
        return products;
    }
}

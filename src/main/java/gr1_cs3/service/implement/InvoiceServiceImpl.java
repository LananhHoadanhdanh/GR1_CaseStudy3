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

    public List<Invoice> findAll(String username) {
        List<Invoice> products = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select *\n" +
                     "from product\n" +
                     " inner join orderdetail on orderdetail.productId = product.id\n" +
                     " inner join `order` on orderdetail.orderId = `order`.id\n" +
                     "inner join member on `member`.id=memberId\n" +
                     "where member.username=?;");) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                int productId = rs.getInt("productId");
                int orderId = rs.getInt("orderId");
                int quantity = rs.getInt("quantity");
                int categoryId = rs.getInt("categoryId");
                String image = rs.getString("image");
                int brandId = rs.getInt("brandId");
                int productquantity = rs.getInt("product_quantity");
                int status = rs.getInt("status");
                String description = rs.getString("description");
                if (status == 0) {
                    products.add(new Invoice(id, name, price, quantity, categoryId, image, brandId, description, productquantity, productId, orderId));
                }
            }
        } catch (SQLException ignored) {
        }
        return products;
    }

    @Override
    public int getIdUser(String username) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select id from member where member.username=?")) {
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            int id = rs.getInt("id");
            return id;
        } catch (SQLException ignored) {
        }
        return 0;
    }

    @Override
    public int getIdOrder(String username) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select id from `order` where memberid=?")) {
            preparedStatement.setInt(1, getIdUser(username));
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            int id = rs.getInt("id");
            return id;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getStatus(String username) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select status from `order` where memberid=?")) {
            preparedStatement.setInt(1, getIdUser(username));
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();
            int status = rs.getInt("status");
            return status;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
    @Override
    public String getPassByUser(String username) {
        String password = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select password from member where (username = ? or email = ?)");) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, username);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                password = rs.getString("password");
            }
        } catch (SQLException ignored) {
        }
        return password;
    }
    @Override
    public void augmentToCart(int idProduct, String userName) {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `cs3_g1`.`orderdetail` SET `product_quantity` =(`product_quantity`+ 1) WHERE (`orderId` = ?) and (`productId` = ?);")) {
                preparedStatement.setInt(1, getIdOrder(userName));
                preparedStatement.setInt(2, idProduct);
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
    }

    @Override
    public void reduceToCart(int idProduct, String userName) {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `cs3_g1`.`orderdetail` SET `product_quantity` =(`product_quantity`- 1) WHERE (`orderId` = ?) and (`productId` = ?);")) {
                preparedStatement.setInt(1, getIdOrder(userName));
                preparedStatement.setInt(2, idProduct);
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
        }
    }

    @Override
    public void editCart(int idProduct, String userName, int quantity) {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement("UPDATE `cs3_g1`.`orderdetail` SET `product_quantity` =? WHERE (`orderId` = ?) and (`productId` = ?);")) {
                preparedStatement.setInt(1, quantity);
                preparedStatement.setInt(2, getIdOrder(userName));
                preparedStatement.setInt(3, idProduct);
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
    }

    @Override
    public void addToCart(int idProduct, String userName) {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `cs3_g1`.`orderdetail` (`orderId`, `productId`, `product_quantity`) VALUES (?,?,?) ;")) {
                preparedStatement.setInt(1, getIdOrder(userName));
                preparedStatement.setInt(2, idProduct);
                preparedStatement.setInt(3, 1);
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
    }

    public void addToCa(String userName) {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(
                         "INSERT INTO `cs3_g1`.`order` (memberId) VALUES (?) ;")) {
                preparedStatement.setInt(1, getIdUser(userName));
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    @Override
    public void deleteProInCart(String userName,int id) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "    DELETE FROM `cs3_g1`.`orderdetail` WHERE (`orderId` = ?) and (`productId` = ?);")) {
            preparedStatement.setInt(1, getIdOrder(userName));
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public void deleteCart(String userName) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "    DELETE FROM `cs3_g1`.`orderdetail` WHERE `orderId` = ?;")) {
            preparedStatement.setInt(1, getIdOrder(userName));
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Invoice> findAll() {
        return null;
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


}

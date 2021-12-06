package gr1_cs3.service.implement;

import gr1_cs3.model.Invoice;
import gr1_cs3.model.Order;
import gr1_cs3.model.Product;
import gr1_cs3.service.OrderService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService<Order> {
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
    public void add(OrderService<Order> orderOrderService) throws SQLException {

    }

    @Override
    public void edit(OrderService<Order> orderOrderService) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public int findById(int id) throws SQLException {
        return 0;
    }

    @Override
    public Invoice viewPay() {
      return null;}
}

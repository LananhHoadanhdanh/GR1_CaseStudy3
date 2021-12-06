package gr1_cs3.service.implement;

import gr1_cs3.model.Invoice;
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
        List<Invoice> invoiceList = new ArrayList<>();
        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement("?=call getPay");) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int idMember = rs.getInt("memberid");
                int price = rs.getInt("price");
                int quantity = rs.getInt("product_quantity");
                int status = rs.getInt("status");
                invoiceList.add(new Invoice(idMember, status, quantity, price));

            }
        } catch (SQLException ignored) {
        }
        return invoiceList;

    }
}

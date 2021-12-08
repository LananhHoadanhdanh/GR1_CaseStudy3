package gr1_cs3.service.implement;

import gr1_cs3.model.Member;
import gr1_cs3.service.MemberService;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class MemberServiceImpl implements MemberService {

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
    public List<Member> findAll() {
        return null;
    }

    @Override
    public void add(Member member) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("insert into member(username, password, name, phone, email, address, roleId) value (?, ?, ?, ?, ?, ?, ?)");) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1, member.getUsername());
            preparedStatement.setString(2, member.getPassword());
            preparedStatement.setString(3, member.getName());
            preparedStatement.setString(4, member.getPhone());
            preparedStatement.setString(5, member.getEmail());
            preparedStatement.setString(6, member.getAddress());
            preparedStatement.setInt(7, member.getRoleId());
            preparedStatement.executeUpdate();
        } catch (SQLException ignored) {
        }
    }

    @Override
    public void edit(Member member) throws SQLException {

    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public int findById(int id) throws SQLException {
        return 0;
    }


    @Override
    public boolean checkAdmin(String username, String password) {
        return false;
    }

    @Override
    public boolean checkLogin(String username, String password) {
        boolean check = false;
        String pass = getPassByUser(username);
        if (pass.equals(password)) {
            check = true;
        }
        return check;
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
    public Member getMemberByUsername(String username) {
        Member member = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("select * from member where (username = ? or email = ?)");) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, username);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String user_name = rs.getString("username");
                String password = rs.getString("password");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                int roleId = rs.getInt("roleId");
                member = new Member(id, user_name, password, name, phone, email, address, roleId);
            }
        } catch (SQLException ignored) {
        }
        return member;
    }
}

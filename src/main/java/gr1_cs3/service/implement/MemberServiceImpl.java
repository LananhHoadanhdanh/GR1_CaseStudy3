package gr1_cs3.service.implement;

import gr1_cs3.model.Member;
import gr1_cs3.service.MemberService;

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
    public void add(Member member) throws SQLException {

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
        return (username.equals("admin") || username.equals("admin@gmail.com")) && password.equals("admin");
    }

    @Override
    public boolean checkLogin(String username, String password) {
        return false;
    }
}

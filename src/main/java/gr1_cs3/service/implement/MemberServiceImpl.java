package gr1_cs3.service.implement;

import gr1_cs3.model.Member;
import gr1_cs3.service.MemberService;

import java.sql.SQLException;
import java.util.List;

public class MemberServiceImpl implements MemberService {

    @Override
    public List<Member> printAll() throws SQLException {
        return null;
    }

    @Override
    public List<Member> printAllOrderByPrice() throws SQLException {
        return null;
    }

    @Override
    public List<Member> findByName(String name) throws SQLException {
        return null;
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
}

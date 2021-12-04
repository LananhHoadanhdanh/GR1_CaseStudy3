package gr1_cs3.service;

import java.sql.SQLException;
import java.util.List;

public interface GeneralService<T> {
   public List<T> printAll() throws SQLException;
    public List<T> printAllOrderByPrice() throws SQLException;
    public List<T> findByName(String name) throws SQLException;
    public void add(T t) throws SQLException;
    public void edit(T t) throws SQLException;
    public void delete(int id) throws SQLException;
    public int findById(int id) throws SQLException;
}

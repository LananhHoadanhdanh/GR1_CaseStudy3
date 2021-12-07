package gr1_cs3.service;

import java.sql.SQLException;
import java.util.List;

public interface GeneralService<T> {
    List<T> findAll();
    void add(T t) throws SQLException;
    void edit(T t) throws SQLException;
    void delete(int id) throws SQLException;
    int findById(int id) throws SQLException;
}

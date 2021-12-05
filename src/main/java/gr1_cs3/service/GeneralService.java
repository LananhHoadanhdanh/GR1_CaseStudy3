package gr1_cs3.service;

import java.sql.SQLException;
import java.util.List;

public interface GeneralService<T> {
    public void add(T t) throws SQLException;
    public void edit(T t) throws SQLException;
    public void delete(int id) throws SQLException;
    public int findById(int id) throws SQLException;
}

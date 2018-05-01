package db.dao;

import model.Job;

import java.sql.SQLException;
import java.util.List;

public interface JobDAO {

    List<Job> all() throws SQLException;
    void clear() throws SQLException;
    void insert(Object o) throws SQLException;
    Job find(int id) throws SQLException;
    void delete(Object o) throws SQLException;
}

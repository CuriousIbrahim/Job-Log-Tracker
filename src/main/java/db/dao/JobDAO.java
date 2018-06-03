package db.dao;

import model.Job;

import java.sql.SQLException;
import java.util.List;

/**
 * A Job Data Access Object, specially for the 'job' table
 */

public interface JobDAO {

    List<Job> all() throws SQLException;
    void clear() throws SQLException;
    void insert(Object o) throws SQLException;
    Job find(int id) throws SQLException;
    void delete(int id) throws SQLException;
    void update(int id, Job updatedJob) throws SQLException;
}

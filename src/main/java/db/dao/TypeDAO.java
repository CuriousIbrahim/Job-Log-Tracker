package db.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * A Type Data Access Object, specially for the 'type' table
 */


public interface TypeDAO {

    List<String> all() throws SQLException;
    void clear() throws SQLException;
    void insert(Object o) throws SQLException;
    void delete(Object o) throws SQLException;

}

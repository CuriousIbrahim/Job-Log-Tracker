package db.dao;

import java.sql.SQLException;
import java.util.List;

public interface StatusDAO {

    List<String> all() throws SQLException;
    void clear() throws SQLException;
    void insert(Object o) throws SQLException;
    void delete(Object o) throws SQLException;

}

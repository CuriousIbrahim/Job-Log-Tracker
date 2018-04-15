package db.dao.base;

import java.sql.SQLException;
import java.util.List;

public interface BaseDAO {

    public List<?> all() throws SQLException;
    public void clear() throws SQLException;
    public void insert(Object o) throws SQLException;
    public void delete(Object o) throws SQLException;

}

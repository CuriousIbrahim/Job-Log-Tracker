package db;

import db.core.Database;
import db.dao.TypeDAO;

import java.sql.SQLException;
import java.util.List;

public class JobTypeDatabase extends Database implements TypeDAO {

    public JobTypeDatabase() throws SQLException {

    }

    @Override
    public List<String> all() throws SQLException {
        return null;
    }

    @Override
    public void clear() throws SQLException {

    }

    @Override
    public void insert(Object o) throws SQLException {

    }

    @Override
    public void delete(Object o) throws SQLException {

    }
}

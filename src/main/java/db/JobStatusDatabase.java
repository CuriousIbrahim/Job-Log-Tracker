package db;

import db.core.Database;
import db.dao.base.BaseDAO;

import java.sql.SQLException;
import java.util.List;

public class JobStatusDatabase extends Database implements BaseDAO {

    public JobStatusDatabase() throws SQLException {


    }

    @Override
    public List<?> all() throws SQLException {
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
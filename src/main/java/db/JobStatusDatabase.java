package db;

import db.core.Database;
import db.dao.base.BaseDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobStatusDatabase extends Database implements BaseDAO {

    private static final String ALL ="SELECT * FROM status";

    public JobStatusDatabase() throws SQLException { }

    @Override
    public List<String> all() throws SQLException {
        ResultSet rs = runQuery(ALL);

        List<String> toReturn = new ArrayList<>();

        while (rs.next()) {
            toReturn.add(rs.getString("status"));
        }

        return toReturn;

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

package db;

import db.core.Database;
import db.dao.TypeDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobTypeDatabase extends Database implements TypeDAO {

    private static final String[] DEFAULT_VALUES = {
            "Part Time",
            "Full Time",
            "Contract",
            "Temporary"
    };

    private static final String ALL = "SELECT * FROM type";

    public JobTypeDatabase() throws SQLException {

    }

    @Override
    public List<String> all() throws SQLException {
        List<String> jobTypes = new ArrayList<>();

        ResultSet resultSet = runQuery(ALL);

        while (resultSet.next())
            jobTypes.add(resultSet.getString(1));

        return jobTypes;
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

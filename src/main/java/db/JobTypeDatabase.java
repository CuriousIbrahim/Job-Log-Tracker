package db;

import db.core.Database;
import db.dao.TypeDAO;

import java.sql.PreparedStatement;
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

    private static final String INSERT = "INSERT INTO type (type) VALUES (?)";

    private static final String DELETE_ALL = "DELETE FROM type";

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

        if (runQuery(ALL).next())
            return;

        runSql(DELETE_ALL);

        for (String d : DEFAULT_VALUES)
            insert(d);

    }

    @Override
    public void insert(Object o) throws SQLException {

        String toInsert;

        if (o instanceof String)
            toInsert = (String) o;
        else
            return;

        PreparedStatement statement = conn.prepareStatement(INSERT);

        statement.setString(1, toInsert);

        statement.executeUpdate();


    }

    @Override
    public void delete(Object o) throws SQLException {

    }
}

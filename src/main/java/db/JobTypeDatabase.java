package db;

import db.core.Database;
import db.dao.TypeDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * JobTypeDatabase is the class that allows communication with the 'type' table. Implements all methods from TypeDAO
 */

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

    /**
     * Returns every entry from 'type' table
     * @return A list of String objects representing every job type
     * @throws SQLException
     */

    @Override
    public List<String> all() throws SQLException {
        List<String> jobTypes = new ArrayList<>();

        ResultSet resultSet = runQuery(ALL);

        while (resultSet.next())
            jobTypes.add(resultSet.getString(1));

        return jobTypes;
    }

    /**
     * Deletes every value in 'type' table and fills it with DEFAULT_VALUES
     * @throws SQLException
     */

    @Override
    public void clear() throws SQLException {

        if (runQuery(ALL).next())
            return;

        runSql(DELETE_ALL);

        for (String d : DEFAULT_VALUES)
            insert(d);

    }

    /**
     * Inserts a job type to 'type' table
     * @param o String object representing job type
     * @throws SQLException
     */

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

    /**
     * Deletes a job type from 'type' table
     * @param o String object representing the job type to delete
     * @throws SQLException
     */

    @Override
    public void delete(Object o) throws SQLException {

    }
}

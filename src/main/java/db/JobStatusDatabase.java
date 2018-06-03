package db;

import db.core.Database;
import db.dao.StatusDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * JobStatusDatabase is the class that allows communication with the 'status' table. Implements all methods from StatusDAO
 */

public class JobStatusDatabase extends Database implements StatusDAO {

    private static final String[] DEFAULT_VALUES = {
            "Waiting",
            "Interview",
            "Offer",
            "Declined"
    };

    private static final String ALL = "SELECT * FROM status";

    private static final String INSERT = "INSERT INTO status(status) VALUES (?)";

    private static final String DELETE_ALL = "DELETE FROM status";

    public JobStatusDatabase() throws SQLException { }

    /**
     * Returns every entry from 'status' table
     * @return A list of String objects representing every status
     * @throws SQLException
     */

    @Override
    public List<String> all() throws SQLException {
        ResultSet rs = runQuery(ALL);

        List<String> toReturn = new ArrayList<>();

        while (rs.next()) {
            toReturn.add(rs.getString("status"));
        }

        return toReturn;

    }

    /**
     * Deletes every value in 'status' table and fills it with DEFAULT_VALUES
     * @throws SQLException
     */

    @Override
    public void clear() throws SQLException {

        if (!runQuery(ALL).next()) {
            runSql(DELETE_ALL);

            for (String sql : DEFAULT_VALUES)
                insert(sql);

        }

    }

    /**
     * Inserts a status to 'status' table
     * @param o String object representing status
     * @throws SQLException
     */

    @Override
    public void insert(Object o) throws SQLException {

        String status;

        if (o instanceof String)
            status = (String) o;
        else
            return;


        PreparedStatement statement = conn.prepareStatement(INSERT);

        statement.setString(1, status);

        statement.executeUpdate();

    }

    /**
     * Deletes a status from 'status' table
     * @param o String object representing the status to delete
     * @throws SQLException
     */

    @Override
    public void delete(Object o) throws SQLException {

    }
}

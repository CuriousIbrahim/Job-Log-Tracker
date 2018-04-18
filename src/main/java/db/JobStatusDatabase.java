package db;

import db.core.Database;
import db.dao.base.BaseDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobStatusDatabase extends Database implements BaseDAO {

    private static final String[] DEFAULT_VALUES = {
            "Waiting",
            "Interview",
            "Offer",
            "Declined"
    };

    private static final String ALL = "SELECT * FROM status";

    private static final String INSERT = "INSERT INTO status(status) VALUES (?)";

    private static final String DELETE_ALL = "DELETE * FRM status";

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

        runSql(DELETE_ALL);

        for (String sql : DEFAULT_VALUES)
            insert(sql);

    }

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

    @Override
    public void delete(Object o) throws SQLException {

    }
}

package db.core;

import java.sql.*;

/**
 * Represents the basics for a SQLITE database, this includes making the database, running sql commands and simple
 * queries
 */

public class CoreDatabase {

    private static final String SQLITE_URL = "jdbc:sqlite:";
    private static final String EXTENSION = ".db";

    /**
     * Is static a Connection to the database
     */

    public static Connection conn;

    /**
     * Creates an SQLITE database
     * @param dbName The name of the sqlite file <i>dbName</i>.db
     * @throws SQLException
     */

    public CoreDatabase(String dbName) throws SQLException  {

        this.conn = DriverManager.getConnection(
                SQLITE_URL + dbName + EXTENSION
        );

    }

    /**
     * Runs a query and returns the results
     * @param sql SQL query command
     * @return If an exception occurs, returns null, otherwise, returns the result from the query
     */

    public ResultSet runQuery(String sql){

        try {

            Statement stmt = conn.createStatement();

            return stmt.executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return null;
        }

    }

    /**
     * Run an SQL command, like creating a table
     * @param sql The SQL command
     * @return If an exception occurs, returns false, otherwise, returns true
     */

    public boolean runSql(String sql) {

        try {

            Statement stmt = conn.createStatement();
            stmt.execute(sql);

            return true;

        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return false;
        }
    }



}

package db.core;

import java.sql.*;

public class CoreDatabase {

    private static final String SQLITE_URL = "jdbc:sqlite:";
    private static final String EXTENSION = ".db";

    public static Connection conn;

    public CoreDatabase(String dbName) throws SQLException  {

        this.conn = DriverManager.getConnection(
                SQLITE_URL + dbName + EXTENSION
        );

    }

    public ResultSet runQuery(String sql){

        Statement stmt = null;

        try {

            stmt = conn.createStatement();

            return stmt.executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return null;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace(System.out);
                }
            }
        }

    }

    public boolean runSql(String sql) {

        Statement stmt = null;

        try {

            stmt = conn.createStatement();
            stmt.execute(sql);

            return true;

        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return false;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace(System.out);
                }
            }
        }
    }



}

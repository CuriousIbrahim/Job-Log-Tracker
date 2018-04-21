package db.core;

import java.sql.*;

public class CoreDatabase {

    private static final String SQLITE_URL = "jdbc:sqlite:";
    private static final String EXTENSION = ".db";

    public Connection conn;

    public CoreDatabase(String dbName) throws SQLException  {

        this.conn = DriverManager.getConnection(
                SQLITE_URL + dbName + EXTENSION
        );

    }

    public ResultSet runQuery(String sql){

        try {

            Statement stmt = conn.createStatement();

            return stmt.executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
            return null;
        }

    }

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

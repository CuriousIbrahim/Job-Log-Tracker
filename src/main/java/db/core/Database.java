package db.core;

import java.sql.SQLException;

public class Database extends CoreDatabase {

    private static final String DB_NAME = "jobs_database";

    public Database() throws SQLException {
        super(DB_NAME);
    }

}

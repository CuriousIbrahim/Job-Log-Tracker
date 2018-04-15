package db.core;

import java.sql.SQLException;

public class Database extends CoreDatabase {

    private static final String DB_NAME = "jobs_database";

    private static final String[] TABLES_SQL = {
            "CREATE TABLE IF NOT EXISTS type (type TEXT PRIMARY KEY);",
            "CREATE TABLE IF NOT EXISTS status (status TEXT PRIMARY KEY);",
            "CREATE TABLE IF NOT EXISTS job (id INTEGER PRIMARY KEY, title TEXT NOT NULL, type TEXT, " +
                    "company TEXT, description TEXT, timestamp_applied INTEGER NOT NULL, location TEXT, " +
                    "FOREIGN KEY (type) REFERENCES type(type));",
            "CREATE TABLE IF NOT EXISTS job_status (job_id INTEGER, timestamp INTEGER, status TEXT, " +
                    "FOREIGN KEY (status) REFERENCES status(status));",
            "CREATE TABLE IF NOT EXISTS resume (job_id INTEGER, resume BLOB, extension TEXT, " +
                    "FOREIGN KEY (job_id) REFERENCES job(id));",
            "CREATE TABLE IF NOT EXISTS cover_letter (job_id INTEGER, cover_letter BLOB, extension TEXT, " +
                    "FOREIGN KEY (job_id) REFERENCES job(id));",
            "CREATE TABLE IF NOT EXISTS other_file (id INTEGER PRIMARY KEY, job_id INTEGER, name TEXT, file BLOB, extension TEXT, " +
                    "FOREIGN KEY (job_id) REFERENCES job(id));"
    };


    public Database() throws SQLException {
        super(DB_NAME);
        createTables();
    }

    private void createTables() {
        for (String sql : TABLES_SQL)
            runSql(sql);
    }

}

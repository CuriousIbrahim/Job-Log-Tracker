package controller;

import db.JobStatusDatabase;
import db.dao.base.BaseDAO;
import view.InsertJobWindow;

import java.sql.SQLException;

public class StatusController {

    BaseDAO statusDB;

    public StatusController(InsertJobWindow window) throws SQLException {

        statusDB = new JobStatusDatabase();

    }
}

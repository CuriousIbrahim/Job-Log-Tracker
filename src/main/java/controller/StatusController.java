package controller;

import db.JobStatusDatabase;
import db.dao.StatusDAO;
import view.JobWindow;

import java.sql.SQLException;

public class StatusController {

    StatusDAO statusDB;

    public StatusController(JobWindow window) throws SQLException {

        statusDB = new JobStatusDatabase();

        // Reset database and set the options for ComboBoxes in view
        statusDB.clear();
        window.setStatusOptions(statusDB.all());

    }
}

package controller;

import db.dao.JobDAO;
import db.JobDatabase;

import view.AllJobViewer;

import java.sql.SQLException;

public class AllJobViewerController {

    private JobDAO jobDB;

    public AllJobViewerController(AllJobViewer view) throws SQLException {

        jobDB = new JobDatabase();

    }
}

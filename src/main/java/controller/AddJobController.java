package controller;

import db.JobDatabase;
import db.dao.base.BaseDAO;
import model.Job;
import model.JobStatus;
import util.Time;
import view.InsertJobWindow;
import view.attribute.special.JobStatusAttribute;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddJobController {

    private BaseDAO jobDB;

    public AddJobController(InsertJobWindow window) throws SQLException {

        jobDB = new JobDatabase();

        window.getSubmitBtn().setOnAction(event -> {

            Job job;

            String title = window.getJobTitle();
            String type = window.getType();
            String company = window.getCompany();
            String description = window.getDescription();
            long timestampApplied = Time.localDateToUnixTimestamp(window.getDate());
            String location = window.getLocation();

            List<JobStatus> jobStatuses = new ArrayList<>();
            for (JobStatusAttribute s : window.getJobStatuses().ge) {

            }

        });

    }

}

package controller;

import db.dao.JobDAO;
import db.JobDatabase;

import javafx.event.ActionEvent;
import model.Job;
import view.AllJobViewer;
import view.InsertJobWindow;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllJobViewerController {

    private JobDAO jobDB;

    public AllJobViewerController(AllJobViewer view) throws SQLException {

        jobDB = new JobDatabase();

        addJobsToView(view);

        view.getAddNewJobBtn().setOnAction(event -> {

            InsertJobWindow insertJobWindow = new InsertJobWindow();

            insertJobWindow.getSubmitBtn().addEventHandler(ActionEvent.ACTION, (e) -> {

                view.clearCards();
                try {
                    addJobsToView(view);
                } catch (SQLException e1) {
                    e1.printStackTrace(System.out);
                }

            });

            try {

                new AddJobController(insertJobWindow);
                new StatusController(insertJobWindow);
                new TypeController(insertJobWindow);

                insertJobWindow.show();


            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        });

    }

    private void addJobsToView(AllJobViewer view) throws SQLException{
        List<Integer> jobId = new ArrayList<>();
        List<String> jobTitle = new ArrayList<>();
        List<String> jobType = new ArrayList<>();
        List<String> company = new ArrayList<>();
        List<String> currentStatus = new ArrayList<>();

        for (Job j : jobDB.all()) {
            jobId.add(j.getId());
            jobTitle.add(j.getTitle());
            jobType.add(j.getType());
            company.add(j.getCompany());
            if (!j.getJobStatuses().isEmpty())
                currentStatus.add(j.getCurrentJobStatus().getStatus());
            else
                currentStatus.add("N/A");
        }

        for (int i = 0; i < jobId.size(); i++) {
            view.addJob(jobId.get(i), jobTitle.get(i), jobType.get(i), company.get(i), currentStatus.get(i));
        }
    }
}

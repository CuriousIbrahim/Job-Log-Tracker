package controller;

import db.dao.JobDAO;
import db.JobDatabase;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Job;
import util.Time;
import view.AllJobViewer;
import view.JobWindow;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllJobViewerController {

    private JobDAO jobDB;

    public AllJobViewerController(AllJobViewer view) throws SQLException {

        jobDB = new JobDatabase();

        addJobsToView(view);

        view.getAddNewJobBtn().setOnAction(event -> {

            JobWindow jobWindow = new JobWindow("Add");

            try {

                new AddJobController(jobWindow);
                new StatusController(jobWindow);
                new TypeController(jobWindow);

                jobWindow.show();

                jobWindow.getButton().addEventHandler(ActionEvent.ACTION, (e) -> {

                    view.clearCards();
                    try {
                        addJobsToView(view);
                    } catch (SQLException e1) {
                        e1.printStackTrace(System.out);
                    }

                });


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


            view.addJob(jobId.get(i), jobTitle.get(i), jobType.get(i), company.get(i), currentStatus.get(i),
                    new EditJobHandler(jobId.get(i)));
        }
    }

    class EditJobHandler implements EventHandler<MouseEvent> {

        private int jobId;

        public EditJobHandler(int jobId) {
            this.jobId = jobId;
        }


        @Override
        public void handle(MouseEvent event) {
            JobWindow window = new JobWindow("Edit");

            Job job = null;

            try {
                job = jobDB.find(this.jobId);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
                return;
            }


            try {
                new AddJobController(window);
                new StatusController(window);
                new TypeController(window);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

            window.setJobTitle(job.getTitle());
            window.setType(job.getType());
            window.setLocation(job.getLocation());
            window.setCompany(job.getCompany());
            window.setDate(Time.unixTimestampToLocalDate(job.getTimestampApplied()));
            // TODO: Set Resume
            // TODO: Set Cover Letter
            window.setDescription(job.getDescription());
            window.setJobStatuses(job.getJobStatusesString(), job.getJobStatusDates());
            // TODO: Set Other Files List

            window.show();

        }
    }
}

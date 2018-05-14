package controller;

import db.dao.JobDAO;
import db.JobDatabase;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Job;
import model.OtherFile;
import util.FileUtil;
import util.Time;
import view.AllJobViewer;
import view.JobWindow;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllJobViewerController {

    private JobDAO jobDB;
    private AllJobViewer view;

    public AllJobViewerController(AllJobViewer view) throws SQLException {

        this.view = view;
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
                    updateView();
                });


            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

        });

    }

    protected void updateView() {
        view.clearCards();
        try {
            addJobsToView(view);
        } catch (SQLException e1) {
            e1.printStackTrace(System.out);
        }
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
                new StatusController(window);
                new TypeController(window);
                new EditJobController(window, job);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

            window.getButton().addEventHandler(ActionEvent.ACTION, (e) -> {

                updateView();

            });

            window.setJobTitle(job.getTitle());
            window.setJobTitle(job.getTitle());
            window.setType(job.getType());
            window.setLocation(job.getLocation());
            window.setCompany(job.getCompany());
            window.setDate(Time.unixTimestampToLocalDate(job.getTimestampApplied()));

            try {
                if (job.getResume() != null)
                    window.setResume(makeResumeOrCoverLetter(job, 0));
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }

            try {
                if (job.getCoverLetter() != null)
                    window.setCoverLetter(makeResumeOrCoverLetter(job, 1));
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }

            window.setDescription(job.getDescription());
            window.setJobStatuses(job.getJobStatusesString(), job.getJobStatusDates());

            List<String> otherFileNames = new ArrayList<>();
            List<String> otherFilePaths = new ArrayList<>();
            for (OtherFile o : job.getOtherFiles()) {
                otherFileNames.add(o.getName());
                try {
                    otherFilePaths.add(FileUtil.addFile(o.getName(), o.getExtension(), o.getFile()));
                } catch (IOException e) {
                    e.printStackTrace(System.out);
                }
            }
            window.setOtherFilesList(otherFileNames, otherFilePaths);

            window.show();

        }
    }

    /*
    f:0 is Resume
    f;1 is Cover Letter
     */
    private String makeResumeOrCoverLetter(Job job, int f) throws IOException {

        if (f == 0 || f == 1) {
            String name = String.format("%s - %s - %s ", job.getTitle(), job.getType(), job.getCompany());

            if (f == 0) {
                name += "RESUME";

                String temp = FileUtil.addFile(name, job.getResume().getExtension(), job.getResume().getResume());

                return FileUtil.addFile(name, job.getResume().getExtension(), job.getResume().getResume());
            } else {
                name += "COVER LETTER";

                return FileUtil.addFile(name, job.getCoverLetter().getExtension(), job.getCoverLetter().getCoverLetter());
            }
        } else {
            return null;
        }
    }
}

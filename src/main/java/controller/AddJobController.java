package controller;

import db.JobDatabase;
import db.dao.JobDAO;
import model.*;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import util.Time;
import view.InsertJobWindow;
import view.attribute.special.JobStatusAttribute;
import view.attribute.special.OtherFileAttribute;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddJobController {

    private JobDAO jobDB;

    public AddJobController(InsertJobWindow window) throws SQLException {

        jobDB = new JobDatabase();

        window.getSubmitBtn().setOnAction(event -> {

            Job job;

            String title = window.getJobTitle();
            String type = window.getType();
            String company = window.getCompany();
            String description = window.getDescription();
            int timestampApplied = (int) Time.localDateToUnixTimestamp(window.getDate());
            String location = window.getLocation();

            Resume resume = null;
            if (window.getResume() != null) {
                try {
                    resume = new Resume(
                            IOUtils.toByteArray(new FileInputStream(window.getResume())),
                            FilenameUtils.getExtension(window.getResume())
                    );
                } catch (FileNotFoundException e) {
                    System.out.println(e);
                } catch (IOException e) {
                    System.out.println(e);
                }
            }

            CoverLetter coverLetter = null;
            try {
                coverLetter = new CoverLetter(
                        IOUtils.toByteArray(new FileInputStream(window.getCoverLetter())),
                        FilenameUtils.getExtension(window.getCoverLetter())
                );
            } catch (FileNotFoundException e) {
                System.out.println(e);
            } catch(IOException e) {
                System.out.println(e);
            }

            List<JobStatus> jobStatuses = new ArrayList<>();
            for (JobStatusAttribute s : window.getJobStatuses()) {
                jobStatuses.add(
                        new JobStatus(
                                (int) Time.localDateToUnixTimestamp(s.getDate()),
                                s.getStatus()
                        )
                );
            }

            List<OtherFile> otherFiles = new ArrayList<>();
            for (OtherFileAttribute o : window.getOtherFilesList()) {
                try {
                    otherFiles.add(new OtherFile(
                            o.getName(),
                            IOUtils.toByteArray(new FileInputStream(o.getFile())),
                            FilenameUtils.getExtension(o.getFile())
                    ));
                } catch (FileNotFoundException e) {
                    System.out.println(e);
                } catch (IOException e) {
                    System.out.println(e);
                }
            }

            job = new Job(title, type, company, description, timestampApplied, location, jobStatuses, resume,
                    coverLetter, otherFiles);

            try {
                jobDB.insert(job);
            } catch (SQLException e) {
                System.out.println(e);
            }




        });

    }

}

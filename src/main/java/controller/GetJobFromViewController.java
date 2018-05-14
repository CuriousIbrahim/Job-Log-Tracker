package controller;

import model.*;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import util.Time;
import view.JobWindow;
import view.attribute.special.JobStatusAttribute;
import view.attribute.special.OtherFileAttribute;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetJobFromViewController {

    public static Job getJobFromView(JobWindow window) {

        String title = window.getJobTitle();
        String type = window.getType();
        String company = window.getCompany();
        String description = window.getDescription();
        int timestampApplied = (int) Time.localDateToUnixTimestamp(window.getDate());
        String location = window.getLocation();

        Resume resume = null;
        if (window.getResume() != null && !window.getResume().equals("")) {
            try {
                resume = new Resume(
                        IOUtils.toByteArray(new FileInputStream(window.getResume())),
                        FilenameUtils.getExtension(window.getResume())
                );
            } catch (FileNotFoundException e) {
                e.printStackTrace(System.out);
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }

        CoverLetter coverLetter = null;
        if (window.getCoverLetter() != null && !window.getCoverLetter().equals("")) {
            try {
                coverLetter = new CoverLetter(
                        IOUtils.toByteArray(new FileInputStream(window.getCoverLetter())),
                        FilenameUtils.getExtension(window.getCoverLetter())
                );
            } catch (FileNotFoundException e) {
                e.printStackTrace(System.out);
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
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
                e.printStackTrace(System.out);
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        }

        return new Job(title, type, company, description, timestampApplied, location, jobStatuses, resume,
                coverLetter, otherFiles);
    }
}

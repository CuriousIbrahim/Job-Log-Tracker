package db;

import db.core.Database;
import db.dao.JobDAO;
import model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobDatabase extends Database implements JobDAO {

    // Selecting
    private static final String ALL_JOB = "SELECT * FROM job";
    private static final String ALL_JOB_STATUS = "SELECT * FROM job_status WHERE job_id=";
    private static final String GET_RESUME = "SELECT * FROM resume WHERE job_id=";
    private static final String GET_COVER_LETTER = "SELECT * FROM cover_letter WHERE job_id=";
    private static final String ALL_OTHER_FILES = "SELECT * FROM other_file WHERE job_id=";

    // Delete All
    private static final String[] DELETE_ALL = {
            "DELETE * FROM job",
            "DELETE * FROM job_status",
            "DELETE * FROM resume",
            "DELETE * FROM cover_letter",
            "DELETE * FROM other_file"
    };

    // Insert
    private static final String INSERT_JOB = "INSERT INTO job (title, type, company, description, timestamp_applied, " +
            "location) VALUES (? ,?, ?, ?, ?, ?)";
    private static final String INSERT_STATUS = "INSERT INTO job_status (job_id, timestamp, status) VALUES (?, ?, ?)";
    private static final String INSERT_RESUME = "INSERT INTO resume (job_id, resume, extension) VALUES (?, ?, ?)";
    private static final String INSERT_COVER_LETTER = "INSERT INTO cover_letter (job_id, cover_letter, extension) " +
            "VALUES (?, ?, ?)";
    private static final String INSERT_OTHER_FILE = "INSERT INTO other_file (job_id, name, file, extension) " +
            "VALUES (?, ?, ?, ?)";



    public JobDatabase () throws SQLException {}

    @Override
    public List<Job> all() throws SQLException {

        ResultSet rsJob = runQuery(ALL_JOB);

        List<Job> jobs = new ArrayList<>();

        while (rsJob.next()) {

            // Get id
            int id = rsJob.getInt(1);

            // Get all job statuses
            List<JobStatus> jobStatuses = new ArrayList<>();
            ResultSet rsJobStatus = runQuery(ALL_JOB_STATUS + id);
            while (rsJobStatus.next()) {
                jobStatuses.add(new JobStatus(rsJobStatus.getInt(1),
                                              rsJobStatus.getInt(2),
                                              rsJobStatus.getString(3)));
            }

            // Get resume
            ResultSet rsResume = runQuery(GET_RESUME+id);
            Resume resume = new Resume(rsResume.getInt(1),
                                       rsResume.getBytes(2),
                                       rsResume.getString(3));

            // Get cover letter
            ResultSet rsCoverLetter = runQuery(GET_COVER_LETTER+id);
            CoverLetter coverLetter = new CoverLetter(rsCoverLetter.getInt(1),
                                                      rsCoverLetter.getBytes(2),
                                                      rsCoverLetter.getString(3));

            // Get all other files
            List<OtherFile> otherFiles = new ArrayList<>();
            ResultSet rsOtherFile = runQuery(ALL_OTHER_FILES+id);
            while (rsOtherFile.next()) {
                otherFiles.add(new OtherFile(rsOtherFile.getInt(1),
                                             rsOtherFile.getString(2),
                                             rsOtherFile.getBytes(3),
                                             rsOtherFile.getString(4)));
            }

            // Make Job object
            Job job = new Job(id,
                              rsJob.getString("title"),
                              rsJob.getString("type"),
                              rsJob.getString("company"),
                              rsJob.getString("description"),
                              rsJob.getInt("timestamp_applied"),
                              rsJob.getString("location"),
                              jobStatuses,
                              resume,
                              coverLetter,
                              otherFiles);

            jobs.add(job);

        }

        return jobs;

    }

    @Override
    public void clear() throws SQLException {

        for (String sql : DELETE_ALL)
            runSql(sql);

    }

    @Override
    public void insert(Object o) throws SQLException {

        Job job;

        // Check and cast o into Job
        if (o instanceof Job) {
            job = (Job) o;
        } else {
            return;
        }

        // Insert into job and get id
        PreparedStatement stmt = conn.prepareStatement(INSERT_JOB);

        stmt.setString(1,job.getTitle());
        stmt.setString(2, job.getType());
        stmt.setString(3, job.getCompany());
        stmt.setString(4, job.getDescription());
        stmt.setInt(5, job.getTimestampApplied());
        stmt.setString(6, job.getLocation());

        stmt.executeUpdate();

        // Get generated id
        int id = stmt.getGeneratedKeys().getInt(1);                 // Job id

        // Set job id for Job and for other attributes in Job that require it
        job.setId(id);

        // Insert resume
        stmt = conn.prepareStatement(INSERT_RESUME);
        stmt.setInt(1, job.getId());
        stmt.setBytes(2, job.getResume().getResume());
        stmt.setString(3, job.getResume().getExtension());
        stmt.executeUpdate();

        // Insert cover letter
        stmt = conn.prepareStatement(INSERT_COVER_LETTER);
        stmt.setInt(1, job.getId());
        stmt.setBytes(2, job.getCoverLetter().getCoverLetter());
        stmt.setString(3, job.getCoverLetter().getExtension());
        stmt.executeUpdate();

        // Insert job statuses
        for (JobStatus status : job.getJobStatuses()) {
            stmt = conn.prepareStatement(INSERT_STATUS);
            stmt.setInt(1, job.getId());
            stmt.setInt(2, status.getTimestamp());
            stmt.setString(3, status.getStatus());
            stmt.executeUpdate();
        }

        // Insert other files
        for (OtherFile file : job.getOtherFiles()) {
            stmt = conn.prepareStatement(INSERT_OTHER_FILE);
            stmt.setInt(1, job.getId());
            stmt.setString(2, file.getName());
            stmt.setBytes(3, file.getFile());
            stmt.setString(4, file.getExtension());
            stmt.executeUpdate();
        }

    }

    @Override
    public void delete(Object o) throws SQLException {

    }
}

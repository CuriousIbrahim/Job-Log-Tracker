package db;

import db.core.Database;
import db.dao.JobDAO;
import model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * JobDatabase is the class that allows communication with the 'job' table. Implements all methods from JobDAO
 */

public class JobDatabase extends Database implements JobDAO {

    // Selecting and Finding, Everything other than ALL_JOB is also used in find() method
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

    // Find
    private static final String FIND_JOB = "SELECT * FROM JOB WHERE id=";

    // Delete
    private static final String DELETE_STATUS = "DELETE FROM job_status WHERE job_id = ?";
    private static final String DELETE_OTHER_FILE = "DELETE FROM other_file WHERE job_id = ?";

    // Update
    private static final String UPDATE_JOB = "UPDATE job SET title = ?, type = ?, company = ?, description = ?, " +
            "timestamp_applied = ?, location = ? WHERE id = ?";
    private static final String UPDATE_RESUME = "UPDATE resume SET resume = ?, extension = ? WHERE job_id = ?";
    private static final String UPDATE_COVER_LETTER = "UPDATE cover_letter SET cover_letter = ?, extension = ? WHERE job_id = ?";

    /**
     * Default constructor
     * @throws SQLException
     */

    public JobDatabase () throws SQLException {}

    /**
     * Returns every entry from the 'job' table
     * @return A List of Job objects
     * @throws SQLException
     */

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
            Resume resume = null;
            if (rsResume.next())
                resume = new Resume(rsResume.getInt(1),
                                           rsResume.getBytes(2),
                                           rsResume.getString(3));

            // Get cover letter
            ResultSet rsCoverLetter = runQuery(GET_COVER_LETTER+id);
            CoverLetter coverLetter = null;
            if (rsCoverLetter.next())
                coverLetter = new CoverLetter(rsCoverLetter.getInt(1),
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

    /**
     * Deletes every entry in the 'job' table
     * @throws SQLException
     */

    @Override
    public void clear() throws SQLException {

        for (String sql : DELETE_ALL)
            runSql(sql);

    }

    /**
     * Inserts into the 'job' table
     * @param o A Job object. If object is not an instanceof Job, then insert will fail
     * @throws SQLException
     */

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

        // Insert resume if not null
        if (job.getResume() != null) {
            stmt = conn.prepareStatement(INSERT_RESUME);
            stmt.setInt(1, job.getId());
            stmt.setBytes(2, job.getResume().getResume());
            stmt.setString(3, job.getResume().getExtension());
            stmt.executeUpdate();
        }

        // Insert cover letter if not null
        if (job.getCoverLetter() != null) {
            stmt = conn.prepareStatement(INSERT_COVER_LETTER);
            stmt.setInt(1, job.getId());
            stmt.setBytes(2, job.getCoverLetter().getCoverLetter());
            stmt.setString(3, job.getCoverLetter().getExtension());
            stmt.executeUpdate();
        }

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

    /**
     * Find and return job data based on id
     * @param id Id of job to find
     * @return Job object containing found job from table
     * @throws SQLException
     */

    @Override
    public Job find(int id) throws SQLException {

        ResultSet rsJob = runQuery(FIND_JOB+id);

        String title = rsJob.getString("title");
        String type = rsJob.getString("type");
        String company = rsJob.getString("company");
        String description = rsJob.getString("description");
        int timestampApplied = rsJob.getInt("timestamp_applied");
        String location = rsJob.getString("location");


        ResultSet rsJobStatus = runQuery(ALL_JOB_STATUS+id);

        List<JobStatus> jobStatuses = new ArrayList<>();
        while (rsJobStatus.next())
            jobStatuses.add(new JobStatus(
                    id, rsJobStatus.getInt("timestamp"), rsJobStatus.getString("status")
            ));


        ResultSet rsResume = runQuery(GET_RESUME+id);

        Resume resume = null;
        if (rsResume.next())
            resume = new Resume(id, rsResume.getBytes("resume"), rsResume.getString("extension"));


        ResultSet rsCoverLetter = runQuery(GET_COVER_LETTER+id);

        CoverLetter coverLetter = null;
        if (rsCoverLetter.next())
            coverLetter = new CoverLetter(id, rsCoverLetter.getBytes("cover_letter"), rsCoverLetter.getString("extension"));


        ResultSet rsOtherFiles = runQuery(ALL_OTHER_FILES+id);

        List<OtherFile> otherFiles = new ArrayList<>();
        while (rsOtherFiles.next())
            otherFiles.add(new OtherFile(
                    id, rsOtherFiles.getString("name"), rsOtherFiles.getBytes("file"), rsOtherFiles.getString("extension")
            ));


        Job job = new Job(
                id, title, type, company, description, timestampApplied, location, jobStatuses, resume, coverLetter, otherFiles
        );

        return job;

    }


    /**
     * Deletes a job based on id
     * @param id Id of job to delete
     * @throws SQLException
     */

    @Override
    public void delete(int id) throws SQLException {

    }

    /**
     * Updates the information of a job
     * @param id Id of job to update
     * @param updatedJob The Updated information
     * @throws SQLException
     */

    @Override
    public void update(int id, Job updatedJob) throws SQLException {

        // job table
        PreparedStatement stmt = conn.prepareStatement(UPDATE_JOB);
        stmt.setString(1, updatedJob.getTitle());
        stmt.setString(2, updatedJob.getType());
        stmt.setString(3, updatedJob.getCompany());
        stmt.setString(4, updatedJob.getDescription());
        stmt.setInt(5, updatedJob.getTimestampApplied());
        stmt.setString(6, updatedJob.getLocation());
        stmt.setInt(7, id);
        stmt.executeUpdate();

        // resume table
        if (updatedJob.getResume() != null) {
            stmt = conn.prepareStatement(UPDATE_RESUME);
            stmt.setBytes(1, updatedJob.getResume().getResume());
            stmt.setString(2, updatedJob.getResume().getExtension());
            stmt.setInt(3, id);
            stmt.executeUpdate();
        }

        // cover_letter table
        if (updatedJob.getCoverLetter() != null) {
            stmt = conn.prepareStatement(UPDATE_COVER_LETTER);
            stmt.setBytes(1, updatedJob.getCoverLetter().getCoverLetter());
            stmt.setString(2, updatedJob.getCoverLetter().getExtension());
            stmt.setInt(3, id);
            stmt.executeUpdate();
        }

        // job_status table
        stmt = conn.prepareStatement(DELETE_STATUS);
        stmt.setInt(1, id);
        stmt.executeUpdate();

        for (JobStatus s : updatedJob.getJobStatuses()) {
            stmt = conn.prepareStatement(INSERT_STATUS);
            stmt.setInt(1, id);
            stmt.setInt(2, s.getTimestamp());
            stmt.setString(3, s.getStatus());
            stmt.executeUpdate();
        }

        // other_file table
        stmt = conn.prepareStatement(DELETE_OTHER_FILE);
        stmt.setInt(1, id);
        stmt.executeUpdate();

        for (OtherFile f : updatedJob.getOtherFiles()) {
            stmt = conn.prepareStatement(INSERT_OTHER_FILE);
            stmt.setInt(1, id);
            stmt.setString(2, f.getName());
            stmt.setBytes(3, f.getFile());
            stmt.setString(4, f.getExtension());
            stmt.executeUpdate();
        }


    }
}

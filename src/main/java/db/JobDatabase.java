package db;

import db.core.Database;
import db.dao.base.BaseDAO;
import model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobDatabase extends Database implements BaseDAO {

    private static final String ALL_JOB = "SELECT * FROM job";
    private static final String ALL_JOB_STATUS = "SELECT * FROM job_status WHERE job_id=";
    private static final String GET_RESUME = "SELECT * FROM resume WHERE job_id=";
    private static final String GET_COVER_LETTER = "SELECT * FROM cover_letter WHERE job_id=";
    private static final String ALL_OTHER_FILES = "SELECT * FROM other_file WHERE job_id=";



    public JobDatabase () throws SQLException {

    }

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

    }

    @Override
    public void insert(Object o) throws SQLException {

    }

    @Override
    public void delete(Object o) throws SQLException {

    }
}

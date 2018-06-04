package model;

/**
 * A JobStatus class. The class represents the status of a job that the user has applied to. The JobStatus includes
 * the status of said job (ex. Waiting, Accepted Offer) and the timestamp of when the status was applied to changed.
 * Represents the 'job' table
 */

public class JobStatus {

    private int jobId;
    private int timestamp;
    private String status;

    /**
     * Constructs a JobStatus object with given parameters
     * @param jobId Id of job
     * @param timestamp Timestamp of status
     * @param status Status of job
     */

    public JobStatus(int jobId, int timestamp, String status) {
        this.jobId = jobId;
        this.timestamp = timestamp;
        this.status = status;
    }

    /**
     * Constructs a JobStatus object with given parameters
     * @param timestamp Timestamp of status
     * @param status Status of job
     */

    public JobStatus(int timestamp, String status) {
        this.timestamp = timestamp;
        this.status = status;
    }

    /**
     * Returns job id
     * @return Job id
     */

    public int getJobId() {
        return jobId;
    }

    /**
     * Sets job id
     * @param jobId Job id
     */

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    /**
     * Return timestamp of job status
     * @return Timestamp of job status
     */

    public int getTimestamp() {
        return timestamp;
    }

    /**
     * Sets timestamp of job status
     * @param timestamp Timestamp of job status
     */

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Returns job status
     * @return Job status
     */

    public String getStatus() {
        return status;
    }

    /**
     * Sets job status
     * @param status Job status
     */

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Checks if obj and this are the exact same.
     * @param obj Another JobStatus object to compare to this
     * @return If obj is not a JobStatus or is not exactly the same to this, return false, otherwise, return true
     */

    @Override
    public boolean equals(Object obj) {
        JobStatus jobStatus = null;
        if (obj instanceof JobStatus)
            jobStatus = (JobStatus) obj;
        else
            return false;

        return ((this.jobId == jobStatus.jobId) && (this.timestamp == jobStatus.timestamp)
                && (this.status.equals(jobStatus.status)));
    }
}

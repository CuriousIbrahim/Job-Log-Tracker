package model;

public class JobStatus {

    private int jobId;
    private int timestamp;
    private String status;

    public JobStatus(int jobId, int timestamp, String status) {
        this.jobId = jobId;
        this.timestamp = timestamp;
        this.status = status;
    }

    public JobStatus(int timestamp, String status) {
        this.timestamp = timestamp;
        this.status = status;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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

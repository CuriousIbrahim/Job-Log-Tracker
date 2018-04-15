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
}

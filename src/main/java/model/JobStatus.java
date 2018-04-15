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
}

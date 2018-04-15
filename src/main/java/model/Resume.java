package model;

public class Resume {

    private int jobId;
    private byte[] resume;
    private String extension;

    public Resume(int jobId, byte[] resume, String extension) {
        this.jobId = jobId;
        this.resume = resume;
        this.extension = extension;
    }
}

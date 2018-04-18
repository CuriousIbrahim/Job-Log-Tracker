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

    public Resume(byte[] resume, String extension) {
        this.resume = resume;
        this.extension = extension;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public byte[] getResume() {
        return resume;
    }

    public void setResume(byte[] resume) {
        this.resume = resume;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}

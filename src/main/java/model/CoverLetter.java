package model;

public class CoverLetter {

    private int jobId;
    private byte[] coverLetter;
    private String extension;

    public CoverLetter(int jobId, byte[] coverLetter, String extension) {
        this.jobId = jobId;
        this.coverLetter = coverLetter;
        this.extension = extension;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public byte[] getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(byte[] coverLetter) {
        this.coverLetter = coverLetter;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}

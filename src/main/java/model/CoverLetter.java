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

}

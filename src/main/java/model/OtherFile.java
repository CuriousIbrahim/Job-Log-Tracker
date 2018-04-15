package model;

public class OtherFile {

    private int jobId;
    private String name;
    private byte[] file;
    private String extension;

    public OtherFile(int jobId, String name, byte[] file, String extension) {
        this.jobId = jobId;
        this.name = name;
        this.file = file;
        this.extension = extension;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}

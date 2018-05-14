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

    @Override
    public boolean equals(Object obj) {
        Resume resume = null;

        if (obj instanceof Resume)
            resume = (Resume) obj;
        else
            return false;

        if (this.jobId != resume.jobId || !this.extension.equals(resume.extension))
            return false;

        boolean areBytesSame;

        // Check if they are the same lengths first
        if (this.resume.length == resume.resume.length) {

            // Iterate each byte in each array and check if they are not similar
            // Average & Worst = O(n)
            for (int i = 0; i < this.resume.length; i++) {

                if (this.resume[i] != resume.resume[i])
                    return false;

            }

            areBytesSame = true;

        } else
            return false;

        return ((this.jobId == resume.jobId) && (areBytesSame) && (this.extension.equals(resume.extension)));

    }
}

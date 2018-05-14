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

    public CoverLetter(byte[] coverLetter, String extension) {
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

    @Override
    public boolean equals(Object obj) {
        CoverLetter coverLetter = null;

        if (obj instanceof CoverLetter)
            coverLetter = (CoverLetter) obj;
        else
            return false;

        if (this.jobId != coverLetter.jobId || !this.extension.equals(coverLetter.extension))
            return false;

        boolean areBytesSame;

        // Check if they are the same lengths first
        if (this.coverLetter.length == coverLetter.coverLetter.length) {

            // Iterate each byte in each array and check if they are not similar
            // Average & Worst = O(n)
            for (int i = 0; i < this.coverLetter.length; i++) {

                if (this.coverLetter[i] != coverLetter.coverLetter[i])
                    return false;

            }

            areBytesSame = true;

        } else
            return false;

        return ((this.jobId == coverLetter.jobId) && (areBytesSame) && (this.extension.equals(coverLetter.extension)));

    }
}

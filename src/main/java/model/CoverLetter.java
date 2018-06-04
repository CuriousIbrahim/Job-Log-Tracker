package model;

import static util.ByteUtil.compareByteArrays;

/**
 * A CoverLetter class
 */

public class CoverLetter {

    private int jobId;
    private byte[] coverLetter;
    private String extension;

    /**
     * Construct a CoverLetter object with given parameters
     * @param jobId Job id
     * @param coverLetter Cover letter in array of bytes
     * @param extension Extension of the file (ex. docx, pdf)
     */

    public CoverLetter(int jobId, byte[] coverLetter, String extension) {
        this.jobId = jobId;
        this.coverLetter = coverLetter;
        this.extension = extension;
    }

    /**
     * Construct a CoverLetter object with given parameters
     * @param coverLetter Cover letter in array of bytes
     * @param extension Extension of the file (ex. docx, pdf)
     */

    public CoverLetter(byte[] coverLetter, String extension) {
        this.coverLetter = coverLetter;
        this.extension = extension;
    }

    /**
     * Return JobId
     * @return Job Id
     */

    public int getJobId() {
        return jobId;
    }

    /**
     * Set Job id
     * @param jobId New job id
     */

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    /**
     * Returns cover letter, represented by an array of bytes
     * @return Array of bytes representing cover letter
     */

    public byte[] getCoverLetter() {
        return coverLetter;
    }

    /**
     * Set cover letter
     * @param coverLetter New cover letter
     */

    public void setCoverLetter(byte[] coverLetter) {
        this.coverLetter = coverLetter;
    }

    /**
     * Returns extension of the cover letter file
     * @return The extension of the cover letter file
     */

    public String getExtension() {
        return extension;
    }

    /**
     * Sets extension of cover letter file
     * @param extension New extension of cover letter file
     */

    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * Checks if this and obj are exactly the same. This includes doing a comparison of each byte
     * @param obj CoverLetter object to compare to this
     * @return If obj is not a CoverLetter or is not exactly the same to this, return false, otherwise, return true
     */

    @Override
    public boolean equals(Object obj) {
        CoverLetter coverLetter = null;

        if (obj instanceof CoverLetter)
            coverLetter = (CoverLetter) obj;
        else
            return false;

        if (this.jobId != coverLetter.jobId || !this.extension.equals(coverLetter.extension))
            return false;

        boolean areBytesSame = compareByteArrays(this.coverLetter, coverLetter.coverLetter);

        return ((this.jobId == coverLetter.jobId) && (areBytesSame) && (this.extension.equals(coverLetter.extension)));

    }
}

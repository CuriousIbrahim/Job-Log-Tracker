package model;

import static util.ByteUtil.compareByteArrays;

/**
 * Resume class represents a resume in which a user used to for their job application. Stores the resume file in array
 * of bytes and the file extension
 */

public class Resume {

    private int jobId;
    private byte[] resume;
    private String extension;

    /**
     * Construct a Resume object with the given parameters
     * @param jobId Id of job
     * @param resume Resume file in array of bytes
     * @param extension Extension of resume file
     */

    public Resume(int jobId, byte[] resume, String extension) {
        this.jobId = jobId;
        this.resume = resume;
        this.extension = extension;
    }

    /**
     * Construct a Resume object with the given parameters
     * @param resume Resume file in array of bytes
     * @param extension Extension of resume file
     */

    public Resume(byte[] resume, String extension) {
        this.resume = resume;
        this.extension = extension;
    }

    /**
     * Return job id
     * @return Job id
     */

    public int getJobId() {
        return jobId;
    }

    /**
     * Set job id
     * @param jobId Job id
     */

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    /**
     * Return resume file represented by an array of bytes
     * @return Resume file represented by an array of bytes
     */

    public byte[] getResume() {
        return resume;
    }

    /**
     * Set resume file
     * @param resume Resume file represented by an array of bytes
     */

    public void setResume(byte[] resume) {
        this.resume = resume;
    }

    /**
     * Return resume file's extension
     * @return Resume file's extension
     */

    public String getExtension() {
        return extension;
    }

    /**
     * Set resume file's extension
     * @param extension Resume file's extension
     */

    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * Check if this and obj are exactly the same. This includes comparing every byte between this and obj
     * @param obj Resume object
     * @return If obj is not a Resume or is not exactly the same to this, return false, otherwise, return true
     */

    @Override
    public boolean equals(Object obj) {
        Resume resume = null;

        if (obj instanceof Resume)
            resume = (Resume) obj;
        else
            return false;

        if (this.jobId != resume.jobId || !this.extension.equals(resume.extension))
            return false;

        boolean areBytesSame = compareByteArrays(this.resume, resume.resume);

        return ((this.jobId == resume.jobId) && (areBytesSame) && (this.extension.equals(resume.extension)));

    }
}

package model;

import static util.ByteUtil.compareByteArrays;

/**
 * OtherFile class represents other files (not including resume and cover letter). Stores the name, file itself in an
 * array of bytes and the file's extension.
 */

public class OtherFile {

    private int jobId;
    private String name;
    private byte[] file;
    private String extension;

    /**
     * Constructs OtherFile object with given parameters
     * @param jobId Id of job
     * @param name Name of file
     * @param file File data in array of bytes
     * @param extension Extension of file (ex. pdf, docx)
     */

    public OtherFile(int jobId, String name, byte[] file, String extension) {
        this.jobId = jobId;
        this.name = name;
        this.file = file;
        this.extension = extension;
    }

    /**
     * Constructs OtherFile object with given parameters
     * @param name Name of file
     * @param file File data in array of bytes
     * @param extension Extension of file (ex. pdf, docx)
     */

    public OtherFile(String name, byte[] file, String extension) {
        this.name = name;
        this.file = file;
        this.extension = extension;
    }

    /**
     * Returns job id
     * @return Job id
     */

    public int getJobId() {
        return jobId;
    }

    /**
     * Sets job id
     * @param jobId Job id
     */

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    /**
     * Returns name of file
     * @return Name of file
     */

    public String getName() {
        return name;
    }

    /**
     * Sets name of file
     * @param name Name of file
     */

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns file
     * @return File data in array of bytes
     */

    public byte[] getFile() {
        return file;
    }

    /**
     * Sets file
     * @param file File data in array of bytes
     */

    public void setFile(byte[] file) {
        this.file = file;
    }

    /**
     * Returns file extension
     * @return File extension
     */

    public String getExtension() {
        return extension;
    }

    /**
     * Set file extension
     * @param extension File extension
     */

    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     * Checks if obj and this are the exact same. This includes comparing every byte between obj and this
     * @param obj OtherFile object
     * @return If obj is not a OtherFile or is not exactly the same to this, return false, otherwise, return true
     */

    @Override
    public boolean equals(Object obj) {
        OtherFile otherFile = null;

        if (obj instanceof OtherFile)
            otherFile = (OtherFile) obj;
        else
            return false;

        if (this.jobId != otherFile.jobId || !this.name.equals(otherFile.name) || !this.extension.equals(otherFile.extension))
            return false;

        boolean areBytesSame = compareByteArrays(this.file, otherFile.file);

        return (this.jobId == otherFile.jobId && this.name.equals(otherFile.name) && areBytesSame
                && this.extension.equals(otherFile.extension));
    }
}

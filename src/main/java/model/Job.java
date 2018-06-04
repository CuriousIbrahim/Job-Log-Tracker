package model;

import util.ListUtil;
import util.Time;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A Job class. The class represents a job in which the user has applied to and logged all the information to keep track of it.
 * In addition, The job class stores a List of the multiple statuses for a Job. Represents the 'job' table
 */

public class Job {

    private int id;
    private String title;
    private String type;
    private String company;
    private String description;
    private int timestampApplied;
    private String location;

    private List<JobStatus> jobStatuses;

    private Resume resume;
    private CoverLetter coverLetter;

    private List<OtherFile> otherFiles;

    /**
     * Constructs a Job object with the given parameters
     * @param id Id of job
     * @param title Title of job
     * @param type Type of job (ex. Full Time, Part Time, Contract, Internship)
     * @param company The company for which this job is with
     * @param description Description of the job, like responsibilities and requirements
     * @param timestampApplied Timestamp of when the job was logged
     * @param location Location of job
     * @param jobStatuses The multiple statuses of the job (ex. Waiting, Accept Offer, etc.)
     * @param resume The resume of the job
     * @param coverLetter The cover letter of the job
     * @param otherFiles Other files for the job
     */

    public Job(int id, String title, String type, String company, String description, int timestampApplied,
               String location, List<JobStatus> jobStatuses, Resume resume, CoverLetter coverLetter,
               List<OtherFile> otherFiles) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.company = company;
        this.description = description;
        this.timestampApplied = timestampApplied;
        this.location = location;
        this.jobStatuses = jobStatuses;
        this.resume = resume;
        this.coverLetter = coverLetter;
        this.otherFiles = otherFiles;
    }

    /**
     * Constructs a Job object with the given parameters
     * @param title Title of job
     * @param type Type of job (ex. Full Time, Part Time, Contract, Internship)
     * @param company The company for which this job is with
     * @param description Description of the job, like responsibilities and requirements
     * @param timestampApplied Timestamp of when the job was logged
     * @param location Location of job
     * @param jobStatuses The multiple statuses of the job (ex. Waiting, Accept Offer, etc.)
     * @param resume The resume of the job
     * @param coverLetter The cover letter of the job
     * @param otherFiles Other files for the job
     */

    public Job(String title, String type, String company, String description, int timestampApplied, String location,
               List<JobStatus> jobStatuses, Resume resume, CoverLetter coverLetter, List<OtherFile> otherFiles) {
        this.title = title;
        this.type = type;
        this.company = company;
        this.description = description;
        this.timestampApplied = timestampApplied;
        this.location = location;
        this.jobStatuses = jobStatuses;
        this.resume = resume;
        this.coverLetter = coverLetter;
        this.otherFiles = otherFiles;
    }

    /**
     * Returns job id
     * @return Job id
     */

    public int getId() {
        return id;
    }

    /**
     * Sets job id for the Job object and for resume, coverLetter, jobStatuses, and otherFiles
     * @param id New job id
     */

    public void setId(int id) {
        this.id = id;
        if (resume != null)
            this.resume.setJobId(id);

        if (coverLetter != null)

            this.coverLetter.setJobId(id);
        if (jobStatuses != null)
            for (JobStatus jobStatus : jobStatuses)
                jobStatus.setJobId(id);

        if (otherFiles != null)
            for (OtherFile otherFile : otherFiles)
                otherFile.setJobId(id);
    }

    /**
     * Returns the job title
     * @return Job title
     */

    public String getTitle() {
        return title;
    }

    /**
     * Sets job title
     * @param title New job title
     */

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns job type
     * @return Job type
     */

    public String getType() {
        return type;
    }

    /**
     * Sets job type
     * @param type New job type
     */

    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the company for job
     * @return Company for job
     */

    public String getCompany() {
        return company;
    }

    /**
     * Sets the company for job
     * @param company New company for job
     */

    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Returns the job's description
     * @return Job's description
     */

    public String getDescription() {
        return description;
    }

    /**
     * Sets job's description
     * @param description New job's description
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the timestamp to when the job was added
     * @return Timestamp to when the job was added
     */

    public int getTimestampApplied() {
        return timestampApplied;
    }

    /**
     * Returns job's locatio
     * @return Job's location
     */

    public String getLocation() {
        return location;
    }

    /**
     * Sets job's location
     * @param location New job's location
     */

    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Returns a List of all job statuses for job
     * @return List of all job statuses for job
     */

    public List<JobStatus> getJobStatuses() {
        return jobStatuses;
    }

    /**
     * Sets job statuses
     * @param jobStatuses New List of job statuses
     */

    public void setJobStatuses(List<JobStatus> jobStatuses) {
        this.jobStatuses = jobStatuses;
    }

    /**
     * Returns job's resume
     * @return Job's resume
     */

    public Resume getResume() {
        return resume;
    }

    /**
     * Sets job's resume
     * @param resume New resume for Job
     */

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    /**
     * Returns job's cover letter
     * @return Job's cover letter
     */

    public CoverLetter getCoverLetter() {
        return coverLetter;
    }

    /**
     * Set job's cover letter
     * @param coverLetter New cover letter for job
     */

    public void setCoverLetter(CoverLetter coverLetter) {
        this.coverLetter = coverLetter;
    }

    /**
     * Returns a List of other files
     * @return List of other files
     */

    public List<OtherFile> getOtherFiles() {
        return otherFiles;
    }

    /**
     * Sets other files
     * @param otherFiles List of other files
     */

    public void setOtherFiles(List<OtherFile> otherFiles) {
        this.otherFiles = otherFiles;
    }

    /**
     * Returns most current job status
     * @return Most current job status
     */

    public JobStatus getCurrentJobStatus() {

        JobStatus largest = null;

        largest = jobStatuses.get(0);

        for (JobStatus s : jobStatuses) {
            if (s.getTimestamp() > largest.getTimestamp()) {
                largest = s;
            }
        }

        return largest;
    }

    /**
     * Returns a List of Strings containing only the statuses
     * @return List of Strings statuses
     */

    public List<String> getJobStatusesString() {
        List<String> statuses = new ArrayList<>();
        for (JobStatus s : jobStatuses)
            statuses.add(s.getStatus());

        return statuses;
    }

    /**
     * Returns a List of LocalDates for the job statuses
     * @return List of LocalDates for the job statuses
     */

    public List<LocalDate> getJobStatusDates() {
        List<LocalDate> dates = new ArrayList<>();
        for (JobStatus s : jobStatuses)
            dates.add(Time.unixTimestampToLocalDate(s.getTimestamp()));

        return dates;
    }

    /**
     * Returns a List of Strings containing only the names of the other files
     * @return List of Stringss containing the name of the other files
     */

    public List<String> getOtherFileNames() {
        List<String> names = new ArrayList<>();
        for (OtherFile f : otherFiles)
            names.add(f.getName());

        return names;
    }

    /**
     * Checks if this and obj are exactly the same object. This includes comparing the resume, cover letter, every status,
     * and every other file. Resource intensive depending on how many files the job has (ex. resume, cover letter & other files)
     * @param obj Another Job object to compare to this
     * @return If obj is not a Job or is not exactly the same to this, return false, otherwise, return true
     */

    @Override
    public boolean equals(Object obj) {
        Job job = null;

        if (obj instanceof Job)
            job = (Job) obj;
        else
            return false;

        if (this.id != job.id)
            return false;

        boolean jobStatusesSame;
        // Compare Job Statuses
        if (this.jobStatuses.size() == job.jobStatuses.size()) {
            for (int i = 0; i < this.jobStatuses.size(); i++) {
                if (!this.jobStatuses.get(i).equals(job.jobStatuses.get(i)))
                    return false;
            }
            jobStatusesSame = true;
        } else
            return false;

        boolean otherFilesSame;
        // Compare Other Files
        if (this.otherFiles.size() == job.otherFiles.size()) {
            for (int i = 0; i < this.otherFiles.size(); i++) {
                if (!this.otherFiles.get(i).equals(job.otherFiles.get(i)))
                    return false;
            }
            otherFilesSame = true;
        } else
            return false;

        return (this.id == job.id && this.title.equals(job.title) && this.type.equals(job.type)
                && this.company.equals(job.company) && this.description.equals(job.description)
                && this.timestampApplied == job.timestampApplied && this.location.equals(job.location)
                && jobStatusesSame && this.resume.equals(job.resume) && this.coverLetter.equals(job.coverLetter)
                && otherFilesSame);
    }

    /**
     * Returns a String containing all information about this Job
     * @return String containing all information about this Job
     */

    @Override
    public String toString() {

        List<String> jobStatusStrings = new ArrayList<>();
        List<String> otherFileStrings = new ArrayList<>();

        for (JobStatus jobStatus : jobStatuses)
            jobStatusStrings.add(jobStatus.toString());

        for (OtherFile otherFile : otherFiles)
            otherFileStrings.add(otherFile.toString());

        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", company='" + company + '\'' +
                ", description='" + description + '\'' +
                ", timestampApplied=" + timestampApplied +
                ", location='" + location + '\'' +
                ", jobStatuses=" + ListUtil.listOfStringsToString(getJobStatusesString()) +
                ", resume=" + resume.toString() +
                ", coverLetter=" + coverLetter.toString() +
                ", otherFiles=" + ListUtil.listOfStringsToString(otherFileStrings) +
                '}';
    }
}

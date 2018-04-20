package model;

import java.util.List;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        this.resume.setJobId(id);
        this.coverLetter.setJobId(id);

        for (JobStatus jobStatus : jobStatuses)
            jobStatus.setJobId(id);

        for (OtherFile otherFile : otherFiles)
            otherFile.setJobId(id);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTimestampApplied() {
        return timestampApplied;
    }

    public void setTimestampApplied(int timestampApplied) {
        this.timestampApplied = timestampApplied;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<JobStatus> getJobStatuses() {
        return jobStatuses;
    }

    public void setJobStatuses(List<JobStatus> jobStatuses) {
        this.jobStatuses = jobStatuses;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public CoverLetter getCoverLetter() {
        return coverLetter;
    }

    public void setCoverLetter(CoverLetter coverLetter) {
        this.coverLetter = coverLetter;
    }

    public List<OtherFile> getOtherFiles() {
        return otherFiles;
    }

    public void setOtherFiles(List<OtherFile> otherFiles) {
        this.otherFiles = otherFiles;
    }

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
}

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
}

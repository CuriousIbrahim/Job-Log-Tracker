package model;

import util.ListUtil;
import util.Time;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public List<String> getJobStatusesString() {
        List<String> statuses = new ArrayList<>();
        for (JobStatus s : jobStatuses)
            statuses.add(s.getStatus());

        return statuses;
    }

    public List<LocalDate> getJobStatusDates() {
        List<LocalDate> dates = new ArrayList<>();
        for (JobStatus s : jobStatuses)
            dates.add(Time.unixTimestampToLocalDate(s.getTimestamp()));

        return dates;
    }

    public List<String> getOtherFileNames() {
        List<String> names = new ArrayList<>();
        for (OtherFile f : otherFiles)
            names.add(f.getName());

        return names;
    }

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

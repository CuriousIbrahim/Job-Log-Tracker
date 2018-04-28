package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import view.attribute.DatePickerAttribute;
import view.attribute.TextAttribute;
import view.attribute.dropdown.DropdownAttribute;
import view.attribute.file.FileAttribute;
import view.attribute.list.JobStatusesList;
import view.attribute.special.JobStatusAttribute;
import view.attribute.special.OtherFileAttribute;
import view.attribute.list.OtherFilesList;

import java.time.LocalDate;
import java.util.List;

public class JobWindow extends Stage {

    private Button button;
    private GridPane mainGridPane;

    private TextAttribute title;
    private DropdownAttribute type;

    private TextAttribute location;
    private TextAttribute company;
    private DatePickerAttribute date;

    private FileAttribute resume;
    private FileAttribute coverLetter;

    private TextArea description;

    private JobStatusesList jobStatuses;
    private OtherFilesList otherFilesList;

    public JobWindow() {

        // ============================================================
        // Initialize variables
        // ============================================================

        button = new Button("Add");

        mainGridPane = new GridPane();

        title = new TextAttribute("Title");
        type = new DropdownAttribute("Type");

        location = new TextAttribute("Location");
        company = new TextAttribute("Company");
        date = new DatePickerAttribute("Date", true);

        resume = new FileAttribute("Resume");
        coverLetter = new FileAttribute("Cover Letter");

        description = new TextArea();

        jobStatuses = new JobStatusesList();
        otherFilesList = new OtherFilesList();

        // ============================================================
        // Add to mainGridPane
        // ============================================================

        mainGridPane.add(title, 0, 0);
        mainGridPane.add(type, 2, 0);

        mainGridPane.add(location, 0, 1);
        mainGridPane.add(company, 1, 1);
        mainGridPane.add(date, 2, 1);

        mainGridPane.add(resume, 0, 2);
        mainGridPane.add(coverLetter, 2, 2);

        mainGridPane.add(new Label("Description"), 0, 3);
        mainGridPane.add(description, 0, 4, 3, 2);

        // TODO: Display a List of DropDownAttribute and FileAttribute
        mainGridPane.add(otherFilesList, 0, 7, 2, 4);
        mainGridPane.add(jobStatuses, 2, 7, 2, 6);


        HBox buttonBox = new HBox(button);
        buttonBox.setAlignment(Pos.CENTER);
        mainGridPane.add(buttonBox, 1, 14);

        // ============================================================

        mainGridPane.setVgap(20);
        mainGridPane.setHgap(20);
        mainGridPane.setPadding(new Insets(25));

        Scene scene = new Scene(mainGridPane);
        setScene(scene);


    }

    public Button getButton() {
        return button;
    }

    public String getJobTitle() {
        return title.getValue();
    }

    public void setTypes(List<String> options) {
        type.setOptions(options);
    }

    public String getType() {
        return type.getValue();
    }

    public String getLocation() {
        return location.getValue();
    }

    public String getCompany() {
        return company.getValue();
    }

    public LocalDate getDate() {
        return date.getValue();
    }

    public String getResume() {
        return resume.getValue();
    }

    public String getCoverLetter() {
        return coverLetter.getValue();
    }

    public String getDescription() {
        return description.getText();
    }

    public List<JobStatusAttribute> getJobStatuses() {
        return jobStatuses.getJobStatusAttributes();
    }

    public List<OtherFileAttribute> getOtherFilesList() {
        return otherFilesList.getOtherFileAttributes();
    }

    public void setStatusOptions(List<String> options) {
        this.jobStatuses.setOptions(options);
    }

    public void setJobTitle(String title) {
        this.title.setValue(title);
    }

    public void setType(String type) {
        this.type.setValue(type);
    }

    public void setLocation(String location) {
        this.location.setValue(location);
    }

    public void setCompany(String company) {
        this.company.setValue(company);
    }

    public void setDate(LocalDate date) {
        this.date.setValue(date);
    }

    public void setResume(String resume) {
        this.resume.setValue(resume);
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter.setValue(coverLetter);
    }

    public void setDescription(String description) {
        this.description.setText(description);
    }

    public void setJobStatuses(List<String> statuses, List<LocalDate> dates) {
        for (int i = 0; i < statuses.size(); i++) {
            this.jobStatuses.addItem(statuses.get(i), dates.get(i));
        }
    }

    public void setOtherFilesList(List<String> names, List<String> filePaths) {
        for (int i = 0; i < names.size(); i++) {
            this.otherFilesList.addItem(names.get(i), filePaths.get(i));
        }
    }
}

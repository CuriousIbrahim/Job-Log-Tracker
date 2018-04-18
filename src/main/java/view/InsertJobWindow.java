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
import view.attribute.special.JobStatusAttribute;
import view.attribute.special.OtherFileAttribute;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InsertJobWindow extends Stage {

    private Button submitBtn;
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

    public InsertJobWindow() {

        // ============================================================
        // Initialize variables
        // ============================================================

        submitBtn = new Button("Add");

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


        HBox buttonBox = new HBox(submitBtn);
        buttonBox.setAlignment(Pos.CENTER);
        mainGridPane.add(buttonBox, 1, 14);

        // ============================================================

        mainGridPane.setVgap(20);
        mainGridPane.setHgap(20);
        mainGridPane.setPadding(new Insets(25));

        Scene scene = new Scene(mainGridPane);
        setScene(scene);


    }

    public Button getSubmitBtn() {
        return submitBtn;
    }

    public String getJobTitle() {
        return title.getValue();
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

    public JobStatusesList getJobStatuses() {
        return jobStatuses;
    }

    public OtherFilesList getOtherFilesList() {
        return otherFilesList;
    }

    class OtherFilesList extends GridPane {

        private List<OtherFileAttribute> otherFileAttributes;
        private Button addNewBtn;

        private final int MAX = 3;

        public OtherFilesList () {
            otherFileAttributes = new ArrayList<>();

            addNewBtn = new Button("Add New");

            addNewBtn.setOnAction(event -> {
                addItem();
            });

            load();

            setHgap(10);
            setVgap(10);

        }

        public void addItem() {

            if (otherFileAttributes.size() >= MAX) {
                return;
            }

            getChildren().clear();

            OtherFileAttribute temp = new OtherFileAttribute();
            temp.getXButton().setOnAction(event -> {
                removeItem(temp.getUniqueId());
            });

            otherFileAttributes.add(0, temp);

            load();

        }

        private void removeItem(int id) {
            for (int i = 0; i < otherFileAttributes.size(); i++) {
                if (id == otherFileAttributes.get(i).getUniqueId())
                    otherFileAttributes.remove(i);
            }

            getChildren().clear();

            load();
        }

        private void load() {
            // Static
            add(new Label("Other File"), 0, 0);
            add(addNewBtn, 1, 0);

            // Dynamic
            for (int i = 0; i < otherFileAttributes.size(); i++)
                add(otherFileAttributes.get(i), 0, i+2, 3, 1);

        }

    }

    class JobStatusesList extends GridPane {

        private List<JobStatusAttribute> jobStatusAttributes;
        private Button addNewBtn;

        private final int MAX = 5;

        public JobStatusesList () {
            jobStatusAttributes = new ArrayList<>();

            addNewBtn = new Button("Add New");

            addNewBtn.setOnAction(event -> {
                addItem();
            });

            load();

            setHgap(10);
            setVgap(10);

        }

        public void addItem() {

            if (jobStatusAttributes.size() >= MAX) {
                return;
            }

            getChildren().clear();

            JobStatusAttribute temp = new JobStatusAttribute();
            System.out.println(temp.getUniqueId());
            temp.getXButton().setOnAction(event -> {
                removeItem(temp.getUniqueId());
            });

            jobStatusAttributes.add(0, temp);

            load();

        }

        private void removeItem(int id) {
            for (int i = 0; i < jobStatusAttributes.size(); i++) {
                if (id == jobStatusAttributes.get(i).getUniqueId())
                    jobStatusAttributes.remove(i);
            }

            getChildren().clear();

            load();
        }

        private void load() {
            // Static
            add(new Label("Job Statuses"), 0, 0);
            add(addNewBtn, 1, 0);

            // Dynamic
            for (int i = 0; i < jobStatusAttributes.size(); i++)
                add(jobStatusAttributes.get(i), 0, i+2, 3, 1);

        }

    }
}

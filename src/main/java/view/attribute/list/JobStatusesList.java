package view.attribute.list;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import view.attribute.special.JobStatusAttribute;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Visual list (using GridPane) of JobStatusAttribute objects, allows the addition of new JobStatusAttributes (max of 5)
 * and removal of JobStatusAttributes
 */

public class JobStatusesList extends GridPane {

    private List<JobStatusAttribute> jobStatusAttributes;
    private Button addNewBtn;

    private List<String> options;

    private final int MAX = 5;

    /**
     * Constructs a JobStatusList object, takes care of the placement of each visual object as well as its spacing
     */

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

    /**
     * Add a new job status to the list with the given parameters filled in to its fields
     * @param status Job status
     * @param date Job status' date
     */

    public void addItem(String status, LocalDate date) {

        if (jobStatusAttributes.size() >= MAX) {
            return;
        }

        getChildren().clear();

        JobStatusAttribute temp;
        if (options != null)
            temp = new JobStatusAttribute(options, status, date);
        else
            temp = new JobStatusAttribute();

        temp.getXButton().setOnAction(event -> {
            removeItem(temp.getUniqueId());
        });

        jobStatusAttributes.add(0, temp);

        load();

    }

    /**
     * Add new JobStatusAttribute to list with empty fields
     */

    public void addItem() {

        if (jobStatusAttributes.size() >= MAX) {
            return;
        }

        getChildren().clear();

        JobStatusAttribute temp;
        if (options != null)
            temp = new JobStatusAttribute(options);
        else
            temp = new JobStatusAttribute();

        temp.getXButton().setOnAction(event -> {
            removeItem(temp.getUniqueId());
        });

        jobStatusAttributes.add(0, temp);

        load();

    }

    /**
     * Remove JobStatusAttribute from the List based on id
     * @param id Id of JobStatusAttribute to remove
     */

    private void removeItem(int id) {
        for (int i = 0; i < jobStatusAttributes.size(); i++) {
            if (id == jobStatusAttributes.get(i).getUniqueId())
                jobStatusAttributes.remove(i);
        }

        getChildren().clear();

        load();
    }

    /**
     * Load/Reload view
     */

    private void load() {
        // Static
        add(new Label("Job Statuses"), 0, 0);
        add(addNewBtn, 1, 0);

        // Dynamic
        for (int i = 0; i < jobStatusAttributes.size(); i++)
            add(jobStatusAttributes.get(i), 0, i+2, 3, 1);

    }

    /**
     * Set the options for the JobStatusAttributes, when adding a new JobStatusAttribute, these are the options that will
     * be avaiable for the status
     * @param options Options to set for the JobStatusAttributes
     */

    public void setOptions(List<String> options) {
        this.options = options;

        for (JobStatusAttribute a : jobStatusAttributes)
            a.setOptions(options);
    }

    /**
     * Return all the JobStatusAttributes in a List
     * @return All the JobStatusAttributes in a List
     */

    public List<JobStatusAttribute> getJobStatusAttributes() {
        return jobStatusAttributes;
    }
}

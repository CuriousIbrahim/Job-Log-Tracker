package view.attribute.list;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import view.attribute.special.JobStatusAttribute;

import java.util.ArrayList;
import java.util.List;

public class JobStatusesList extends GridPane {

    private List<JobStatusAttribute> jobStatusAttributes;
    private Button addNewBtn;

    private List<String> options;

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

    public void setOptions(List<String> options) {
        this.options = options;

        for (JobStatusAttribute a : jobStatusAttributes)
            a.setOptions(options);
    }

    public List<JobStatusAttribute> getJobStatusAttributes() {
        return jobStatusAttributes;
    }
}

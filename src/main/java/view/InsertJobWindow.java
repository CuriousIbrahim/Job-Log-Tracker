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
import view.attribute.TextAttribute;
import view.attribute.DropdownAttribute;
import view.attribute.file.FileAttribute;

import java.util.ArrayList;
import java.util.List;

public class InsertJobWindow extends Stage {

    private Button submitBtn;
    private GridPane mainGridPane;

    private TextAttribute title;
    private DropdownAttribute type;

    private TextAttribute location;
    private TextAttribute company;
    private TextAttribute date;

    private FileAttribute resume;
    private FileAttribute coverLetter;

    private TextArea description;

    private List<DropdownAttribute> jobStatuses;
    private List<FileAttribute> otherFile;

    public InsertJobWindow() {

        submitBtn = new Button("Add");

        mainGridPane = new GridPane();

        // ============================================================
        // Initialize variables
        // ============================================================

        title = new TextAttribute("Title");
        type = new DropdownAttribute("Type");

        location = new TextAttribute("Location");
        company = new TextAttribute("Company");
        date = new TextAttribute("Date");

        resume = new FileAttribute("Resume");
        coverLetter = new FileAttribute("Cover Letter");

        description = new TextArea();

        jobStatuses = new ArrayList<>();
        otherFile = new ArrayList<>();

        // ============================================================
        // Add to mainGridPane
        // ============================================================


        mainGridPane.add(title, 0, 0);
        mainGridPane.add(type, 2, 0);

        mainGridPane.add(location, 0, 1);
        mainGridPane.add(company, 1, 1);
        mainGridPane.add(date, 2, 1);

        mainGridPane.add(new Label("Description"), 0, 2);
        mainGridPane.add(description, 0, 3, 3, 2);

        // TODO: Display a List of DropDownAttribute and FileAttribute

        HBox buttonBox = new HBox(submitBtn);
        buttonBox.setAlignment(Pos.CENTER);
        mainGridPane.add(buttonBox, 1, 6);

        // ============================================================

        mainGridPane.setVgap(20);
        mainGridPane.setHgap(20);
        mainGridPane.setPadding(new Insets(25));

        Scene scene = new Scene(mainGridPane);
        setScene(scene);


    }
}

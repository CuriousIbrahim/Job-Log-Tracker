package view;

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

        GridPane row1 = new GridPane();
        row1.add(title, 0, 0);
        row1.add(type, 1,0);
        mainGridPane.add(row1, 0, 0);

        GridPane row2 = new GridPane();
        row2.add(location, 0, 0);
        row2.add(company, 1, 0);
        row2.add(date, 2, 0);
        mainGridPane.add(row2, 0, 1);

        GridPane row3 = new GridPane();
        row3.add(resume, 0, 0);
        row3.add(coverLetter, 1, 0);
        mainGridPane.add(row3, 0, 2);

        HBox row4 = new HBox(new Label("Description"));
        row4.setAlignment(Pos.CENTER_LEFT);
        mainGridPane.add(row4, 0, 3);

        HBox row5 = new HBox(description);
        row5.setAlignment(Pos.CENTER);
        mainGridPane.add(row5, 0, 4);

        GridPane row6 = new GridPane();
        // TODO: Display a List of DropDownAttribute and FileAttribute
        mainGridPane.add(row6, 0, 5);

        HBox row7 = new HBox(submitBtn);
        row7.setAlignment(Pos.CENTER);
        mainGridPane.add(row7, 0, 6);

        Scene scene = new Scene(mainGridPane);
        setScene(scene);


    }
}

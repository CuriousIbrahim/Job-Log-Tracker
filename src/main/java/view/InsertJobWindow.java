package view;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.attribute.TextAttribute;
import view.attribute.dropdown.base.DropdownAttribute;
import view.attribute.file.FileAttribute;

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

        GridPane row1 = new GridPane();



    }
}
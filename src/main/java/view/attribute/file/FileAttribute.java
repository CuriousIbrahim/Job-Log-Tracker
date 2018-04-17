package view.attribute.file;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import view.attribute.base.BaseAttribute;

import java.io.File;

public class FileAttribute extends BaseAttribute {

    private Button button;
    private TextField filePath;

    private FileChooser fileChooser;
    private Stage fileChooserStage;

    public FileAttribute (String labelName) {
        super(labelName);

        value = new GridPane();

        filePath = new TextField();
        button = new Button("Select File");

        button.setOnAction(event -> {

            fileChooserStage = new Stage();
            fileChooser = new FileChooser();

            File file = fileChooser.showOpenDialog(fileChooserStage);

            if (file != null) {
                filePath.setText(file.getAbsolutePath());
            }

        });

        filePath.setEditable(false);


        ((GridPane)value).add(filePath, 1, 1);
        ((GridPane)value).add(button, 2, 1);

        ((GridPane)value).setHgap(5);

        addValueNodeToPane();

    }

    @Override
    public String getValue() {
        return filePath.getText();
    }
}

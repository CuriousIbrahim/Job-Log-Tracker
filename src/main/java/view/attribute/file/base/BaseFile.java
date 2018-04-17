package view.attribute.file.base;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class BaseFile extends GridPane {

    private Button button;
    private TextField filePath;

    private FileChooser fileChooser;
    private Stage fileChooserStage;

    public BaseFile() {

        filePath = new TextField();
        button = new Button("Select File");

        add(filePath, 0, 0);
        add(button, 1, 0);

        setHgap(5);

        button.setOnAction(event -> {

            fileChooserStage = new Stage();
            fileChooser = new FileChooser();

            File file = fileChooser.showOpenDialog(fileChooserStage);

            if (file != null) {
                filePath.setText(file.getAbsolutePath());
            }

        });

        filePath.setEditable(false);

    }

    public BaseFile(String path) {
        super();

        filePath.setText(path);
    }

    public String getFilePath() {
        return filePath.getText();
    }
}

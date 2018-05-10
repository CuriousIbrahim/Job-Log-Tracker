package view.attribute.file.base;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class BaseFile extends GridPane {

    private Button selectFileBtn;
    private TextField filePath;

    private FileChooser fileChooser;
    private Stage fileChooserStage;

    public BaseFile() {

        filePath = new TextField();
        selectFileBtn = new Button("Select File");

        add(filePath, 0, 0);
        add(selectFileBtn, 1, 0);

        setHgap(5);

        selectFileBtn.setOnAction(event -> {

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
        this();

        filePath.setText(path);
    }

    public String getFilePath() {
        return filePath.getText();
    }

    public void setFilePath(String filePath) {
        this.filePath.setText(filePath);
    }
}

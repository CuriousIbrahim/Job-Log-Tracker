package view.attribute.file.base;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BaseFile extends GridPane {

    private Button selectFileBtn;
    private Button openBtn;
    private TextField filePath;

    private FileChooser fileChooser;
    private Stage fileChooserStage;

    public BaseFile() {

        filePath = new TextField();
        selectFileBtn = new Button("Select File");
        openBtn = new Button("Open");

        add(filePath, 0, 0);
        add(selectFileBtn, 1, 0);
        add(openBtn, 2, 0);

        openBtn.setVisible(false);

        setHgap(5);

        selectFileBtn.setOnAction(event -> {

            fileChooserStage = new Stage();
            fileChooser = new FileChooser();

            File file = fileChooser.showOpenDialog(fileChooserStage);

            if (file != null) {
                filePath.setText(file.getAbsolutePath());
                openBtn.setVisible(true);
            }

        });

        openBtn.setOnAction(event -> {
            try {
                Desktop.getDesktop().open(new File(filePath.getText()));
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
        });

        filePath.setEditable(false);

    }

    public BaseFile(String path) {
        this();

        filePath.setText(path);

        openBtn.setVisible(true);
    }

    public String getFilePath() {
        return filePath.getText();
    }

    public void setFilePath(String filePath) {
        this.filePath.setText(filePath);
        openBtn.setVisible(true);
    }
}

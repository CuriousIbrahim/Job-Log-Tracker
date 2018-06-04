package view.attribute.file.base;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Contains the basics to browse computer, select a folder, and stores path in a TextField
 */

public class BaseFile extends GridPane {

    private Button selectFileBtn;
    private Button openBtn;
    private TextField filePath;

    private FileChooser fileChooser;
    private Stage fileChooserStage;

    /**
     * Constructs a BaseFile object, and takes care of GridPane spacing and location of each Node
     */

    public BaseFile() {

        filePath = new TextField();
        selectFileBtn = new Button("Select File");
        openBtn = new Button("Open");

        add(filePath, 0, 0);
        add(selectFileBtn, 1, 0);
        add(openBtn, 2, 0);

        openBtn.setDisable(true);

        setHgap(5);

        selectFileBtn.setOnAction(event -> {

            fileChooserStage = new Stage();
            fileChooser = new FileChooser();

            File file = fileChooser.showOpenDialog(fileChooserStage);

            if (file != null) {
                filePath.setText(file.getAbsolutePath());
                openBtn.setDisable(false);
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

    /**
     * Constructs a BaseFile object, calls default constructor and sets file path in TextField
     * @param path Valid file path
     */

    public BaseFile(String path) {
        this();

        filePath.setText(path);

        openBtn.setDisable(false);
    }

    /**
     * Returns file path
     * @return File path
     */

    public String getFilePath() {
        return filePath.getText();
    }

    /**
     * Sets file path in view
     * @param filePath File path
     */

    public void setFilePath(String filePath) {
        this.filePath.setText(filePath);

        openBtn.setDisable(false);
    }
}

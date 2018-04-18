package view.attribute.special;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import view.attribute.file.base.BaseFile;

public class OtherFileAttribute extends GridPane {

    private static int MAIN_ID = 0;

    private int id;
    private Button x;
    private TextField name;
    private BaseFile file;

    public OtherFileAttribute() {

        id = MAIN_ID++;
        x = new Button("X");
        name = new TextField("Insert Name");
        file = new BaseFile();

        add(x, 0, 0);
        add(name, 1, 0);
        add(file, 2, 0);

        setHgap(5);

    }

    public OtherFileAttribute(String name, String filePath){
        this();
        this.name.setText(name);
        file.setFilePath(filePath);
    }

    public String getName() {
        return name.getText();
    }

    public String getFile() {
        return file.getFilePath();
    }

    public Button getXButton() {
        return x;
    }

    public int getUniqueId() {
        return id;
    }
}

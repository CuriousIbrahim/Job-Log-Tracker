package view.attribute.special;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import view.attribute.file.base.BaseFile;

public class OtherFileAttribute extends GridPane {

    private TextField name;
    private BaseFile file;

    public OtherFileAttribute() {

        name = new TextField("Insert Name");
        file = new BaseFile();

        add(name, 0, 0);
        add(file, 1, 0);

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
}

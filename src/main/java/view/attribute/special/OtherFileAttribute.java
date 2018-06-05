package view.attribute.special;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import view.attribute.file.base.BaseFile;

/**
 * The OtherFileAttribute class does NOT inherit from BaseAttribute, allows input for the name of a file as well as
 * the input for the file path using BaseFile class
 */

public class OtherFileAttribute extends GridPane {

    private static int MAIN_ID = 0;

    private int id;
    private Button x;
    private TextField name;
    private BaseFile file;

    /**
     * Default constructor, is in charge of the placement of each Node or visual object as well as the spacing between
     * each visual object
     */

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

    /**
     * Constructs a OtherFileAttribute object with the given parameters. Also calls default constructor. Sets the name
     * filePath in the visual objects
     * @param name Name of file
     * @param filePath Path of file
     */

    public OtherFileAttribute(String name, String filePath){
        this();
        this.name.setText(name);
        file.setFilePath(filePath);
    }

    /**
     * Returns name of file
     * @return Name of file
     */

    public String getName() {
        return name.getText();
    }

    /**
     * Returns path of file
     * @return Path of file
     */

    public String getFile() {
        return file.getFilePath();
    }

    /**
     * Returns the X button, the X button is in charge of removing a other file input attribute
     * @return X Button
     */

    public Button getXButton() {
        return x;
    }

    /**
     * Returns job id
     * @return Job id
     */

    public int getUniqueId() {
        return id;
    }
}

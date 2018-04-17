package view.attribute.file;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import view.attribute.base.BaseAttribute;
import view.attribute.file.base.BaseFile;

public class FileAttribute extends BaseAttribute {

    public FileAttribute (String labelName) {
        super(labelName);

        value = new BaseFile();

        addValueNodeToPane();

    }

    @Override
    public String getValue() {
        return ((BaseFile)value).getFilePath();
    }
}

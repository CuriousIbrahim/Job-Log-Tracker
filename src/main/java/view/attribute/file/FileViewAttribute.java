package view.attribute.file;

import javafx.scene.control.Button;
import view.attribute.base.BaseAttribute;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FileViewAttribute extends BaseAttribute {

    File file;

    public FileViewAttribute(String label, File file) {
        super(label);
        this.file = file;

        value = new Button("View");


        ((Button)value).setOnAction(event -> {

            try {

                Desktop.getDesktop().open(file);

            } catch (IOException e) {

            }

        });


        addValueNodeToPane();
    }


    @Override
    public String getValue() {
        return null;
    }
}

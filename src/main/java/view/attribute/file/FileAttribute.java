package view.attribute.file;

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

    @Override
    public void setValue(Object o) {

        String temp = null;

        if (o instanceof String)
            temp = (String) o;
        else
            return;

        ((BaseFile)value).setFilePath(temp);

    }
}

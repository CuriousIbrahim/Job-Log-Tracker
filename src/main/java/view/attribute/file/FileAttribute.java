package view.attribute.file;

import view.attribute.base.BaseAttribute;
import view.attribute.file.base.BaseFile;

/**
 * Represents the Attribute of a file, allows file input using a FileBrowser from BaseFile
 */

public class FileAttribute extends BaseAttribute {

    /**
     * Constructs FileAttribute object, sets label name of attribute
     * @param labelName
     */

    public FileAttribute (String labelName) {
        super(labelName);

        value = new BaseFile();

        addValueNodeToPane();

    }

    /**
     * Returns value of attribute
     * @return Value of attribute
     */

    @Override
    public String getValue() {
        return ((BaseFile)value).getFilePath();
    }

    /**
     * Sets value in view
     * @param o Value to place in view
     */

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

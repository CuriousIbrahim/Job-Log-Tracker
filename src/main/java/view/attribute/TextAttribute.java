package view.attribute;

import javafx.scene.control.TextField;
import view.attribute.base.BaseAttribute;

/**
 * Represents the attribute in which the value is a simple String of text, inherits from BaseAttribute
 */

public class TextAttribute extends BaseAttribute {

    /**
     * Constructs TextAttribute object, sets attribute's label name
     * @param labelName Label of attribute
     */

    public TextAttribute (String labelName) {
        super(labelName);

        this.value = new TextField();

        addValueNodeToPane();

    }

    /**
     * Constructs TextAttribute object, sets attribute's label name and value name
     * @param labelName Label of attribute
     * @param valueName Value of attribute
     */

    public TextAttribute(String labelName, String valueName) {
        super(labelName);

        this.value = new TextField(valueName);

        addValueNodeToPane();
    }

    /**
     * Constructs TextAttribute object, sets attribute's label name and value name; and sets the edibility of the value TextField
     * @param labelName Label of attribute
     * @param valueName Value of attribute
     * @param isEditable If true, value TextField is edible, if false, value TextField is inedible
     */

    public TextAttribute(String labelName, String valueName, boolean isEditable) {
        super(labelName);

        this.value = new TextField(valueName);
        setEditable(isEditable);

        addValueNodeToPane();
    }

    /**
     * Returns attribute's value
     * @return Attribute's value
     */

    @Override
    public String getValue() {
        return ((TextField)value).getText();
    }

    /**
     * Sets attribute's value and sets it in view
     * @param o Value to place in view
     */

    @Override
    public void setValue(Object o) {

        String temp = null;

        if (o instanceof String)
            temp = (String) o;
        else
            return;

        ((TextField)value).setText(temp);

    }

    /**
     * Sets the edibility of the value TextField
     * @param state If true, value TextField is edible, if false, value TextField is inedible
     */

    public void setEditable(boolean state) {
        ((TextField)this.value).setEditable(state);
    }
}

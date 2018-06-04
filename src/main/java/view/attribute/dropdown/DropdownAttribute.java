package view.attribute.dropdown;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import view.attribute.base.BaseAttribute;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a dropdown attribute, inherits from baseAttribute. Allows value selection via ComboBox, thus a dropdown
 */

public class DropdownAttribute extends BaseAttribute {

    private ComboBox<String> options;

    /**
     * Constructs a DropDownAttribute with the labelName as the label of the attribute
     * @param labelName Label for attribute
     */

    public DropdownAttribute (String labelName) {
        super(labelName);

        value = new GridPane();

        options = new ComboBox<>();

        ((GridPane)value).add(options, 1, 1);

        ((GridPane)value).setHgap(5);

        add(value, 1, 0);
    }

    /**
     * Add option to ComboBox/Dropdown
     * @param option Option to add
     */

    protected void addOption(String option) {
        this.options.getItems().add(option);
    }

    /**
     * Sets all options for ComboBox/Dropdown
     * @param options Options for ComboBox/Dropdown
     */

    public void setOptions(List<String> options) {
        this.options.getItems().clear();

        for (String o : options) {
            addOption(o);
        }
    }

    /**
     * Returns value of attribute
     * @return Value of attribute
     */

    @Override
    public String getValue() {
        return options.getValue();
    }

    /**
     * Sets the value
     * @param o Value to place in view
     */

    @Override
    public void setValue(Object o) {

        String temp = null;

        if (o instanceof String)
            temp = (String) o;
        else
            return;

        options.setValue(temp);

    }

    /**
     * Disables/enables ComboBox based on given parameter
     * @param value If true, enable ComboBox, if false, disable ComboBox
     */

    public void setInteract(boolean value) {
        options.setDisable(!value);
    }
}

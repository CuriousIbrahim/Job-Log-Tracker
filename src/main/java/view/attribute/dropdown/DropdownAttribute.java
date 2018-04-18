package view.attribute.dropdown;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import view.attribute.base.BaseAttribute;

import java.util.ArrayList;
import java.util.List;

public class DropdownAttribute extends BaseAttribute {

    private ComboBox<String> options;

    public DropdownAttribute (String labelName) {
        super(labelName);

        value = new GridPane();

        options = new ComboBox<>();

        ((GridPane)value).add(options, 1, 1);

        ((GridPane)value).setHgap(5);

        add(value, 1, 0);
    }

    protected void addOption(String option) {
        this.options.getItems().add(option);
    }

    protected void setOptions(List<String> options) {
        this.options.getItems().clear();

        for (String o : options) {
            addOption(o);
        }
    }

    @Override
    public String getValue() {
        return options.getValue();
    }

    public void setInteract(boolean value) {
        options.setDisable(value);
    }
}

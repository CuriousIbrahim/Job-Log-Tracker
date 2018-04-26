package view.attribute;

import javafx.scene.control.TextField;
import view.attribute.base.BaseAttribute;

public class TextAttribute extends BaseAttribute {


    public TextAttribute (String labelName) {
        super(labelName);

        this.value = new TextField();

        addValueNodeToPane();

    }

    public TextAttribute(String labelName, String valueName) {
        super(labelName);

        this.value = new TextField(valueName);

        addValueNodeToPane();
    }

    public TextAttribute(String labelName, String valueName, boolean isEditable) {
        super(labelName);

        this.value = new TextField(valueName);
        setEditable(isEditable);

        addValueNodeToPane();
    }

    @Override
    public String getValue() {
        return ((TextField)value).getText();
    }

    @Override
    public void setValue(Object o) {

        String temp = null;

        if (o instanceof String)
            temp = (String) o;
        else
            return;

        ((TextField)value).setText(temp);


    }

    public void setEditable(boolean state) {
        ((TextField)this.value).setEditable(state);
    }
}

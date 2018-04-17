package view.attribute.base;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public abstract class BaseAttribute extends GridPane {

    private Label label;
    protected Node value;

    public BaseAttribute(String labelValue) {
        super();

        setHgap(5);

        label = new Label(labelValue);

        add(label, 0, 0);
    }

    public void addValueNodeToPane() {
        add(value, 1, 0);
    }

    public abstract String getValue();

}

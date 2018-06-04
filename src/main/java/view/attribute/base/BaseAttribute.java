package view.attribute.base;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * The BaseAttribute class represents as the superclass for all attributes for views, in which the label is on the left
 * and a Node is on the right called the value, this value could be a ComboBox, TextField, anything that contains a value
 * for the label
 */

public abstract class BaseAttribute extends GridPane {

    private Label label;
    protected Node value;

    /**
     * Constructs a BaseAttribute object with the labelValue which is set at the left most position in the GridPane
     * @param labelValue Value of attribute
     */

    public BaseAttribute(String labelValue) {
        super();

        setHgap(5);

        label = new Label(labelValue);

        add(label, 0, 0);
    }

    /**
     * Adds value Node to GridPane
     */

    public void addValueNodeToPane() {
        add(value, 1, 0);
    }

    /**
     * Abstract method for returning value
     * @return The value for the attribute
     */

    public abstract Object getValue();

    /**
     * Abstract method to set the value in the Node
     * @param o Value to place in view
     */

    public abstract void setValue(Object o);




}

package view.attribute.special;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
import java.util.List;

/**
 * Represents a JobStatusAttribute, does NOT inherit BaseAttribute, allows the input for the status through a ComboBox and the date of
 * the status through a DatePicker
 */

public class JobStatusAttribute extends GridPane {

    private static int MAIN_ID = 0;

    private int id;
    private Button x;
    private ComboBox<String> options;
    private DatePicker datePicker;

    /**
     * Constructs a JobStatusAttribute object with the given parameter. Sets the options in the ComboBox
     * @param options Options to be viewed in ComboBox
     */

    public JobStatusAttribute (List<String> options) {
        this();
        setOptions(options);
    }

    /**
     * Constructs a JobStatusAttribute object with the given parameter. Sets the options in the ComboBox. Sets the
     * status in ComboBox as optionValue and sets the date in the DatePicker box as optionDate
     * @param options Options to be viewed in ComboBox
     * @param optionValue Status value to be viewed in ComboBox by defualt
     * @param optionDate Status date to be viewed in DatePicker by default
     */

    public JobStatusAttribute(List<String> options, String optionValue, LocalDate optionDate) {
        this(options);


        this.options.setValue(optionValue);
        this.datePicker.setValue(optionDate);

    }

    /**
     * Default constructor for constructing a JobStatusAttribute object. Takes care of the placing and position of each
     * node, as well as the spacing between nodes
     */

    public JobStatusAttribute() {
        id = MAIN_ID++;
        x = new Button("X");
        options = new ComboBox<>();
        datePicker = new DatePicker(LocalDate.now());

        add(x, 0, 0);
        add(options, 1, 0);
        add(datePicker, 2, 0);

        setHgap(5);

    }

    /**
     * Add option to CombBox selection
     * @param option Option to be added and viewed in ComboBox selection
     */

    public void addOption (String option) {
        this.options.getItems().add(option);
    }

    /**
     * Sets options for ComboBox selections
     * @param options Options to be set and viewed in ComboBox selection
     */

    public void setOptions(List<String> options) {
        for (String option : options)
            addOption(option);
    }

    /**
     * Set values for status and Status's date
     * @param valueOption Job status value
     * @param valueDate Job status date
     */

    public void setValues(String valueOption, LocalDate valueDate) {
        this.options.setValue(valueOption);
        this.datePicker.setValue(valueDate);
    }

    /**
     * Returns job status
     * @return Job status
     */

    public String getStatus() {
        return options.getValue();
    }

    /**
     * Returns the job status' date
     * @return Job status's date
     */

    public LocalDate getDate() {
        return datePicker.getValue();
    }

    /**
     * Returns id of this JobStatusAttribute
     * @return Id of this JobStatusAttribute
     */

    public int getUniqueId() {
        return id;
    }

    /**
     * Returns the X button, the X button is in charge of removing a job status input attribute
     * @return X Button
     */

    public Button getXButton() {
        return x;
    }
}

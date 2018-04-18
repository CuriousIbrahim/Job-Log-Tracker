package view.attribute.special;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.GridPane;

import java.time.LocalDate;
import java.util.List;

public class JobStatusAttribute extends GridPane {

    private static int MAIN_ID = 0;

    private int id;
    private Button x;
    private ComboBox<String> options;
    private DatePicker datePicker;

    public JobStatusAttribute (List<String> options) {
        this();
        setOptions(options);
    }

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

    public void addOption (String option) {
        this.options.getItems().add(option);
    }

    public void setOptions(List<String> options) {
        for (String option : options)
            addOption(option);
    }

    public String getStatus() {
        return options.getValue();
    }

    public LocalDate getDate() {
        return datePicker.getValue();
    }

    public int getUniqueId() {
        return id;
    }

    public Button getXButton() {
        return x;
    }
}

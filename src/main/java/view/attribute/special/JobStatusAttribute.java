package view.attribute.special;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.GridPane;

public class JobStatusAttribute extends GridPane {

    private static int MAIN_ID = 0;

    private int id;
    private Button x;
    private ComboBox<String> options;
    private DatePicker datePicker;

    public JobStatusAttribute() {
        x = new Button("X");
        options = new ComboBox<>();
        datePicker = new DatePicker();

        add(x, 0, 0);
        add(options, 1, 0);
        add(datePicker, 2, 0);

    }

    public int getUniqueId() {
        return id;
    }

    public Button getXButton() {
        return x;
    }
}

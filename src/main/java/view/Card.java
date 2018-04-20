package view;

import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Card extends GridPane {

    private int jobId;

    public Card(int jobID, String jobTitle, String jobType, String company, String currentStatus) {

        this.jobId = jobID;

        add(new Label(jobTitle + " - " + jobType), 0, 0);
        add(new Label(company), 0, 1);
        add(new Label(currentStatus), 0, 2);

        setVgap(5);

        setBorder(new Border(
                new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)
        ));

    }
}

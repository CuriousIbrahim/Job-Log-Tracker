package view;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class AllJobViewer extends Stage {

    private static final int MAX_COLUMN_COUNT = 4;

    private int column_count = 0;
    private int row_count= 0;

    private Button addNewJob;

    private GridPane allCards;
    private List<Card> allJobs;

    private GridPane mainPane;

    public AllJobViewer() {

        mainPane = new GridPane();

        addNewJob = new Button("Add Job");

        allCards = new GridPane();
        allJobs = new ArrayList<>();

        allCards.setHgap(25);
        allCards.setVgap(25);

        allCards.setPadding(new Insets(10));

        System.out.println(allCards.getPadding());


        allCards.setBorder(new Border(
                new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)
        ));


        HBox buttonBox = new HBox(addNewJob);
        buttonBox.setAlignment(Pos.TOP_LEFT);

        mainPane.add(buttonBox, 0, 0, 10, 1);
        mainPane.add(allCards, 0, 1, 10, 8);

        allCards.setMinSize(700, 700);

        mainPane.setVgap(10);
        mainPane.setPadding(new Insets(15));

        Scene scene = new Scene(mainPane);

        setScene(scene);

    }

    private void addCard(Card card) {

        if (column_count > MAX_COLUMN_COUNT) {
            column_count = 0;
            row_count++;
        }

        this.allJobs.add(card);

        System.out.println("column:" + column_count + " row:" + row_count);

        allCards.add(card, column_count++, row_count);

    }

    public void addJob(int jobId, String jobTitle, String jobType, String company, String currentStatus, EventHandler<MouseEvent> event) {
        Card card = new Card(
                jobId, jobTitle, jobType, company, currentStatus
        );

        card.setOnMouseClicked(event);

        addCard(card);
    }

    public Button getAddNewJobBtn() {
        return addNewJob;
    }

    public void clearCards () {

        allCards.getChildren().clear();

        column_count = 0;
        row_count = 0;

    }
}

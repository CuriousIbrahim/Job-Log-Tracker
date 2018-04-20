package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
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

    public AllJobViewer() {
        allCards = new GridPane();
        allJobs = new ArrayList<>();
    }

    public AllJobViewer(List<Integer> jobId, List<String> jobTitle, List<String> jobType, List<String> company,
                        List<String> currentStatus) {


        this();

        for (int i = 0; i < jobId.size(); i++) {

            Card card = new Card(
                    jobId.get(i), jobTitle.get(i), jobType.get(i), company.get(i), currentStatus.get(i)
            );

            addCard(card);

        }

        allCards.setHgap(10);
        allCards.setVgap(10);

        allCards.setBorder(new Border(
                new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)
        ));

    }

    private void addCard(Card card) {

        if (column_count > MAX_COLUMN_COUNT)
            column_count = 0;

        this.allJobs.add(card);

        allCards.add(card, column_count++, row_count++);

    }

    public void addJob(int jobId, String jobTitle, String jobType, String company, String currentStatus) {
        Card card = new Card(
                jobId, jobTitle, jobType, company, currentStatus
        );

        addCard(card);
    }

    public void render() {
        Scene scene = new Scene(allCards);

        setScene(scene);
    }


}

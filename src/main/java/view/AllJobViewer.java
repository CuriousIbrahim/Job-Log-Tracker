package view;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class AllJobViewer extends GridPane {

    private static final int MAX_COLUMN_COUNT = 4;

    private int column_count = 0;
    private int row_count= 0;

    private Button addNewJob;

    private GridPane allCards;
    private List<Card> allJobs;

    public AllJobViewer(List<Integer> jobId, List<String> jobTitle, List<String> jobType, List<String> company,
                        List<String> currentStatus) {


        allCards = new GridPane();
        allJobs = new ArrayList<>();




    }

    private void addCard(Card card) {

        if (column_count > MAX_COLUMN_COUNT)
            column_count = 0;

        this.allJobs.add(card);

        allCards.add(card, column_count++, row_count++);

    }


}

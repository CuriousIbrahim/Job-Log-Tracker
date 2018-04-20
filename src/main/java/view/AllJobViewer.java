package view;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;

public class AllJobViewer extends GridPane {

    private Button addNewJob;

    private GridPane allCards;
    private List<Card> allJobs;

    public AllJobViewer(List<Integer> jobId, List<String> jobTitle, List<String> jobType, List<String> company,
                        List<String> currentStatus) {


        allCards = new GridPane();
        allJobs = new ArrayList<>();




    }

}

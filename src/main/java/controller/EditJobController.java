package controller;

import db.JobDatabase;
import db.dao.JobDAO;
import javafx.event.ActionEvent;
import model.Job;
import view.JobWindow;

import java.sql.SQLException;

import static controller.GetJobFromViewController.getJobFromView;

public class EditJobController {

    private JobDAO jobDB;

    public EditJobController(JobWindow window, Job before) {

        try {

            jobDB = new JobDatabase();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        window.getButton().addEventHandler(ActionEvent.ACTION, (e) -> {

            Job after = getJobFromView(window);


            if (!before.equals(after)) {

                try {
                    // FIXME: Update functionality rarely works, says the database file is locked
                    jobDB.update(before.getId(), after);
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }

                window.close();

            }
        });

    }
}

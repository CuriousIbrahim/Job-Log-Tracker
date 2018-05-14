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

                int count = 0;

                while (count > 3) {
                    try {
                        jobDB.update(before.getId(), after);
                        break;
                    } catch (SQLException ex) {
                        ex.printStackTrace(System.out);
                        count++;
                    }
                }

                window.close();

            }
        });

    }
}

package controller;

import db.JobDatabase;
import db.dao.JobDAO;
import javafx.event.ActionEvent;
import model.*;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import util.Time;
import view.JobWindow;
import view.attribute.special.JobStatusAttribute;
import view.attribute.special.OtherFileAttribute;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static controller.GetJobFromViewController.getJobFromView;

public class AddJobController {

    private JobDAO jobDB;

    public AddJobController(JobWindow window) throws SQLException {

        jobDB = new JobDatabase();

        window.getButton().addEventHandler(ActionEvent.ACTION, (event) -> {


            try {
                jobDB.insert(getJobFromView(window));
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }

            window.close();


        });

    }



}

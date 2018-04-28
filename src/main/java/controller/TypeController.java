package controller;

import db.JobTypeDatabase;
import db.dao.TypeDAO;
import view.JobWindow;

import java.sql.SQLException;

public class TypeController {

    private TypeDAO typeDB;

    public TypeController(JobWindow view) throws SQLException {

        typeDB = new JobTypeDatabase();

        typeDB.clear();

        view.setTypes(typeDB.all());

    }
}

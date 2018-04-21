package controller;

import db.JobTypeDatabase;
import db.dao.TypeDAO;
import view.InsertJobWindow;

import java.sql.SQLException;

public class TypeController {

    private TypeDAO typeDB;

    public TypeController(InsertJobWindow view) throws SQLException {

        typeDB = new JobTypeDatabase();

        typeDB.clear();

        view.setTypes(typeDB.all());

    }
}

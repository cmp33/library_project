package com.cesi.database.db;

import com.cesi.database.controllers.*;
import com.cesi.library_project.database.controllers.*;

import java.sql.SQLException;

public class DatabaseController {
    private static DatabaseController DATABASE = new DatabaseController();
    private LibraryDatabase mDatabase;

    final static AbstractController[] CONTROLLERS = new AbstractController[] {
            MetaDataController.getInstance(),
            CategoryController.getInstance(),
            FilmController.getInstance(),
            MusicController.getInstance()
    };

    public static DatabaseController getInstance() {
        return DATABASE;
    }

    private DatabaseController() {

    }

    public void open() {
        try {
            mDatabase = new LibraryDatabase();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        open();

        //call every controller init();
        for (AbstractController controller : CONTROLLERS) {
            controller.init(mDatabase);
        }
    }
}

package com.cesi.lighter_custom.database.db;

import com.cesi.lighter_custom.database.controllers.ModelController;
import za.co.neilson.sqlite.orm.*;
import za.co.neilson.sqlite.orm.jdbc.JdbcObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcSqliteDatabaseDriverInterface;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class ProjectLibraryDatabase extends DatabaseModel<ResultSet, HashMap<String, Object>> {
    public ProjectLibraryDatabase() throws NoSuchFieldException, SQLException, ClassNotFoundException {
        super((Object[]) null);
    }

    @Override
    public ObjectModel<DatabaseInfo, ResultSet, HashMap<String, Object>> onCreateDatabaseInfoModel() throws ClassNotFoundException, NoSuchFieldException {
        return new JdbcObjectModel<DatabaseInfo>(this) {
            //abstract class
        };
    }

    @Override
    protected DatabaseDriverInterface<ResultSet, HashMap<String, Object>> onInitializeDatabaseDriverInterface(Object... objects) {
        return new JdbcSqliteDatabaseDriverInterface(this);
    }

    @Override
    public String getDatabaseName() {
        return "library2.db";
    }

    @Override
    public int getDatabaseVersion() {
        return 0;
    }

    @Override
    protected void onInsertDefaultValues() {

    }

    @Override
    protected void onRegisterObjectModels(HashMap<Type, ObjectModel<?, ResultSet, HashMap<String, Object>>> hashMap) throws ClassNotFoundException, NoSuchFieldException {
        for (ModelController controller : ProjectDatabase.getControllers()) {
            controller.initModelForDatabase(hashMap, this);
        }
    }
}

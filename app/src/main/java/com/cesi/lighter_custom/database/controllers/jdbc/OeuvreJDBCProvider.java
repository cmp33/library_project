package com.cesi.lighter_custom.database.controllers.jdbc;

import com.cesi.lighter_custom.database.controllers.AbstractModelJDBCProvider;
import com.cesi.lighter_custom.database.db.ProjectLibraryDatabase;
import com.cesi.lighter_custom.database.models.Oeuvre;
import za.co.neilson.sqlite.orm.ObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcObjectModel;

import java.sql.ResultSet;
import java.util.HashMap;

public class OeuvreJDBCProvider extends AbstractModelJDBCProvider<Oeuvre> {

    @Override
    public ObjectModel<Oeuvre, ResultSet, HashMap<String, Object>> createJDBCObject(ProjectLibraryDatabase instance) throws NoSuchFieldException, ClassNotFoundException {
        return new JdbcObjectModel<Oeuvre>(instance) {
        };
    }
}

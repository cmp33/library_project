package com.cesi.lighter_custom.database.controllers.jdbc;

import com.cesi.lighter_custom.database.controllers.AbstractModelJDBCProvider;
import com.cesi.lighter_custom.database.db.ProjectLibraryDatabase;
import com.cesi.lighter_custom.database.models.Category;
import za.co.neilson.sqlite.orm.ObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcObjectModel;

import java.sql.ResultSet;
import java.util.HashMap;

public class CategoryJDBCProvider extends AbstractModelJDBCProvider<Category> {

    @Override
    public ObjectModel<Category, ResultSet, HashMap<String, Object>> createJDBCObject(ProjectLibraryDatabase instance) throws NoSuchFieldException, ClassNotFoundException {
        return new JdbcObjectModel<Category>(instance) {
        };
    }
}

package com.cesi.database.controllers;

import com.cesi.database.db.LibraryDatabase;
import com.cesi.database.models.MetaData;
import com.sun.istack.internal.NotNull;
import za.co.neilson.sqlite.orm.ObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcObjectModel;

import java.sql.ResultSet;
import java.util.HashMap;

public class MetaDataController extends AbstractController<MetaData> {
    private static final MetaDataController CONTROLLER = new MetaDataController();

    public static MetaDataController getInstance() {
        return CONTROLLER;
    }

    private MetaDataController() {
        super();
    }

    @NotNull
    @Override
    protected Class<MetaData> getModelClass() {
        return MetaData.class;
    }

    @Override
    protected ObjectModel<MetaData, ResultSet, HashMap<String, Object>> createJDBCObject(LibraryDatabase instance) throws NoSuchFieldException, ClassNotFoundException {
        return new JdbcObjectModel<MetaData>(instance) {
        };
    }
}

package com.cesi.lighter_custom.database.controllers;

import com.cesi.lighter_custom.database.db.ProjectLibraryDatabase;
import com.cesi.lighter_custom.database.models.Model;
import za.co.neilson.sqlite.orm.ObjectModel;

import java.sql.ResultSet;
import java.util.HashMap;

public abstract class AbstractModelJDBCProvider<MODEL_CLASS extends Model> {

    public abstract ObjectModel<MODEL_CLASS, ResultSet, HashMap<String, Object>> createJDBCObject(ProjectLibraryDatabase instance) throws NoSuchFieldException, ClassNotFoundException;
}

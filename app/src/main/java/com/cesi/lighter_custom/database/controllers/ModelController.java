package com.cesi.lighter_custom.database.controllers;

import com.cesi.lighter_custom.database.db.ProjectDatabase;
import com.cesi.lighter_custom.database.db.ProjectLibraryDatabase;
import com.cesi.lighter_custom.database.models.Model;
import za.co.neilson.sqlite.orm.ObjectModel;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Simple class to manage a given "MODEL_CLASS" > CRUD
 *
 * @param <MODEL_CLASS> the class which will parameterized the ModelController instance
 */
public class ModelController<MODEL_CLASS extends Model> {

    private Class<MODEL_CLASS> klass;
    private ObjectModel<MODEL_CLASS, ResultSet, HashMap<String, Object>> provider;

    private ModelController() {
    }

    public ModelController(Class<MODEL_CLASS> klass) {
        this();

        this.klass = klass;
    }

    public MODEL_CLASS create(MODEL_CLASS item_to_create_in_db) {
        try {
            long id = provider.insert(item_to_create_in_db);
            item_to_create_in_db.setId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item_to_create_in_db;
    }

    public MODEL_CLASS read(long id) {
        try {
            List<MODEL_CLASS> list = provider.getAll();
            for (MODEL_CLASS object : list) {
                if (null != object && object.getId() == id) return object;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<MODEL_CLASS> read() {
        try {
            return provider.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public MODEL_CLASS update(MODEL_CLASS model) {
        try {
            provider.update(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return model;
    }

    public void delete(MODEL_CLASS model) {
        try {
            provider.delete(model);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void initModelForDatabase(HashMap<Type, ObjectModel<?, ResultSet, HashMap<String, Object>>> objectModels, ProjectLibraryDatabase instance) throws NoSuchFieldException, ClassNotFoundException {
        provider = ProjectDatabase.getJDBCObjectProvider(klass).createJDBCObject(instance);
        objectModels.put(klass, provider);
    }

    public void init(ProjectLibraryDatabase database) {
        provider = database.getObjectModel(klass);
    }

}

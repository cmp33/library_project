package com.cesi.database.controllers;

import com.cesi.database.db.LibraryDatabase;
import com.cesi.database.models.Category;
import com.sun.istack.internal.NotNull;
import za.co.neilson.sqlite.orm.ObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcObjectModel;

import java.sql.ResultSet;
import java.util.HashMap;

public class CategoryController extends AbstractController<Category> {
    private static final CategoryController CATEGORY_CONTROLLER = new CategoryController();

    public static CategoryController getInstance() {
        return CATEGORY_CONTROLLER;
    }

    private CategoryController() {
        super();
    }

    @NotNull
    @Override
    protected Class<Category> getModelClass() {
        return Category.class;
    }

    @Override
    protected ObjectModel<Category, ResultSet, HashMap<String, Object>> createJDBCObject(LibraryDatabase instance) throws NoSuchFieldException, ClassNotFoundException {
        return new JdbcObjectModel<Category>(instance) {
        };
    }

}

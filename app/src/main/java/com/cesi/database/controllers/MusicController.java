package com.cesi.database.controllers;

import com.cesi.database.db.LibraryDatabase;
import com.cesi.database.models.Music;
import com.sun.istack.internal.NotNull;
import za.co.neilson.sqlite.orm.ObjectModel;
import za.co.neilson.sqlite.orm.jdbc.JdbcObjectModel;

import java.sql.ResultSet;
import java.util.HashMap;

public class MusicController extends AbstractController<Music> {
    private static final MusicController CATEGORY_CONTROLLER = new MusicController();

    public static MusicController getInstance() {
        return CATEGORY_CONTROLLER;
    }

    private MusicController() {
        super();
    }

    @NotNull
    @Override
    protected Class<Music> getModelClass() {
        return Music.class;
    }

    @Override
    protected ObjectModel<Music, ResultSet, HashMap<String, Object>> createJDBCObject(LibraryDatabase instance) throws NoSuchFieldException, ClassNotFoundException {
        return new JdbcObjectModel<Music>(instance) {
        };
    }
}

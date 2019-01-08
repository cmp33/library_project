package com.cesi.customprojet.database.db.database.controllers;

import java.util.List;

public class ModelController<MODEL_CLASS> {

    private Class<MODEL_CLASS> klass;

    public ModelController() {
    }

    public ModelController(Class<MODEL_CLASS> klass) {
        this();
        this.klass = klass;

    }

    public MODEL_CLASS create(){
        return null;
    }

    public MODEL_CLASS read(long id) {
        return null;
    }

    public List<MODEL_CLASS> read(){
        return null;
    }

    public void update(MODEL_CLASS model){

    }

    public void delete(MODEL_CLASS model){

    }
}

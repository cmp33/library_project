package com.cesi.customprojet.database.db;

import com.cesi.customprojet.database.db.database.controllers.ModelController;
import com.cesi.database.customModel.Categorie;
import com.cesi.database.customModel.Oeuvre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProjectDatabase {

    private static final HashMap<Class, ModelController> controllers = new HashMap<>();

    public ProjectDatabase() {
    }
    private static void set(Class klass){
        controllers.put(klass, new ModelController<>(klass));
    }

    public <MODEL_CLASS>ModelController<MODEL_CLASS> get(Class<MODEL_CLASS> klass){
        return controllers.get(klass);
    }

    public static void init(){
        set(Categorie.class);
        set(Oeuvre.class);
    }

    public List<ModelController> getControllers(){
        List<ModelController> tmp = new ArrayList<>();
    }
}

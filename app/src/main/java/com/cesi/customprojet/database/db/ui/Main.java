package com.cesi.customprojet.database.db.ui;

import com.cesi.customprojet.database.db.database.controllers.ModelController;
import com.cesi.database.customModel.Categorie;
import com.cesi.database.customModel.Oeuvre;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ModelController<Categorie> controllerCategorie = new ModelController<>(Categorie.class);
        ModelController<Oeuvre> controllerOeuvre = new ModelController<>(Oeuvre.class);

        Categorie categorie = controllerCategorie.create();
        categorie.setCat_categorie("test");

        controllerCategorie.update(categorie);

        List<Categorie> categories = controllerCategorie.read();

        Oeuvre oeuvre = controllerOeuvre.create();
    }
}
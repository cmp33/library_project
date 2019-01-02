package com.cesi.library_project.database.customModel;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Categorie {
    @PrimaryKey(autoIncrement = true)
    private long cat_id;

    private String cat_categorie;

    public Categorie(String cat_categorie)
    {
        this.cat_categorie = cat_categorie;



    }
}


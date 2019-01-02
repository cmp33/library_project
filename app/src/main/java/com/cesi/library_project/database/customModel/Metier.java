package com.cesi.library_project.database.customModel;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Metier {
    @PrimaryKey(autoIncrement = true)
    private long met_id;

    private String metier;

    public Metier(String metier)
    {
        this.metier = metier;



    }
}


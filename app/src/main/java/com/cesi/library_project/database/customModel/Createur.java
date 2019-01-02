package com.cesi.library_project.database.customModel;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Createur {
    @PrimaryKey(autoIncrement = true)
    private long c_id;

    private String c_nom;

    private String c_prenom;

    public Createur(String c_nom, String c_prenom)
    {
        this.c_nom = c_nom;
        this.c_prenom = c_prenom;



    }
}


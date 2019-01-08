package com.cesi.lighter_custom.database.models;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.util.Date;

public class Oeuvre implements Model {
    
    @PrimaryKey(autoIncrement = true)
    public long id;

    public String titre;

    public Date date_creation;

    public Date date_ajout;

    public boolean etat;

    public String origine;

    public Oeuvre() {
    }

    public Oeuvre(String titre, Date date_creation, Date date_ajout, boolean etat, String origine) {
        this.titre = titre;
        this.date_creation = date_creation;
        this.date_ajout = date_ajout;
        this.etat = etat;
        this.origine = origine;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
}

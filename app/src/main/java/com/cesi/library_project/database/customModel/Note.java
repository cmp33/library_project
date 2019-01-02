package com.cesi.library_project.database.customModel;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Note {
    @PrimaryKey(autoIncrement = true)
    private long n_id;

    private int n_note;

    private String n_commentaire;

    public Note(int n_note, String n_commentaire)
    {
        this.n_note = n_note;
        this.n_commentaire = n_commentaire;



    }
}


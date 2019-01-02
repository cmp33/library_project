package com.cesi.library_project.database.customModel;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Genre {
    @PrimaryKey(autoIncrement = true)
    private long g_id;

    private String g_genre;

    private String g_sous_genre;

    public Genre(String g_genre, String g_sous_genre)
    {
        this.g_genre = g_genre;
        this.g_sous_genre = g_sous_genre;



    }
}


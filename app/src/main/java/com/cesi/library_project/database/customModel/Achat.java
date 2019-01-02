package com.cesi.library_project.database.customModel;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Achat {
    @PrimaryKey(autoIncrement = true)
    private long a_id;

    private int a_date_acquis;

    private String a_origine;

    public Achat(int a_date_acquis, String a_origine)
    {
        this.a_date_acquis = a_date_acquis;
        this.a_origine = a_origine;


    }
}


package com.cesi.library_project.database.customModel;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Support {
    @PrimaryKey(autoIncrement = true)
    private long sup_id;

    private String sup_support;

    public Support(String sup_support)
    {
        this.sup_support = sup_support;



    }
}

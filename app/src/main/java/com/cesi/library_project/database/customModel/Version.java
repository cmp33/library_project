package com.cesi.library_project.database.customModel;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Version {
    @PrimaryKey(autoIncrement = true)
    private long v_id;

    private String v_langue;

    public Version(String v_langue)
    {
        this.v_langue = v_langue;



    }
}


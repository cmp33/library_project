package com.cesi.library_project.database.customModel;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Status
{
    @PrimaryKey(autoIncrement = true)
    private long s_id;

    private boolean s_terminer;

    public Status(boolean s_terminer)
    {
        this.s_terminer = s_terminer;



    }
}


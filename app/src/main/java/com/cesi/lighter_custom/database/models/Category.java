package com.cesi.lighter_custom.database.models;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Category implements Model {

    @PrimaryKey(autoIncrement = true)
    public long id;

    public String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
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

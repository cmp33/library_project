package com.cesi.lighter_custom.database.models;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

/**
 * This interface is used to help the ModelController to be used with this to set or get the id of any model
 */
public interface Model {

    long getId();

    void setId(long id);
}

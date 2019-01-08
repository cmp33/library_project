package com.cesi.database.controllers;

import com.cesi.database.db.LibraryDatabase;

import java.util.List;

public interface ICRUD<A_MODEL_CLASS> {

    /**
     * Init the current Controller
     * Mandatory to call it after the database initialisation
     *
     * @param database
     */
    void init(LibraryDatabase database);

    /**
     * Create a specific instance in the database
     *
     * @param model the model to save in the database
     */
    void create(A_MODEL_CLASS model);

    /**
     * Retrieve every object models from the dabase
     *
     * @return a non null list
     */
    List<A_MODEL_CLASS> list();

    /**
     * Update the given model into the database
     *
     * @param model the model to update
     */
    void update(A_MODEL_CLASS model);

    /**
     * Delete a given model from the database
     *
     * @param model the existing model
     */
    void delete(A_MODEL_CLASS model);

}

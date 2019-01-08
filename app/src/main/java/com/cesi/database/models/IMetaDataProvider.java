package com.cesi.database.models;

import com.sun.istack.internal.NotNull;

public interface IMetaDataProvider {

    /**
     * Return the current meta data information about
     * a given class
     *
     * @return a not null meta data
     */
    @NotNull
    MetaData getMetaData();

    /**
     * Set the current meta data information
     * This method should ensure to update the long (foreign key)
     *
     * @param meta_data
     */
    void setMetaData(@NotNull MetaData meta_data);
}

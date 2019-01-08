package com.cesi.database.models;

import com.cesi.database.controllers.MetaDataController;
import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Music implements IMetaDataProvider, IIdSetter {

    @PrimaryKey(autoIncrement = true)
    private long id;

    private long duration;

    @ForeignKey(table = "MetaData", column = "meta_data_id", childReference = "meta_data")
    private long meta_data_id;

    private MetaData meta_data;

    public Music() {

    }

    public Music(long duration, MetaData meta_data) {
        setDuration(duration);
        setMetaData(meta_data);
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public Object[] toArray() {
        Object[] metadata = meta_data.toArray();
        Object[] final_object = new Object[metadata.length + 1];
        int i = 0;
        for (Object object : metadata) {
            final_object[i++] = object;
        }
        final_object[final_object.length - 1] = duration;
        return final_object;
    }

    @Override
    public String[] getColumnNames() {
        String[] metadata = meta_data.getColumnNames();
        String[] final_object = new String[metadata.length + 1];
        int i = 0;
        for (String object : metadata) {
            final_object[i++] = object;
        }
        final_object[final_object.length - 1] = "duration";
        return final_object;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public MetaData getMetaData() {
        return MetaDataController.getInstance().findById(meta_data_id);//meta_data;
    }

    @Override
    public void setMetaData(MetaData meta_data) {
        this.meta_data_id = meta_data.getId();
        this.meta_data = meta_data;
    }

    @Override
    public String toString() {
        return "Music " + id + " " + duration + " " + meta_data_id + " // " + getMetaData().toString();
    }
}

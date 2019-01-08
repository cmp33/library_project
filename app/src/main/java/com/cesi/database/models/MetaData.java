package com.cesi.database.models;


import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

import java.util.Date;

public class MetaData implements IIdSetter {

    @PrimaryKey(autoIncrement = true)
    private long meta_data_id;

    private String title;

    private int note;

    private String origin;

    private Date release;

    private String commentaire;

    private String status;

    public MetaData() {

    }

    public MetaData(String title,
            /*la note*/int note,
                    String origin,
                    Date release,
                    String commentaire,
                    Status status) {
        setTitle(title);
        setNote(note);
        setOrigin(origin);
        setRelease(release);
        setCommentaire(commentaire);
        setStatus(status);
    }

    @Override
    public long getId() {
        return meta_data_id;
    }

    @Override
    public Object[] toArray() {
        return new Object[]{
                getTitle(),
                getNote(),
                getOrigin(),
                getRelease(),
                getCommentaire(),
                getStatus()
        };
    }

    @Override
    public String[] getColumnNames() {
        return new String[]{
                "title",
                "Note",
                "Origin",
                "Release",
                "Commentaire",
                "Status"
        };
    }

    @Override
    public void setId(long id) {
        this.meta_data_id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Status getStatus() {
        try {
            return Status.valueOf(status);
        } catch (Exception e){
            return Status.INVALID;
        }
    }

    public void setStatus(Status status) {
        this.status = status.name();
    }

    @Override
    public String toString() {
        return meta_data_id + " " + getTitle() + " " + getCommentaire();
    }
}

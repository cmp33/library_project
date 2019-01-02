package com.cesi.library_project.database.customModel;

import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Morceau {
    @PrimaryKey(autoIncrement = true)
    private long m_id;

    private String m_titre_music;

    public Morceau(String m_titre_musictitre)
    {
        this.m_titre_music = m_titre_musictitre;



    }

}

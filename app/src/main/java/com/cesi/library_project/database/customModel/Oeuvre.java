package com.cesi.library_project.database.customModel;


import za.co.neilson.sqlite.orm.annotations.ForeignKey;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Oeuvre {
    @PrimaryKey(autoIncrement = true)
    private long o_id;

    private String o_titre;

    private  int o_duree;

    private long o_ref;

    private int o_date_creation;

    private String o_edition;

    private String o_studio;

    private long o_nb_page;

    private long o_isbn;

    @ForeignKey(table = "Status", column = "s_id")
    private long s_id;
    @ForeignKey(table = "Achat", column = "a_id")
    private long a_id;
    @ForeignKey(table = "Note", column = "n_id")
    private long n_id;

    public Oeuvre(String o_titre, int o_duree, long o_ref, int o_date_de_creation, String o_edition, String o_studio, long o_nb_page, long o_isbn)
    {
        this.o_titre = o_titre;
        this.o_duree = o_duree;
        this.o_ref = o_ref;
        this.o_date_creation = o_date_de_creation;
        this.o_edition = o_edition;
        this.o_studio = o_studio;
        this.o_nb_page = o_nb_page;
        this.o_isbn = o_isbn;


    }

}

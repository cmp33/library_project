package com.cesi.lighter_custom.database.db;

import com.cesi.lighter_custom.database.controllers.AbstractModelJDBCProvider;
import com.cesi.lighter_custom.database.controllers.ModelController;
import com.cesi.lighter_custom.database.controllers.jdbc.CategoryJDBCProvider;
import com.cesi.lighter_custom.database.controllers.jdbc.OeuvreJDBCProvider;
import com.cesi.lighter_custom.database.models.Category;
import com.cesi.lighter_custom.database.models.Model;
import com.cesi.lighter_custom.database.models.Oeuvre;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProjectDatabase extends InternalProjectDatabase {



    private ProjectLibraryDatabase DATABASE;

    private ProjectDatabase() {
        super();

    }


    public void init() {
        set(Category.class, new CategoryJDBCProvider());
        set(Oeuvre.class, new OeuvreJDBCProvider());
        //set(OeuvreCategory.class, new OeuvreCategoryJDBCProvider());

        open();
    }


}

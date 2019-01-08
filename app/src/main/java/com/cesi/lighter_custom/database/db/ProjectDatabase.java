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

public class ProjectDatabase {

    private static final HashMap<Class, ModelController> CONTROLLERS = new HashMap<>();
    private static final HashMap<Class, AbstractModelJDBCProvider> JDBC_PROVIDER_CONTROLLERS = new HashMap<>();

    private static ProjectLibraryDatabase DATABASE;

    private ProjectDatabase() {

    }

    private static void set(Class klass, AbstractModelJDBCProvider provider) {
        CONTROLLERS.put(klass, new ModelController<>(klass));
        JDBC_PROVIDER_CONTROLLERS.put(klass, provider);
    }

    public static <MODEL_CLASS extends Model> ModelController<MODEL_CLASS> get(Class<MODEL_CLASS> klass) {
        return CONTROLLERS.get(klass);
    }

    public static <MODEL_CLASS extends Model> AbstractModelJDBCProvider getJDBCObjectProvider(Class<MODEL_CLASS> klass) {
        return JDBC_PROVIDER_CONTROLLERS.get(klass);
    }

    private static void open() {
        try {
            DATABASE = new ProjectLibraryDatabase();
        } catch (NoSuchFieldException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void init() {
        set(Category.class, new CategoryJDBCProvider());
        set(Oeuvre.class, new OeuvreJDBCProvider());
        //set(OeuvreCategory.class, new OeuvreCategoryJDBCProvider());

        open();
    }

    public static List<ModelController> getControllers() {
        return new ArrayList<>(CONTROLLERS.values());
    }
}

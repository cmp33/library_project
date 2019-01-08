package com.cesi.lighter_custom.database.db;

import com.cesi.lighter_custom.database.controllers.AbstractModelJDBCProvider;
import com.cesi.lighter_custom.database.controllers.ModelController;

import com.cesi.lighter_custom.database.models.Model;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class InternalProjectDatabase {

    private final HashMap<Class, ModelController> CONTROLLERS = new HashMap<>();
    private final HashMap<Class, AbstractModelJDBCProvider> JDBC_PROVIDER_CONTROLLERS = new HashMap<>();

    private ProjectLibraryDatabase DATABASE;

    protected InternalProjectDatabase() {

    }
    protected void set(Class klass, AbstractModelJDBCProvider provider) {
        CONTROLLERS.put(klass, new ModelController<>(this, klass));
        JDBC_PROVIDER_CONTROLLERS.put(klass, provider);
    }

    public <MODEL_CLASS extends Model> ModelController<MODEL_CLASS> get(Class<MODEL_CLASS> klass) {
        return CONTROLLERS.get(klass);
    }

    public <MODEL_CLASS extends Model> AbstractModelJDBCProvider getJDBCObjectProvider(Class<MODEL_CLASS> klass) {
        return JDBC_PROVIDER_CONTROLLERS.get(klass);
    }

    protected void open() {
        try {
            //temporary to fix issue with availability
            ProjectLibraryDatabase.parent = this;
            DATABASE = new ProjectLibraryDatabase();
        } catch (NoSuchFieldException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public abstract void init();

    public List<ModelController> getControllers() {
        return new ArrayList<>(CONTROLLERS.values());
    }
}

package com.cesi.providers;

import com.cesi.database.controllers.AbstractController;
import com.cesi.database.models.IIdSetter;
import com.cesi.providers.ui.AbstractComponentProvider;

import java.util.List;

public abstract class AbstractProvider<MODEL extends IIdSetter,
        COMPONENT_PROVIDER extends AbstractComponentProvider<MODEL>,
        TABLE_CONTROLLER extends AbstractController<MODEL>,
        FORM_COMPONENT_PROVIDER extends AbstractComponentProvider<MODEL>> {

    private TABLE_CONTROLLER mController;

    protected AbstractProvider() {
        mController = createController();
    }

    protected abstract TABLE_CONTROLLER createController();

    public abstract COMPONENT_PROVIDER getThumbnailProvider(MODEL object);

    public abstract COMPONENT_PROVIDER getPageProvider(MODEL object);

    public abstract FORM_COMPONENT_PROVIDER modifyObject(MODEL object);

    public abstract FORM_COMPONENT_PROVIDER createObject();

    public TABLE_CONTROLLER getTableController() {
        return mController;
    }

    public Object[][] getAsArray() {
        List<MODEL> list = mController.list();
        Object[][] array = new Object[list.size()][];
        int i = 0;
        for (MODEL model : list) {
            array[i++] = model.toArray();
        }
        return array;
    }
}

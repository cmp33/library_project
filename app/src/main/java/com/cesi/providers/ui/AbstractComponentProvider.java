package com.cesi.providers.ui;

import com.cesi.database.models.IIdSetter;
import com.cesi.ui.IComponentProvider;

public abstract class AbstractComponentProvider<MODEL extends IIdSetter>
        implements IComponentProvider {

    private MODEL mObject;

    private AbstractComponentProvider() {

    }

    protected AbstractComponentProvider(MODEL object) {
        mObject = object;
    }

    protected MODEL getModel() {
        return mObject;
    }
}

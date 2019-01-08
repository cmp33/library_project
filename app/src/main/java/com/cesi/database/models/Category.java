package com.cesi.database.models;

import com.cesi.utils.categories.ICategory;
import org.jetbrains.annotations.NotNull;
import za.co.neilson.sqlite.orm.annotations.PrimaryKey;

public class Category implements IIdSetter, ICategory {

    @PrimaryKey(autoIncrement = true)
    private long id;

    private String icon;

    private String name;

    private boolean erasable;

    private String klass;

    public Category() {
        erasable = false;
    }

    public Category(String name, String icon, boolean erasable, String klass) {
        this();

        this.icon = icon;
        this.erasable = erasable;
        this.name = name;
        this.klass = klass;
    }

    public boolean isErasable() {
        return erasable;
    }

    @Override
    public String getName() {
        return name;
    }

    @NotNull
    @Override
    public String getIcon() {
        return icon != null ? icon : "";
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public Object[] toArray() {
        return new Object[]{
                icon,
                name,
                klass
        };
    }

    @Override
    public String[] getColumnNames() {
        return new String[] {
                "icon",
                "name",
                "klass"
        };
    }

    public void setKlass(String klass) {
        this.klass = klass;
    }

    public String getKlass() {
        return this.klass;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Category) {
            return id == ((Category) obj).id;
        }
        return super.equals(obj);
    }
}

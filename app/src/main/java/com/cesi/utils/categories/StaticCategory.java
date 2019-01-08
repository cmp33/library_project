package com.cesi.utils.categories;

import org.jetbrains.annotations.NotNull;

public class StaticCategory implements ICategory {
    private String mIconLetter;
    private String mName;

    private StaticCategory() {
        mName = mIconLetter = "";
    }

    public StaticCategory(@NotNull String name, @NotNull String icon_letter) {
        this();

        mName = name;
        mIconLetter = icon_letter;
    }

    @Override
    @NotNull
    public String getName() {
        return mName;
    }

    @Override
    @NotNull
    public String getIcon() {
        return mIconLetter;
    }
}

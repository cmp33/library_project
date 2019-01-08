package com.cesi.utils.categories;

public class StaticCategories {
    private final static StaticCategories INSTANCE = new StaticCategories();

    public static StaticCategories getInstance() {
        return INSTANCE;
    }

    private StaticCategory[] mStaticCategories;

    {
        mStaticCategories = new StaticCategory[]{
                new StaticCategory("Movies", "k"),
                new StaticCategory("Books", "m"),
                new StaticCategory("Video Games", "projetLibrairydatabase"),
                new StaticCategory("Music", "o")
        };
    }

    private StaticCategories() {

    }

    public StaticCategory[] getStaticCategories() {
        return mStaticCategories;
    }
}

package com.cesi.providers;

import com.cesi.database.controllers.CategoryController;
import com.cesi.database.models.Category;
import com.cesi.providers.ui.category.CategoryThumbnail;

//TODO create CategoryForm and replace in modify/create
public class CategoryProvider extends AbstractProvider<Category, CategoryThumbnail, CategoryController, CategoryThumbnail> {

    public CategoryProvider() {
        super();
    }

    @Override
    protected CategoryController createController() {
        return CategoryController.getInstance();
    }

    @Override
    public CategoryThumbnail getThumbnailProvider(Category object) {
        return new CategoryThumbnail(object);
    }

    @Override
    public CategoryThumbnail getPageProvider(Category object) {
        return null;
    }

    @Override
    public CategoryThumbnail modifyObject(Category object) {
        return null;
    }

    @Override
    public CategoryThumbnail createObject() {
        return null;
    }
}

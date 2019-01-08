package com.cesi.lighter_custom.ui;

import com.cesi.lighter_custom.database.controllers.ModelController;
import com.cesi.lighter_custom.database.db.ProjectDatabase;
import com.cesi.lighter_custom.database.models.Category;
import com.cesi.lighter_custom.database.models.Oeuvre;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        //we call our database initialisation
        ProjectDatabase.init();

        //we grab some controller just to play around
        ModelController<Category> controller = ProjectDatabase.get(Category.class);
        ModelController<Oeuvre> controller2 = ProjectDatabase.get(Oeuvre.class);

        //we create some Category in the database
        Category category = controller.create(new Category());
        //note the fabulous name <3
        //category.setName("test");

        //and we save it
        controller.update(category);

        //we grab every item in the database
        List<Category> categories = controller.read();

        //now switching to some oeuvres
        Oeuvre oeuvre = controller2.create(new Oeuvre());
        controller2.update(oeuvre);

        //the above sandbox should be put in the default values method from the ProjectLibraryDatabase
        //from here, you should start using your own UI
        //use JWT or SWT
        //the later is quite better for cross platform integration. SWT can be a little easier to be used from Java only
    }
}

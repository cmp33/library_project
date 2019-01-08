package com.cesi.ui.sandbox;

import com.cesi.database.controllers.CategoryController;
import com.cesi.database.models.Category;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

import java.util.List;

public class SandBoxMenu {

    public SandBoxMenu() {

    }

    /**
     * Will manage the UI Creation
     *
     * @param composite the parent
     */
    public void implement(Composite composite) {
        //create the menu composite
        Composite menu_composite = new Composite(composite, SWT.PUSH);
        GridLayout layout = new GridLayout(1, true);
        menu_composite.setLayout(layout);

        //fetch the list from the database
        List<Category> list = CategoryController.getInstance().list();

        //instantiate every buttons
        for (Category category : list) {
            Button button = new Button(menu_composite, SWT.PUSH);
            button.setText(category.getName());
        }
    }

    /**
     * Dispose the UI
     */
    public void dispose() {

    }

}

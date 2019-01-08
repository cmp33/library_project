package com.cesi;

import com.cesi.database.db.DatabaseController;
import com.cesi.ui.DisplayController;
import com.cesi.ui.test.MainAreaContent;
import com.cesi.ui.test.NavBarContent;
import org.eclipse.swt.widgets.Composite;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }


    Main() {

    }

    void start() {
        DatabaseController.getInstance().init();
        Composite composite = DisplayController.getInstance().getComposite();

        NavBarContent navbar = new NavBarContent();
        navbar.implement(composite);
        //starting the screen
        MainAreaContent screen = new MainAreaContent();
        //load MainAreaContent's content into the main "composite"
        screen.implement(composite);



        DisplayController.getInstance().startApp();
    }
}

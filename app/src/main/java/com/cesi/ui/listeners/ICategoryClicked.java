package com.cesi.ui.listeners;

import com.cesi.database.models.Category;
import com.cesi.ui.format.Format;
import org.jetbrains.annotations.Nullable;

/**
 * Manage the event dispatching representing a click on a specific menu item
 */
public interface ICategoryClicked {

    void onCategoryClicked(@Nullable Category category,
                           @Nullable Format format);

}

package com.cesi.ui;


import org.eclipse.swt.widgets.Composite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 *
 */
public interface IComponentProvider {

    /**
     * Get the current composite of the view
     *
     * can be null if implement was not called
     * @return a nullable composite
     */
    @Nullable Composite getComposite();

    /**
     * Instantiate and manage the view from the implementation class
     *
     * @param composite inject the view into it
     */
    void implement(@NotNull Composite composite);

    /**
     * Free and dispose the graphical elements from this implementation
     */
    void dispose();
}

package com.cesi.ui.menu;

import com.cesi.database.models.Category;
import com.cesi.providers.Providers;
import com.cesi.providers.ui.category.CategoryThumbnail;
import com.cesi.ui.DisplayController;
import com.cesi.ui.IComponentProvider;
import com.cesi.ui.format.Format;
import com.cesi.ui.listeners.ICategoryClicked;
import com.cesi.ui.scroll.ScrollContent;
import com.cesi.ui.test.MainAreaContent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the whole left menu
 */
public class CategoryMenu implements IComponentProvider, ICategoryClicked {

    private GridLayout mGrid;
    private Composite mComposite;
    private ArrayList<CategoryThumbnail> mCategoriesItem;
    private MainAreaContent mParent;
    private ScrollContent mScrollProvider;
    private Category mLastCategory;
    private Format mLastFormat;

    public CategoryMenu(@NotNull MainAreaContent parent) {
        mParent = parent;
    }

    @Nullable
    @Override
    public Composite getComposite() {
        return mComposite;
    }

    /**
     * For each Category from the database, add a new CategpryItem
     * and add it to the internal list of UI
     *
     * @param composite inject the view into it
     */
    @Override
    public void implement(Composite composite) {
        List<Category> list = Providers.CATEGORY_PROVIDER
                .getTableController().list();

        if (mGrid == null) {
            mGrid = new GridLayout(1, true);

            mScrollProvider = new ScrollContent();
            mScrollProvider.implement(composite);
            mScrollProvider.setPreferredWidthProvider(rectangle -> SWT.DEFAULT);

            mComposite = new Composite(mScrollProvider.getComposite(), SWT.PUSH);
            mScrollProvider.setChild(this);

            GridData data = new GridData();
            data.verticalAlignment = SWT.FILL;
            data.horizontalAlignment = SWT.BEGINNING;
            data.grabExcessVerticalSpace = true;

            mGrid.marginWidth = mGrid.marginBottom = mGrid.marginHeight = 0;
            mGrid.marginTop = 0;
            mGrid.marginLeft = mGrid.marginRight = 0;
            mGrid.horizontalSpacing = mGrid.verticalSpacing = 0;
            mScrollProvider.getComposite().setLayoutData(data);
            mComposite.setLayout(mGrid);
        }

        mCategoriesItem = new ArrayList<CategoryThumbnail>();

        Composite temp_composite = new Composite(mComposite, SWT.NONE);
        RowLayout layout = new RowLayout(SWT.VERTICAL);
        layout.marginTop = 12;
        layout.marginBottom = layout.marginLeft = 6;
        temp_composite.setLayout(layout);

        Label title = new Label(temp_composite, SWT.NONE);
        title.setText("Main categories");
        title.setForeground(DisplayController.getInstance()
                .getColor(120, 120, 120));

        for (Category category : list) {
            CategoryThumbnail item = Providers.CATEGORY_PROVIDER
                    .getThumbnailProvider(category);

            item.setCategoryParent(this);
            mCategoriesItem.add(item);
            item.implement(mComposite);
        }

        temp_composite = new Composite(mComposite, SWT.NONE);
        layout = new RowLayout(SWT.VERTICAL);
        layout.marginTop = 12;
        layout.marginBottom = layout.marginLeft = 6;
        temp_composite.setLayout(layout);

        Label display_format = new Label(temp_composite, SWT.NONE);
        display_format.setText("Display format");
        display_format.setForeground(DisplayController.getInstance()
                .getColor(120, 120, 120));

        CategoryThumbnail[] formats = new CategoryThumbnail[]{
                new CategoryThumbnail("Thumbnail", Format.THUMBNAIL),
                new CategoryThumbnail("List", Format.LIST)
        };


        for (CategoryThumbnail category : formats) {
            category.setCategoryParent(this);
            mCategoriesItem.add(category);
            category.implement(mComposite);
        }


    }

    /**
     * For each UI Element, dispose its ressources
     */
    @Override
    public void dispose() {
        for (IComponentProvider item : mCategoriesItem) {
            item.dispose();
        }
    }

    @Override
    public void onCategoryClicked(@Nullable Category category, @Nullable Format format) {
        if (category != null) {
            mLastCategory = category;
        }

        if (format != null) {
            mLastFormat = format;
        }

        mParent.onCategoryClicked(mLastCategory, mLastFormat);

        for (CategoryThumbnail item : mCategoriesItem) {
            item.onCategoryClicked(mLastCategory, mLastFormat);
        }
    }
}

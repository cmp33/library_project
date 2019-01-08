package com.cesi.ui.content;

import com.cesi.database.models.Category;
import com.cesi.ui.DisplayController;
import com.cesi.ui.IComponentProvider;
import com.cesi.ui.format.Format;
import com.cesi.ui.listeners.ICategoryClicked;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MainContent implements IComponentProvider, ICategoryClicked {

    private Composite mContent;
    private CategoryListContent mCategoryContent;
    private CategoryTableContent mCategoryTableContent;
    private Composite mFrame;

    public MainContent() {

    }

    @Nullable
    @Override
    public Composite getComposite() {
        return mContent;
    }

    @Override
    public void implement(@NotNull Composite composite) {
        mContent = new Composite(composite, SWT.NONE);
        mContent.setBackground(DisplayController.getInstance().getColor(255, 255, 255));

        //create the way for this screen to be displayed at max size
        FillLayout fill = new FillLayout();
        fill.type = SWT.VERTICAL;
        fill.spacing = fill.marginWidth = fill.marginHeight = 0;

        GridData data = new GridData(SWT.FILL, SWT.FILL);
        data.verticalAlignment = GridData.FILL;
        data.grabExcessVerticalSpace = true;
        data.horizontalAlignment = GridData.FILL;
        data.grabExcessHorizontalSpace = true;

        mContent.setLayout(fill);
        mContent.setLayoutData(data);
    }

    @Override
    public void dispose() {

    }

    @Override
    public void onCategoryClicked(@Nullable Category category, @Nullable Format format) {
        if (mCategoryContent != null) {
            mCategoryContent.dispose();
        }

        if(mCategoryTableContent != null) {
            mCategoryTableContent.dispose();
        }

        //TODO manage the given Format
        switch (format) {
            case LIST:
                mCategoryTableContent = new CategoryTableContent(category);
                mCategoryTableContent.implement(mContent);
                mCategoryTableContent.resize();
                break;
            case THUMBNAIL:
            default:
                mCategoryContent = new CategoryListContent(category);
                mCategoryContent.implement(mContent);
                mCategoryContent.resize();
        }
    }
}

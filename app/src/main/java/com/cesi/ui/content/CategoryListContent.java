package com.cesi.ui.content;

import com.cesi.database.controllers.AbstractController;
import com.cesi.database.models.Category;
import com.cesi.database.models.IIdSetter;
import com.cesi.providers.AbstractProvider;
import com.cesi.providers.Providers;
import com.cesi.providers.ui.AbstractComponentProvider;
import com.cesi.ui.DisplayController;
import com.cesi.ui.IComponentProvider;
import com.cesi.ui.scroll.ScrollContent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CategoryListContent implements IComponentProvider, AbstractController.IModificationListener {
    private final ScrollContent mScrollProvider;
    private final Category mCategory;
    private Composite mChildComposite;

    public CategoryListContent(Category category) {
        mScrollProvider = new ScrollContent();

        mCategory = category;
    }

    @Nullable
    @Override
    public Composite getComposite() {
        return mChildComposite;
    }

    @Override
    public void implement(@NotNull Composite composite) {

        AbstractProvider provider = Providers.getProvider(mCategory.getKlass());


        //proxy composite to display the internal component easily
        mScrollProvider.implement(composite);
        mChildComposite = new Composite(mScrollProvider.getComposite(), SWT.NONE);
        mChildComposite.setBackground(DisplayController.getInstance().getColor(255, 255, 255));

        mScrollProvider.setChild(this);

        RowLayout layout = new RowLayout(SWT.HORIZONTAL);
        layout.wrap = true;
        layout.marginTop = layout.marginBottom = layout.marginLeft = layout.marginRight = 24;
        layout.marginHeight = layout.marginWidth = 0;
        layout.spacing = 24;
        mChildComposite.setLayout(layout);

        if (null != provider) {

            provider.getTableController().register(this);

            AbstractController<IIdSetter> controller = provider.getTableController();
            List<IIdSetter> list = controller.list();

            for (IIdSetter object : list) {

                System.out.println(object.toString());
                AbstractComponentProvider<IIdSetter> component = provider.getThumbnailProvider(object);
                component.implement(mChildComposite);
            }

            Button button = new Button(mChildComposite, SWT.PUSH);
            button.setText("Add a new element");
            button.addMouseListener(new MouseListener() {
                @Override
                public void mouseDoubleClick(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseDown(MouseEvent mouseEvent) {

                }

                @Override
                public void mouseUp(MouseEvent mouseEvent) {

                    AbstractComponentProvider<IIdSetter> component = provider.createObject();
                    System.out.println("on click " + component);

                    if (component != null) {
                        Shell shell = new Shell(DisplayController.getInstance().getDisplay(),
                                SWT.SHELL_TRIM);

                        GridLayout layout = new GridLayout(1, true);
                        layout.horizontalSpacing = layout.verticalSpacing = 0;
                        layout.marginTop = layout.marginBottom = 0;
                        layout.marginLeft = layout.marginRight = 0;
                        layout.marginWidth = layout.marginHeight = 0;
                        shell.setLayout(layout);

                        component.implement(shell);

                        shell.open();
                    }
                }
            });
        }
    }

    @Override
    public void dispose() {
        mScrollProvider.dispose();
    }

    public void resize() {
        mChildComposite.layout();
        DisplayController.getInstance().layout(mChildComposite);
    }

    @Override
    public void onCreate(IIdSetter object) {
        //add the new item
        AbstractProvider provider = Providers.getProvider(mCategory.getKlass());

        AbstractComponentProvider<IIdSetter> component = provider.getThumbnailProvider(object);
        component.implement(mChildComposite);

        mChildComposite.layout();
        DisplayController.getInstance().layout(mChildComposite);

    }

    @Override
    public void onUpdate(IIdSetter object) {

    }
}

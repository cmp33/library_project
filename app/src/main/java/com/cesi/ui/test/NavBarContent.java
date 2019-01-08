package com.cesi.ui.test;

import com.cesi.ui.DisplayController;
import com.cesi.ui.IComponentProvider;
import com.cesi.utils.Fonts;
import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class NavBarContent implements IComponentProvider {
    private Composite mComposite;

    @Nullable
    @Override
    public Composite getComposite() {
        return mComposite;
    }

    @Override
    public void implement(@NotNull Composite composite) {
        mComposite = new Composite(composite, SWT.NONE);
        mComposite.setBackground(DisplayController.getInstance()
                .getColor(240, 240, 240));

        GridData data = new GridData();
        data.verticalAlignment = SWT.BEGINNING;
        data.horizontalAlignment = SWT.FILL;
        data.grabExcessHorizontalSpace = true;

        GridLayout layout = new GridLayout(1, true);
        layout.marginWidth = layout.marginHeight = 0;
        layout.marginLeft = layout.marginRight = 12;
        layout.marginBottom = layout.marginTop = 6;

        mComposite.setLayout(layout);
        mComposite.setLayoutData(data);

        mComposite = new Composite(mComposite, SWT.NONE);

        data = new GridData();
        data.verticalAlignment = SWT.BEGINNING;
        data.horizontalAlignment = SWT.END;
        data.grabExcessHorizontalSpace = true;

        layout = new GridLayout(2, true);
        layout.marginWidth = layout.marginHeight = 0;
        layout.marginLeft = layout.marginRight = 6;
        layout.marginBottom = 4;
        layout.marginTop = 6;

        mComposite.setLayoutData(data);
        mComposite.setLayout(layout);


        GridData search_data = new GridData();
        search_data.horizontalAlignment = SWT.BEGINNING;
        search_data.verticalAlignment = SWT.BEGINNING;
        search_data.grabExcessHorizontalSpace = true;

        Text search = new Text(mComposite, SWT.NONE);
        search.setLayoutData(search_data);
        search.setText("");
        search.addModifyListener(new ModifyListener() {
            @Override
            public void modifyText(ModifyEvent modifyEvent) {
                Text text = (Text) modifyEvent.widget;
                System.out.println(text.getText());
            }
        });


        GridData label_data = new GridData();
        label_data.horizontalAlignment = SWT.BEGINNING;
        label_data.verticalAlignment = SWT.BEGINNING;
        Label label = new Label(mComposite, SWT.NONE);
        mComposite.setBackground(DisplayController.getInstance()
        .getColor(255, 255, 255));
        label.setText("a");
        label.setFont(Fonts.getInstance().getFont("cesi", 20));
        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseDoubleClick(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseDown(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseUp(MouseEvent mouseEvent) {
                search.forceFocus();
            }
        });
        search.forceFocus();
    }

    @Override
    public void dispose() {

    }
}

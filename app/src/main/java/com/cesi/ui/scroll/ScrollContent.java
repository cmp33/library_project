package com.cesi.ui.scroll;

import com.cesi.ui.DisplayController;
import com.cesi.ui.IComponentProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ScrollContent implements IComponentProvider {
    private ScrolledComposite mScrollComposite;
    private IComponentProvider mChildProvider;
    private IWidthProvider mWidthProvider;

    public ScrollContent() {

        setPreferredWidthProvider(new IWidthProvider() {
            @Override
            public int getPreferredWidth(Rectangle rectangle) {
                return rectangle.width;
            }
        });
    }

    public void setChild(@NotNull IComponentProvider provider) {
        mChildProvider = provider;


        mScrollComposite.setContent(mChildProvider.getComposite());
        mScrollComposite.setExpandHorizontal(true);
        mScrollComposite.setExpandVertical(true);
        mScrollComposite.addControlListener(new ControlListener() {
            @Override
            public void controlMoved(ControlEvent controlEvent) {

            }

            @Override
            public void controlResized(ControlEvent controlEvent) {
                Rectangle r = mScrollComposite.getClientArea();
                int width = mWidthProvider.getPreferredWidth(r);
                mScrollComposite.setMinSize(mChildProvider.getComposite().computeSize(width, SWT.DEFAULT));
            }
        });
    }

    public void setPreferredWidthProvider(@NotNull IWidthProvider provider) {
        mWidthProvider = provider;
    }

    @Nullable
    @Override
    public Composite getComposite() {
        return mScrollComposite;
    }

    @Override
    public void implement(@NotNull Composite composite) {

        //proxy composite to display the internal component easily
        mScrollComposite = new ScrolledComposite(composite, SWT.V_SCROLL);
        //next set into setChild()
    }

    @Override
    public void dispose() {
        mScrollComposite.dispose();
    }

    public void resize() {
        mChildProvider.getComposite().layout();
        DisplayController.getInstance().layout(mChildProvider.getComposite());
    }

    public interface IWidthProvider {
        int getPreferredWidth(Rectangle rectangle);
    }
}

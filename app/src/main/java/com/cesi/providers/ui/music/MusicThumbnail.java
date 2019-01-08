package com.cesi.providers.ui.music;

import com.cesi.database.models.Music;
import com.cesi.providers.ui.AbstractComponentProvider;
import com.cesi.ui.DisplayController;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MusicThumbnail extends AbstractComponentProvider<Music> {

    private Composite mComposite;
    private Image mImage;

    public MusicThumbnail(Music object) {
        super(object);
    }

    @Nullable
    @Override
    public Composite getComposite() {
        return null;
    }

    @Override
    public void implement(@NotNull Composite composite) {

        //proxy composite to display the internal component easily
        mComposite = new Composite(composite, SWT.NONE);
        mComposite.setBackground(DisplayController.getInstance().getColor(255, 255, 255));

        GridLayout layout = new GridLayout(1, false);
        layout.marginTop = layout.marginBottom = layout.marginLeft = layout.marginRight = 0;
        layout.marginHeight = layout.marginWidth = 0;
        layout.verticalSpacing = 6;
        mComposite.setLayout(layout);

        mImage = DisplayController.getInstance()
                .loadImage("/com/cesi/resources/thumbnail_music.png", 150);

        Label label = new Label(mComposite, SWT.NONE);
        label.setImage(mImage);

        GridData data = new GridData();
        data.horizontalAlignment = SWT.CENTER;
        Label text = new Label(mComposite, SWT.NONE);
        text.setText(getModel().getMetaData().getTitle());
        text.setLayoutData(data);
    }

    @Override
    public void dispose() {
        mComposite.dispose();
    }
}

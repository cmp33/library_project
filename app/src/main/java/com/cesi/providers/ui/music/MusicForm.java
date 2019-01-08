package com.cesi.providers.ui.music;

import com.cesi.database.controllers.MetaDataController;
import com.cesi.database.controllers.MusicController;
import com.cesi.database.models.MetaData;
import com.cesi.database.models.Music;
import com.cesi.providers.ui.AbstractComponentProvider;
import com.cesi.ui.DisplayController;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MusicForm extends AbstractComponentProvider<Music> {

    private Composite mComposite;
    private Image mImage;

    public MusicForm(Music object) {
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

        Label text = new Label(mComposite, SWT.NONE);
        if(getModel() != null) {
            text.setText(getModel().getMetaData().getTitle());
        }

        Text name = new Text(mComposite, SWT.BORDER);

        Button button = new Button(mComposite, SWT.PUSH);
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseDoubleClick(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseDown(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseUp(MouseEvent mouseEvent) {
                MetaData metaData = new MetaData();
                metaData.setTitle(name.getText());
                MetaDataController.getInstance().create(metaData);

                Music music = new Music(90, metaData);
                MusicController.getInstance()
                        .create(music);
                //TODO create new metadata from inputs
                //TODO insert new metadata
                //TODO create new music
                //TODO insert new music

            }
        });

    }

    @Override
    public void dispose() {
        mComposite.dispose();
    }
}

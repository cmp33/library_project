package com.cesi.providers;

import com.cesi.database.controllers.MusicController;
import com.cesi.database.models.Music;
import com.cesi.providers.ui.music.MusicForm;
import com.cesi.providers.ui.music.MusicThumbnail;

public class MusicProvider extends AbstractProvider<Music, MusicThumbnail, MusicController, MusicForm> {
    @Override
    protected MusicController createController() {
        return MusicController.getInstance();
    }

    @Override
    public MusicThumbnail getThumbnailProvider(Music object) {
        return new MusicThumbnail(object);
    }

    @Override
    public MusicThumbnail getPageProvider(Music object) {
        return null;
    }

    @Override
    public MusicForm modifyObject(Music object) {
        return new MusicForm(object);
    }

    @Override
    public MusicForm createObject() {
        return new MusicForm(null);
    }
}

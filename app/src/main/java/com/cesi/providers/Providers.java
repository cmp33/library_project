package com.cesi.providers;

import com.cesi.database.models.Film;
import com.cesi.database.models.IIdSetter;
import com.cesi.database.models.Music;
import org.jetbrains.annotations.Nullable;

public class Providers<MODEL extends IIdSetter> {

    private Providers() {

    }

    public static final CategoryProvider CATEGORY_PROVIDER = new CategoryProvider();

    public static final FilmProvider FILM_PROVIDER = new FilmProvider();

    public static final MusicProvider MUSIC_PROVIDER = new MusicProvider();

    @Nullable
    public static AbstractProvider getProvider(String klass) {
        if(Film.class.getSimpleName().equals(klass)) {
            return FILM_PROVIDER;
        } else if(Music.class.getSimpleName().equals(klass)) {
            return MUSIC_PROVIDER;
        }
        return null;
    }
}

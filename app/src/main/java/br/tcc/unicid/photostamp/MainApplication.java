package br.tcc.unicid.photostamp;

import android.app.Application;

import br.tcc.unicid.photostamp.contract.AppComponent;
import br.tcc.unicid.photostamp.contract.DaggerAppComponent;
import br.tcc.unicid.photostamp.module.EventModule;
import br.tcc.unicid.photostamp.module.GalleryWallModule;
import br.tcc.unicid.photostamp.module.GridModule;
import br.tcc.unicid.photostamp.module.PhotoModule;
import br.tcc.unicid.photostamp.module.TagModule;
import br.tcc.unicid.photostamp.module.ThemeModule;
import br.tcc.unicid.photostamp.module.UserModule;

public class MainApplication extends Application {
    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    private void initDagger() {
        component = DaggerAppComponent
                .builder()
                //.eventModule(new EventModule())
                //.galleryWallModule(new GalleryWallModule())
                //.gridModule(new GridModule())
                //.photoModule(new PhotoModule())
                //.tagModule(new TagModule())
                //.themeModule(new ThemeModule())
                //.userModule(new UserModule())
                .build();
    }

    public static AppComponent getComponent() {
        return component;
    }
}

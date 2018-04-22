package br.tcc.unicid.photostamp.contract;

import br.tcc.unicid.photostamp.model.BLL.EventBll;
import br.tcc.unicid.photostamp.model.BLL.GalleryWallBll;
import br.tcc.unicid.photostamp.model.BLL.GridBll;
import br.tcc.unicid.photostamp.model.BLL.PhotoBll;
import br.tcc.unicid.photostamp.model.BLL.TagBll;
import br.tcc.unicid.photostamp.model.BLL.ThemeBll;
import br.tcc.unicid.photostamp.model.BLL.UserBll;
import br.tcc.unicid.photostamp.module.EventModule;
import br.tcc.unicid.photostamp.module.GalleryWallModule;
import br.tcc.unicid.photostamp.module.GridModule;
import br.tcc.unicid.photostamp.module.PhotoModule;
import br.tcc.unicid.photostamp.module.TagModule;
import br.tcc.unicid.photostamp.module.ThemeModule;
import br.tcc.unicid.photostamp.module.UserModule;
import dagger.Component;

@Component(modules = {
        EventModule.class,
        GalleryWallModule.class,
        GridModule.class,
        PhotoModule.class,
        TagModule.class,
        ThemeModule.class,
        UserModule.class
    })
public interface AppComponent {
    EventBll provideEvent();
    GalleryWallBll provideGalleryWall();
    GridBll provideGrid();
    PhotoBll providePhoto();
    TagBll provideTag();
    ThemeBll provideTheme();
    UserBll provideUser();
}
package br.tcc.unicid.photostamp.contract;

import br.tcc.unicid.photostamp.ForgotPasswordActivity;
import br.tcc.unicid.photostamp.GalleryWallActivity;
import br.tcc.unicid.photostamp.GridActivity;
import br.tcc.unicid.photostamp.Home;
import br.tcc.unicid.photostamp.HomeActivity;
import br.tcc.unicid.photostamp.LoginActivity;
import br.tcc.unicid.photostamp.PhotoActivity;
import br.tcc.unicid.photostamp.SingUpActivity;
import br.tcc.unicid.photostamp.TagActivity;
import br.tcc.unicid.photostamp.ThemeActivity;
import br.tcc.unicid.photostamp.model.BLL.EventBll;
import br.tcc.unicid.photostamp.model.BLL.GalleryWallBll;
import br.tcc.unicid.photostamp.model.BLL.GridBll;
import br.tcc.unicid.photostamp.model.BLL.PhotoBll;
import br.tcc.unicid.photostamp.model.BLL.TagBll;
import br.tcc.unicid.photostamp.model.BLL.ThemeBll;
import br.tcc.unicid.photostamp.model.BLL.UserBll;
import br.tcc.unicid.photostamp.module.ContextModule;
import br.tcc.unicid.photostamp.module.EventModule;
import br.tcc.unicid.photostamp.module.GalleryWallModule;
import br.tcc.unicid.photostamp.module.GridModule;
import br.tcc.unicid.photostamp.module.PhotoModule;
import br.tcc.unicid.photostamp.module.TagModule;
import br.tcc.unicid.photostamp.module.ThemeModule;
import br.tcc.unicid.photostamp.module.UserModule;
import dagger.Component;

@Component(modules = {
        ContextModule.class,
        EventModule.class,
        GalleryWallModule.class,
        GridModule.class,
        PhotoModule.class,
        TagModule.class,
        ThemeModule.class,
        UserModule.class
    })
public interface AppComponent {
    public void inject(HomeActivity activity);
    public void inject(ForgotPasswordActivity activity);
    public void inject(GalleryWallActivity activity);
    public void inject(GridActivity activity);
    public void inject(LoginActivity activity);
    public void inject(SingUpActivity activity);
    public void inject(TagActivity activity);
    public void inject(ThemeActivity activity);
    public void inject(PhotoActivity activity);

    void inject(Home home);
}
package br.tcc.unicid.photostamp.module;

import android.content.Context;

import javax.inject.Inject;

import br.tcc.unicid.photostamp.model.BLL.ThemeBll;
import br.tcc.unicid.photostamp.model.DAL.Database;
import br.tcc.unicid.photostamp.model.DAL.IThemeDal;
import br.tcc.unicid.photostamp.model.DAL.ThemeDB;
import dagger.Module;
import dagger.Provides;

@Module
public class ThemeModule {
    @Provides
    @Inject
    IThemeDal provideDal(Context context){
        return new ThemeDB(new Database(context));
    }

    @Provides
    ThemeBll provideTheme(IThemeDal dal){
        return new ThemeBll(dal);
    }
}

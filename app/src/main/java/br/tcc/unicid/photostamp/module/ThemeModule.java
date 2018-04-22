package br.tcc.unicid.photostamp.module;

import br.tcc.unicid.photostamp.model.BLL.ThemeBll;
import br.tcc.unicid.photostamp.model.DAL.IThemeDal;
import br.tcc.unicid.photostamp.model.DAL.ThemeDB;
import dagger.Module;
import dagger.Provides;

@Module
public class ThemeModule {
    @Provides
    IThemeDal provideDal(){
        return new ThemeDB();
    }

    @Provides
    ThemeBll provideTheme(IThemeDal dal){
        return new ThemeBll(dal);
    }
}

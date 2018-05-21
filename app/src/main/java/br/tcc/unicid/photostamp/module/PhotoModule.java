package br.tcc.unicid.photostamp.module;

import android.content.Context;

import javax.inject.Inject;

import br.tcc.unicid.photostamp.model.BLL.PhotoBll;
import br.tcc.unicid.photostamp.model.DAL.Database;
import br.tcc.unicid.photostamp.model.DAL.IPhotoDal;
import br.tcc.unicid.photostamp.model.DAL.PhotoDB;
import dagger.Module;
import dagger.Provides;

@Module
public class PhotoModule {
    @Provides
    @Inject
    IPhotoDal provideDal(Context context){
        return new PhotoDB(new Database(context));
    }

    @Provides
    PhotoBll providePhoto(IPhotoDal dal){
        return new PhotoBll(dal);
    }
}

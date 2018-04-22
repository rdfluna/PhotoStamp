package br.tcc.unicid.photostamp.module;

import br.tcc.unicid.photostamp.model.BLL.PhotoBll;
import br.tcc.unicid.photostamp.model.DAL.IPhotoDal;
import br.tcc.unicid.photostamp.model.DAL.PhotoDB;
import dagger.Module;
import dagger.Provides;

@Module
public class PhotoModule {
    @Provides
    IPhotoDal provideDal(){
        return new PhotoDB();
    }

    @Provides
    PhotoBll providePhoto(IPhotoDal dal){
        return new PhotoBll(dal);
    }
}

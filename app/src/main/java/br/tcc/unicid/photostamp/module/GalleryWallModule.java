package br.tcc.unicid.photostamp.module;

import android.content.Context;

import javax.inject.Inject;

import br.tcc.unicid.photostamp.model.BLL.GalleryWallBll;
import br.tcc.unicid.photostamp.model.DAL.Database;
import br.tcc.unicid.photostamp.model.DAL.GalleryWallDB;
import br.tcc.unicid.photostamp.model.DAL.IGalleryWallDal;
import dagger.Module;
import dagger.Provides;

@Module
public class GalleryWallModule {
    @Provides
    @Inject
    IGalleryWallDal provideDal(Context context){
        return new GalleryWallDB(new Database(context));
    }

    @Provides
    GalleryWallBll provideGalleryWall(IGalleryWallDal dal){
        return new GalleryWallBll(dal);
    }
}

package br.tcc.unicid.photostamp.module;

import br.tcc.unicid.photostamp.model.BLL.GalleryWallBll;
import br.tcc.unicid.photostamp.model.DAL.GalleryWallDB;
import br.tcc.unicid.photostamp.model.DAL.IGalleryWallDal;
import dagger.Module;
import dagger.Provides;

@Module
public class GalleryWallModule {
    @Provides
    IGalleryWallDal provideDal(){
        return new GalleryWallDB();
    }

    @Provides
    GalleryWallBll provideGalleryWall(IGalleryWallDal dal){
        return new GalleryWallBll(dal);
    }
}

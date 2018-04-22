package br.tcc.unicid.photostamp.module;

import br.tcc.unicid.photostamp.model.BLL.TagBll;
import br.tcc.unicid.photostamp.model.DAL.ITagDal;
import br.tcc.unicid.photostamp.model.DAL.TagDB;
import dagger.Module;
import dagger.Provides;

@Module
public class TagModule {
    @Provides
    ITagDal provideDal(){
        return new TagDB();
    }

    @Provides
    TagBll provideTag(ITagDal dal){
        return new TagBll(dal);
    }
}

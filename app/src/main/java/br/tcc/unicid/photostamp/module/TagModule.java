package br.tcc.unicid.photostamp.module;

import android.content.Context;

import javax.inject.Inject;

import br.tcc.unicid.photostamp.model.BLL.TagBll;
import br.tcc.unicid.photostamp.model.DAL.Database;
import br.tcc.unicid.photostamp.model.DAL.ITagDal;
import br.tcc.unicid.photostamp.model.DAL.TagDB;
import dagger.Module;
import dagger.Provides;

@Module
public class TagModule {
    @Provides
    @Inject
    ITagDal provideDal(Context context){
        return new TagDB(new Database(context));
    }

    @Provides
    TagBll provideTag(ITagDal dal){
        return new TagBll(dal);
    }
}

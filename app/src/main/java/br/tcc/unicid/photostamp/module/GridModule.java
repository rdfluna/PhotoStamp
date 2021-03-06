package br.tcc.unicid.photostamp.module;

import android.content.Context;

import javax.inject.Inject;

import br.tcc.unicid.photostamp.model.BLL.GridBll;
import br.tcc.unicid.photostamp.model.DAL.Database;
import br.tcc.unicid.photostamp.model.DAL.GridDB;
import br.tcc.unicid.photostamp.model.DAL.IGridDal;
import dagger.Module;
import dagger.Provides;

@Module
public class GridModule {
    @Provides
    @Inject
    IGridDal provideDal(Context context){
        return new GridDB(new Database(context));
    }

    @Provides
    GridBll provideGrid(IGridDal dal){
        return new GridBll(dal);
    }
}

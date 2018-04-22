package br.tcc.unicid.photostamp.module;

import br.tcc.unicid.photostamp.model.BLL.GridBll;
import br.tcc.unicid.photostamp.model.DAL.GridDB;
import br.tcc.unicid.photostamp.model.DAL.IGridDal;
import dagger.Module;
import dagger.Provides;

@Module
public class GridModule {
    @Provides
    IGridDal provideDal(){
        return new GridDB();
    }

    @Provides
    GridBll provideGrid(IGridDal dal){
        return new GridBll(dal);
    }
}

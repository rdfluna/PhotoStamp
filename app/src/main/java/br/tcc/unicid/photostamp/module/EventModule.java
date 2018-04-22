package br.tcc.unicid.photostamp.module;

import br.tcc.unicid.photostamp.model.BLL.EventBll;
import br.tcc.unicid.photostamp.model.DAL.EventDB;
import br.tcc.unicid.photostamp.model.DAL.IEventDal;
import dagger.Module;
import dagger.Provides;

@Module
public class EventModule {
    @Provides
    IEventDal provideDal(){
        return new EventDB();
    }

    @Provides
    EventBll provideEvent(IEventDal dal){
        return new EventBll(dal);
    }
}

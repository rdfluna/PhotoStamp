package br.tcc.unicid.photostamp.module;

import android.content.Context;

import br.tcc.unicid.photostamp.model.BLL.EventBll;
import br.tcc.unicid.photostamp.model.DAL.EventDB;
import br.tcc.unicid.photostamp.model.DAL.IEventDal;
import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    //@MyApplicationScope
    Context provideContext() {
        return context;
    }
}

package br.tcc.unicid.photostamp.module;

import android.content.Context;

import javax.inject.Inject;

import br.tcc.unicid.photostamp.model.BLL.UserBll;
import br.tcc.unicid.photostamp.model.DAL.Database;
import br.tcc.unicid.photostamp.model.DAL.IUserDal;
import br.tcc.unicid.photostamp.model.DAL.UserDB;
import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {
    @Provides
    @Inject
    IUserDal provideDal(Context context){
        return new UserDB(new Database(context));
    }

    @Provides
    UserBll provideUser(IUserDal dal){
        return new UserBll(dal);
    }
}

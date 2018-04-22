package br.tcc.unicid.photostamp.module;

import br.tcc.unicid.photostamp.model.BLL.UserBll;
import br.tcc.unicid.photostamp.model.DAL.IUserDal;
import br.tcc.unicid.photostamp.model.DAL.UserDB;
import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {
    @Provides
    IUserDal provideDal(){
        return new UserDB();
    }

    @Provides
    UserBll provideUser(IUserDal dal){
        return new UserBll(dal);
    }
}

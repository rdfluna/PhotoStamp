package br.tcc.unicid.photostamp.contract;

import javax.inject.Singleton;

import br.tcc.unicid.photostamp.model.BLL.UserBll;
import br.tcc.unicid.photostamp.module.UserModule;
import dagger.Component;

@Component(modules = {UserModule.class})
public interface UserComponent {
    UserBll provideUsuario();
}
package br.tcc.unicid.photostamp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import br.tcc.unicid.photostamp.model.BLL.UserBll;

public class LoginActivity extends AppCompatActivity {

    @Inject
    UserBll userBll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
    }
}

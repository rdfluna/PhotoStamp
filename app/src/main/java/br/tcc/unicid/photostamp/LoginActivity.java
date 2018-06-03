package br.tcc.unicid.photostamp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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


    //forgot password
    public void Forgot_password (View view){
        setContentView(R.layout.activity_forgot_password);
    }

    //sign up
    public void Sign_up (View view){
        setContentView(R.layout.activity_sign_up);
    }
}

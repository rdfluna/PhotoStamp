package br.tcc.unicid.photostamp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

import br.tcc.unicid.photostamp.model.BLL.UserBll;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Inject
    UserBll userBll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        Button esqueci = findViewById(R.id.esqueci);
        esqueci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ForgotPasswordActivity.this, PhotoActivity.class);
                startActivity(it);
            }
        });
    }
}

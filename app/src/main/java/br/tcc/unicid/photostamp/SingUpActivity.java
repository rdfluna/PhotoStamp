package br.tcc.unicid.photostamp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import br.tcc.unicid.photostamp.model.BLL.UserBll;

public class SingUpActivity extends AppCompatActivity {

    @Inject
    UserBll userBll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button cad = findViewById(R.id.cadastrar);
        cad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(SingUpActivity.this, PhotoActivity.class);
                startActivity(it);
            }
        });
    }
}

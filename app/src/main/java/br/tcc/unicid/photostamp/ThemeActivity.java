package br.tcc.unicid.photostamp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import br.tcc.unicid.photostamp.model.BLL.ThemeBll;

public class ThemeActivity extends AppCompatActivity {

    @Inject
    ThemeBll themeBll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
    }
}

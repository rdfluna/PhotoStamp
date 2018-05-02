package br.tcc.unicid.photostamp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class Tela_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_menu);

        int[] lista=new int[]{R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,
                R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i};

        GridView gv = (GridView) findViewById(R.id.gridView1);
        gv.setAdapter(new Adaptador(this,lista));



    }
}

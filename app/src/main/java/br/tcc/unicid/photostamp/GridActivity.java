package br.tcc.unicid.photostamp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import br.tcc.unicid.photostamp.model.BLL.GridBll;
import br.tcc.unicid.photostamp.model.BLL.PhotoBll;
import br.tcc.unicid.photostamp.model.BLL.TagBll;

public class GridActivity extends AppCompatActivity {

    @Inject
    GridBll gridBll;
    @Inject
    PhotoBll photoBll;
    @Inject
    TagBll tagBll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
    }
}

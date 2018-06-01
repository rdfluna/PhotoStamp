package br.tcc.unicid.photostamp;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import br.tcc.unicid.photostamp.model.BLL.GalleryWallBll;
import br.tcc.unicid.photostamp.model.BLL.PhotoBll;
import br.tcc.unicid.photostamp.model.BLL.TagBll;

public class GalleryWallActivity extends AppCompatActivity {

    @Inject
    GalleryWallBll galleryWallBll;
    @Inject
    PhotoBll photoBll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mural_photo);
    }
}

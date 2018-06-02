package br.tcc.unicid.photostamp;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.robertlevonyan.views.chip.Chip;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import javax.inject.Inject;

import br.tcc.unicid.photostamp.contract.AppComponent;
//import br.tcc.unicid.photostamp.contract.DaggerAppComponent;
import br.tcc.unicid.photostamp.model.BLL.EventBll;
import br.tcc.unicid.photostamp.model.BLL.PhotoBll;
import br.tcc.unicid.photostamp.model.BLL.TagBll;
import br.tcc.unicid.photostamp.model.BLL.UserBll;
import br.tcc.unicid.photostamp.model.DTO.Grid;
import br.tcc.unicid.photostamp.model.DTO.Photo;
import br.tcc.unicid.photostamp.module.UserModule;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ActivityCompat.OnRequestPermissionsResultCallback {

    @Inject
    PhotoBll photoBll;
    @Inject
    TagBll tagBll;
    @Inject
    EventBll eventBll;

    private  ImageView imagem;
    private final int TIRAR_FOTO = 1;
    private ConstraintLayout constraintLayout;
    private AutoCompleteTextView complete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        constraintLayout = findViewById(R.id.constraintLayoutHome);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MainApplication.getComponent().inject(this);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        imagem = (ImageView) findViewById(R.id.imFotos);
        Button foto = (Button) findViewById(R.id.btnFotos);
        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, TIRAR_FOTO);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TIRAR_FOTO & resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            photoBll.Insert((Bitmap) extras.get("data"));
            ArrayList<Photo> photos = photoBll.Get();
            String[] tags = tagBll.Get();

            ByteArrayInputStream imageStream = new ByteArrayInputStream(photos.get(photos.size() - 1).getImage());
            Bitmap imageBitmap = BitmapFactory.decodeStream(imageStream);
            imagem.setImageBitmap(imageBitmap);

            complete = findViewById(R.id.autocomplete);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, tags);
            complete.setAdapter(adapter);
            complete.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                    AddChip();
                }

            });
            complete.setOnKeyListener(new View.OnKeyListener() {
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    // If the event is a key-down event on the "enter" button
                    if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                            (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        AddChip();
                        return true;
                    }
                    return false;
                }
            });

        }
    }

    private void AddChip()
    {
        Chip chip = new Chip(getApplicationContext());
        chip.setLayoutParams(new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT));
        chip.setPadding(50, 50, 50, 50);
        chip.setChipText(complete.getText().toString());
        complete.setText("");
        constraintLayout.addView(chip);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent it = new Intent(HomeActivity.this, HomeActivity.class);
            startActivity(it);
        } else if (id == R.id.nav_gallery) {
            Intent it = new Intent(HomeActivity.this, TagActivity.class);
            startActivity(it);
        } else if (id == R.id.nav_tema) {
            Intent it = new Intent(HomeActivity.this, ThemeActivity.class);
            startActivity(it);
        } else if (id == R.id.nav_grid) {
            Intent it = new Intent(HomeActivity.this, GridActivity.class);
            startActivity(it);
        } else if (id == R.id.nav_mural) {
            Intent it = new Intent(HomeActivity.this, GalleryWallActivity.class);
            startActivity(it);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

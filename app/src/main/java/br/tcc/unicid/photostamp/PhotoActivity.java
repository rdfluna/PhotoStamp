package br.tcc.unicid.photostamp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.provider.Contacts;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.robertlevonyan.views.chip.Chip;
import com.robertlevonyan.views.chip.OnCloseClickListener;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import javax.inject.Inject;

import br.tcc.unicid.photostamp.model.BLL.PhotoBll;
import br.tcc.unicid.photostamp.model.BLL.TagBll;
import br.tcc.unicid.photostamp.model.DTO.Photo;
import br.tcc.unicid.photostamp.model.DTO.Tag;

public class PhotoActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Inject
    TagBll tagBll;
    @Inject
    PhotoBll photoBll;

    private final int TIRAR_FOTO = 1;
    private AutoCompleteTextView complete;
    private LinearLayout linearLayout;
    private int index = 0;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        linearLayout = findViewById(R.id.layoutTag);

        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        MainApplication.getComponent().inject(this);

        DrawerLayout drawer = findViewById(R.id.drawer_layout2);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, TIRAR_FOTO);
                }
            }
        });

        gridView = findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this, null));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id){
            Intent it = new Intent(PhotoActivity.this, HomeActivity.class);
            it.putExtra("id", (int)id);
            startActivity(it);
            }
        });

        FillAutoComplete();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == TIRAR_FOTO & resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Intent it = new Intent(PhotoActivity.this, HomeActivity.class);
            it.putExtra("data", (Bitmap)data.getExtras().get(("data")));
            startActivity(it);
        }
    }

    public void Filter() {
        if(linearLayout.getChildCount() - 1 > 0) {
            ArrayList<Tag> tags = new ArrayList<>();
            for (int i = 0; i < linearLayout.getChildCount()-1; i++) {
                Chip chip = (Chip) linearLayout.getChildAt(i);
                String texto = chip.getChipText();
                Tag tag = new Tag();
                tag.setName(texto);
                tag = tagBll.GetByName(texto);
                if(tag.getID() != 0) {
                    tags.add(tag);
                }
            }
            ArrayList<Photo> photos = photoBll.Get(tags, true, true);

            gridView.invalidateViews();
            gridView.setAdapter(new ImageAdapter(this, photos));
        }
        else {
            gridView.invalidateViews();
            gridView.setAdapter(new ImageAdapter(this, null));
        }
    }

    private void FillAutoComplete() {
        String[] tags = tagBll.Get();
        complete = findViewById(R.id.autocomplete);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, tags);
        complete.setAdapter(adapter);
        complete.requestFocus();
        complete.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                AddChip(complete.getText().toString());
                complete.setHint("");
                complete.setText("");
                Filter();
            }

        });
        complete.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().contains("\n")) {
                    AddChip(s.toString().replace("\n", ""));
                    complete.setHint("");
                    complete.setText("");
                    Filter();
                }
            }

            @Override
            public void afterTextChanged(Editable s) { }
        });
    }

    private void AddChip(String text) {
        if(!text.equals("")) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.setMargins(0, 16, 0, 0);
            Chip chip = new Chip(getApplicationContext());
            chip.setLayoutParams(layoutParams);
            chip.setClosable(true);
            chip.setChipText(text);
            chip.setOnCloseClickListener(new OnCloseClickListener() {
                @Override
                public void onCloseClick(View v) {
                    ViewGroup layout = (ViewGroup) v.getParent().getParent();
                    Chip c = (Chip) v.getParent();
                    layout.removeView(c);
                    Filter();
                    index--;
                }
            });
            linearLayout.addView(chip, index++);
        }
    }

    public void Login (View view){
        setContentView(R.layout.activity_login_user);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout2);
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
        if (id == R.id.action_description) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent it = new Intent(PhotoActivity.this, PhotoActivity.class);
            startActivity(it);
        } else if (id == R.id.nav_gallery) {
            Intent it = new Intent(PhotoActivity.this, TagActivity.class);
            startActivity(it);
        } else if (id == R.id.nav_tema) {
            Intent it = new Intent(PhotoActivity.this, ThemeActivity.class);
            startActivity(it);
        } else if (id == R.id.nav_grid) {
            Intent it = new Intent(PhotoActivity.this, GridActivity.class);
            startActivity(it);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout2);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;
        private ArrayList<Photo> photos;

        public ImageAdapter(Context c, ArrayList<Photo> phs){
            mContext = c;
            this.photos = phs;
        }

        @Override
        public int getCount() {
            if(photos == null) {
                return photoBll.GetTotal();
            }
            else {
                return photos.size();
            }
        }

        public Object getItem(int position){
            if(photos == null) {
                return photoBll.GetByPosition(position);
            }
            else {
                return photos.get(position);
            }
        }

        @Override
        public long getItemId(int position) {
            if(photos == null) {
                Photo photo = photoBll.GetByPosition(position);
                return photo.getID();
            }
            else {
                return photos.get(position).getID();
            }
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(mContext);

            Photo photo;
            if(photos == null) {
                photo = photoBll.GetByPosition(position);
            }
            else {
                photo = photos.get(position);
            }

            ByteArrayInputStream imageStream = new ByteArrayInputStream(photo.getImage());
            Bitmap imageBitmap = BitmapFactory.decodeStream(imageStream);
            imageView.setImageBitmap(imageBitmap);
            imageView.setLayoutParams(new GridView.LayoutParams(230,230));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(2,2,2,2);
            return imageView;
        }
    }
}

package br.tcc.unicid.photostamp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;

import javax.inject.Inject;

import br.tcc.unicid.photostamp.model.BLL.PhotoBll;
import br.tcc.unicid.photostamp.model.BLL.TagBll;
import br.tcc.unicid.photostamp.model.DTO.Photo;

public class TagActivity extends AppCompatActivity {

    @Inject
    TagBll tagBll;
    @Inject
    PhotoBll photoBll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_check);

        MainApplication.getComponent().inject(this);

        //grid view
        final GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id){
            Intent it = new Intent(TagActivity.this, HomeActivity.class);
            it.putExtra("id", (int)id);
            startActivity(it);
            }
        });

    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c){
            mContext = c;
        }

        @Override
        public int getCount() {
            return photoBll.GetTotalWithoutTag();
        }

        public Object getItem(int position){
            return photoBll.GetByPosition(position);
        }

        @Override
        public long getItemId(int position) {
            Photo photo = photoBll.GetWithoutTagByPosition(position);
            return photo.getID();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(mContext);
            Photo photo = photoBll.GetWithoutTagByPosition(position);
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

package br.tcc.unicid.photostamp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import javax.inject.Inject;

import br.tcc.unicid.photostamp.model.BLL.PhotoBll;
import br.tcc.unicid.photostamp.model.BLL.TagBll;

public class TagActivity extends AppCompatActivity {

    @Inject
    TagBll tagBll;
    @Inject
    PhotoBll photoBll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_check);

        //grid view
        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id){
                Toast.makeText(TagActivity.this,"Foto" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    //  Gridview da pagina pendentes
    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c){
            mContext = c;
        }


        @Override
        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position){
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


        @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(230,230));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(2,2,2,2);
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    private Integer[] mThumbIds = {
                R.drawable.sample_0,
                R.drawable.sample_1,
                R.drawable.sample_2,
                R.drawable.sample_3,
                R.drawable.sample_4,
                R.drawable.sample_0,
                R.drawable.sample_1,
                R.drawable.sample_2,
                R.drawable.sample_3,
                R.drawable.sample_4,
                R.drawable.sample_0,
                R.drawable.sample_1,
                R.drawable.sample_2,
                R.drawable.sample_3,
                R.drawable.sample_4,
                R.drawable.sample_0,
                R.drawable.sample_1,
                R.drawable.sample_2,
                R.drawable.sample_3,
                R.drawable.sample_4
        };
    }


}

package com.example.gridview;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // create datasource as an array which references to our images

    Integer[] mThumbIds = {R.drawable.gingerbread,
            R.drawable.lollipop,
            R.drawable.jellybean,
            R.drawable.icecream,
            R.drawable.honeycomb,
            R.drawable.kitkat};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GridView gd = (GridView) findViewById(R.id.gridView);


        // Attach the adapter to a GridView
        gd.setAdapter(new ImageAdapter(this));

        //create item click listener which displays index position of selected item
        gd.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();

            }
        });
    }

    //create custom adapter, the source for all items to be displayed in the grid
    public class ImageAdapter extends BaseAdapter {

        private Context mContext;

        // create constructor
        public ImageAdapter(Context c) {

            mContext = c;
        }


        @Override
        public int getCount() {
            return mThumbIds.length;
        }
        //TODO auto generated constructor stub


        @Override
        public Object getItem(int position) {
            return null;
        }
        //TODO auto generated constructor stub


        @Override
        public long getItemId(int position) {
            return 0;
        }
        //TODO auto generated constructor stub


        // creating a new ImageView for each item referenced by the Adapter

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            ImageView img;

            // Lookup view for data population
            img= (ImageView) findViewById(R.id.imageView);

            if (convertView == null)
            // if it's not recycled, initialize some attributes
            {
                img = new ImageView(mContext);

                //set height and width contraints for the image view
                img.setLayoutParams(new GridView.LayoutParams(200,205));
              
            } else

            {
                img = (ImageView) convertView;
            }
            // Populate the data into the template view using the data object
            img.setImageResource(mThumbIds[position]);

            // Return the completed view to render on screen
            return img;




        }


    }
}
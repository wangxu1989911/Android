package com.example.android.popmovies;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 10/6/2015 0006.
 */
public class ImageAdapter extends ArrayAdapter<String> {
    private Context context;

    public ImageAdapter(Context context, int resource, int imageViewResourceId, List<String> objects){
        super(context, resource, imageViewResourceId, objects);
        this.context = context;
    }

    @Override
    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater =
                    (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.grid_item_movie, null);
        }
        String url = getItem(position);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.grid_item_movie_imageview);
        Picasso.with(context)
                .load(url)
                .into(imageView);
        return convertView;
    }
}

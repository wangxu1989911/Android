package com.example.android.popmovies;

import android.content.Intent;
import android.media.Image;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    private static final String LOG_TAG = DetailActivityFragment.class.getSimpleName();
    private String mTitle;
    private String mImageURL;
    private Double mRating;
    private String mReleaseDate;
    private String mOverview;

    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_detail, container, false);

        // The detail Activity called via intent.  Inspect the intent for forecast data.
        Intent intent = getActivity().getIntent();
        if (intent != null) {
            if (intent.hasExtra("title")){
                mTitle = intent.getStringExtra("title");
                ((TextView) rootView.findViewById(R.id.title_textview))
                        .setText(mTitle);
            }

            if (intent.hasExtra("imageURL")){
                mImageURL = intent.getStringExtra("imageURL");
                ImageView imageView = (ImageView) rootView.findViewById(R.id.image_imageview);
                Picasso.with(getActivity())
                        .load(mImageURL)
                        .resize(300, 400)
                        .into(imageView);
            }

            if (intent.hasExtra("rating")){
                mRating = intent.getDoubleExtra("rating",0.0);
                ((TextView) rootView.findViewById(R.id.rating_textview))
                        .setText("TMDB rating:  "+mRating.toString()+"/10");
            }

            if (intent.hasExtra("releaseDate")){
                mReleaseDate = intent.getStringExtra("releaseDate");
                ((TextView) rootView.findViewById(R.id.release_date_textview))
                        .setText("Release Date: "+mReleaseDate);
            }

            if (intent.hasExtra("overview")){
                mOverview = intent.getStringExtra("overview");
                ((TextView) rootView.findViewById(R.id.overview_textview))
                        .setText("Overview: "+mOverview);
            }
        }

        return rootView;
    }
}
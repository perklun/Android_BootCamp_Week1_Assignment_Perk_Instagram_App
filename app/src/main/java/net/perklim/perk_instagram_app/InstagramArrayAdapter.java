package net.perklim.perk_instagram_app;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.List;

/**
 * Created by PerkLun on 5/5/2015.
 *
 * Adapter to display popular photos in a listview
 * Uses Picasso to load photos and RoundedImageView
 */
public class InstagramArrayAdapter extends ArrayAdapter<InstagramPhoto> {
    //take context and data souce, we should already know the resource
    public InstagramArrayAdapter(Context context, List<InstagramPhoto> objects) {
        super(context, R.layout.photo_item, objects);
    }

    /**
     * Assigns views to id
     * Loads photos using Picasso
     * Transforms user profile pic to roundedImage before loading using Picasso
     *
     * @param position
     * @param convertView
     * @param parent
     * @return convertView
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        InstagramPhoto photo = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.photo_item, parent, false);
        }
        // Lookup view for data population
        ImageView ivPhoto = (ImageView) convertView.findViewById(R.id.ivPhoto);
        TextView tvCaption = (TextView) convertView.findViewById(R.id.tvCaption);
        ImageView ivUserPhoto = (ImageView) convertView.findViewById(R.id.ivUserPhoto);
        TextView tvUserName = (TextView) convertView.findViewById(R.id.tvUserName);
        TextView tvLikes = (TextView) convertView.findViewById(R.id.tvLikes);
        // Populate the data into the template view using the data object
        tvCaption.setText(photo.getCaption());
        tvUserName.setText(photo.getUsername());
        tvLikes.setText(photo.getLikes());
        // Clear out image in case of it is a recycled view
        ivPhoto.setImageResource(0);
        // Use picasso to retrieve photo
        Picasso.with(getContext()).load(photo.photo_url).into(ivPhoto);
        ivUserPhoto.setImageResource(0);
        // Create new transformation for rounded profile pictures
        Transformation transformation = new RoundedTransformationBuilder()
                .borderColor(Color.WHITE)
                .borderWidthDp(1)
                .cornerRadiusDp(300)
                .oval(false)
                .build();
        // Load user photo
        Picasso.with(getContext())
                .load(photo.user_photo_url)
                .fit()
                .transform(transformation)
                .into(ivUserPhoto);
        return convertView;
    }
}

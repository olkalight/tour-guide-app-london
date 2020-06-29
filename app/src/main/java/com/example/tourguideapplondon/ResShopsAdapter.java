package com.example.tourguideapplondon;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResShopsAdapter extends ArrayAdapter<Item> {

    // resource ID for the background color for this list of items
    private int mColorResourceId;

    public ResShopsAdapter(Activity context, ArrayList<Item> items, int colorResourceId) {
        super(context, 0, items);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Initialise the view holder
        ViewHolder holder;
        // Check if the existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.res_shops_layout, parent, false);
            // setup the holder
            holder = new ViewHolder(convertView);
            // store the holder tag with the convertView
            convertView.setTag(holder);
        } else {
            // otherwise use the holder instead of calling findViewById()
            holder = (ViewHolder) convertView.getTag();
        }
        // Get the Restaurant object located at this position in the list
        final Item currentItem = getItem(position);
        // Assign values if the object currentItem is not null
        if (currentItem != null) {
            // get the picture from the currentItem object and set this picture on the ImageView
            if (currentItem.hasImage()) {
                holder.imageResource.setImageResource(currentItem.getImageResourceId());
                holder.imageResource.setVisibility(View.VISIBLE);
            } else {
                holder.imageResource.setVisibility(View.GONE);
            }
            // get the nameTextView from the current Item object and set this text on the TextView
            holder.nameTextView.setText(currentItem.getAttractionName());
            // get the mapButton icon from the current Item and set this icon on the ImageView
            holder.mapButton.setImageResource(currentItem.getMapButton());
            // find the color that the resource id maps to
            int color = ContextCompat.getColor(getContext(), mColorResourceId);
            holder.textContainer.setBackgroundColor(color);
        }

        // setting a click listener to each item to open the place location in Google Map.
        ImageView mapButton;
        mapButton = convertView.findViewById(R.id.map_button);
        mapButton.setOnClickListener(v -> {
            assert currentItem != null;
            Uri gmmIntentUri = Uri.parse("geo:" + currentItem.getLatitude() + "," + currentItem.getLongitude() + "?q=" + currentItem.getAttractionName());
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            if (mapIntent.resolveActivity(getContext().getPackageManager()) != null) {
                getContext().startActivity(mapIntent);
            }
        });
        // Return the whole list item layout so that it can be shown in the listView
        return convertView;
    }

    static class ViewHolder {
        // Find the ImageView in the res_shops_layout.xml layout with the ID image
        @BindView(R.id.item_image_view)
        ImageView imageResource;
        // Find the TextView in the res_shops_layout.xml layout with the ID name_text_view
        @BindView(R.id.name_text_view)
        TextView nameTextView;
        // Find the TextView in the res_shops_layout.xml layout with the ID description_text_view
        //  @BindView(R.id.description_text_view)
        //   TextView descriptionTextView;
        // Find the ImageView in the res_shops_layout.xml layout with the ID buttonMap
        @BindView(R.id.map_button)
        ImageView mapButton;
        // Set the theme color for the list item
        @BindView(R.id.text_container)
        View textContainer;

        ViewHolder(View view) {
            // Pass the view to ButterKnife to bind it
            ButterKnife.bind(this, view);
        }
    }
}


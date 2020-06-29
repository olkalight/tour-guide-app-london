package com.example.tourguideapplondon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ShopsFragment extends Fragment {

    @BindView(R.id.listView)
    ListView listView;

    public ShopsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);
        // Pass the view to ButterKnife to bind it
        ButterKnife.bind(this, rootView);

        // Create a list of shops
        final ArrayList<Item> shops = new ArrayList<Item>();
        // Shops add
        shops.add(new Item(getString(R.string.shop_one), 51.51322, -0.13872, R.drawable.google_maps));
        shops.add(new Item(getString(R.string.shop_two), 51.5121205, -0.1283617, R.drawable.google_maps));
        shops.add(new Item(getString(R.string.shop_three), 51.5121753, -0.1590038, R.drawable.google_maps));
        shops.add(new Item(getString(R.string.shop_four), 51.5013384, -0.1597141, R.drawable.google_maps));
        shops.add(new Item(getString(R.string.shop_five), 51.5150722, -0.1485293, R.drawable.google_maps));
        shops.add(new Item(getString(R.string.shop_six), 51.5144331, -0.1549333, R.drawable.google_maps));
        shops.add(new Item(getString(R.string.shop_seven), 51.5459, -0.00924, R.drawable.google_maps));
        // Create an {@link ResShopsAdapter}, whose data source is a list of {@link Item}s. The
        // adapter knows how to create list items for each item in the list.
        ResShopsAdapter adapter = new ResShopsAdapter(getActivity(), shops, R.color.shops_background);
        // Make the {@link ListView} use the {@link ResShopsAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Item} in the list.
        listView.setAdapter(adapter);

        return rootView;
    }
}
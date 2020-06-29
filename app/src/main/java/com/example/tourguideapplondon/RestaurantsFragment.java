package com.example.tourguideapplondon;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RestaurantsFragment extends Fragment {

    @BindView(R.id.listView)
    ListView listView;

    public RestaurantsFragment() {
        // required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);
        // Pass the view to ButterKnife to bind it
        ButterKnife.bind(this, rootView);

        // Create a list of restaurants
        final ArrayList<Item> restaurants = new ArrayList<Item>();
        // Restaurants add
        restaurants.add(new Item(getString(R.string.restaurant_one), R.drawable.city_social, 51.5153136, -0.0859705, R.drawable.google_maps));
        restaurants.add(new Item(getString(R.string.restaurant_two), R.drawable.coq_dargent, 51.5132703, -0.0932329, R.drawable.google_maps));
        restaurants.add(new Item(getString(R.string.restaurant_three), R.drawable.german_gym, 51.5324278, -0.1274554, R.drawable.google_maps));
        restaurants.add(new Item(getString(R.string.restaurant_four), R.drawable.granger, 51.5235637, -0.1067624, R.drawable.google_maps));
        restaurants.add(new Item(getString(R.string.restaurant_five), R.drawable.sexy_fish, 51.5092887, -0.1465238, R.drawable.google_maps));
        restaurants.add(new Item(getString(R.string.restaurant_six), R.drawable.sketch, 51.5126963, -0.1437177, R.drawable.google_maps));
        restaurants.add(new Item(getString(R.string.restaurant_seven), R.drawable.vardo, 51.4913165, -0.1618751, R.drawable.google_maps));
        restaurants.add(new Item(getString(R.string.restaurant_eight), R.drawable.zuma, 51.4979045, -0.2542238, R.drawable.google_maps));
        // Create an {@link RestaurantsAdapter}, whose data source is a list of {@link Item}s. The
        // adapter knows how to create list items for each item in the list.
        ResShopsAdapter adapter = new ResShopsAdapter(getActivity(), restaurants, R.color.res_background);
        // Make the {@link ListView} use the {@link RestaurantsAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Item} in the list.
        listView.setAdapter(adapter);

        return rootView;
    }
}
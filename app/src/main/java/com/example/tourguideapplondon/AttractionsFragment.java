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


public class AttractionsFragment extends Fragment {

    @BindView(R.id.listView)
    ListView listView;

    public AttractionsFragment() {
        // required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);
        // Pass the view to ButterKnife to bind it
        ButterKnife.bind(this, rootView);

        // Create a list of attractions
        final ArrayList<Item> attractions = new ArrayList<Item>();
        // Attractions add
        attractions.add(new Item(getString(R.string.attraction_one), getString(R.string.attr_one_descript), R.drawable.borough_market, 51.505512, -0.090481, R.drawable.google_maps));
        attractions.add(new Item(getString(R.string.attraction_two), getString(R.string.attr_two_descript), R.drawable.buckingham_palace, 51.50161, -0.14112, R.drawable.google_maps));
        attractions.add(new Item(getString(R.string.attraction_three), getString(R.string.attr_three_descript), R.drawable.london_eye, 51.50366, -0.11925, R.drawable.google_maps));
        attractions.add(new Item(getString(R.string.attraction_four), getString(R.string.attr_four_descript), R.drawable.madame_tussauds, 51.522778, -0.155278, R.drawable.google_maps));
        attractions.add(new Item(getString(R.string.attraction_five), getString(R.string.attr_five_descript), R.drawable.tower_bridge, 51.50565, -0.07536, R.drawable.google_maps));
        // Create an {@link AttrMusAdapter}, whose data source is a list of {@link Item}s. The
        // adapter knows how to create list items for each item in the list.
        AttrMusAdapter adapter = new AttrMusAdapter(getActivity(), attractions, R.color.attr_background);
        // Make the {@link ListView} use the {@link AttrMusAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Item} in the list.
        listView.setAdapter(adapter);

        return rootView;
    }
}



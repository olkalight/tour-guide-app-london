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


public class MuseumsFragment extends Fragment {

    @BindView(R.id.listView)
    ListView listView;

    public MuseumsFragment() {
        // required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);
        // Pass the view to ButterKnife to bind it
        ButterKnife.bind(this, rootView);

        // Create a list of museums
        final ArrayList<Item> museums = new ArrayList<Item>();
        // Museums add
        museums.add(new Item(getString(R.string.museum_one), getString(R.string.museum_one_descript), R.drawable.british_museum, 51.5195, -0.1269, R.drawable.google_maps));
        museums.add(new Item(getString(R.string.museum_two), getString(R.string.museum_two_descript), R.drawable.hayward_gallery, 51.506111, -0.115556, R.drawable.google_maps));
        museums.add(new Item(getString(R.string.museum_three), getString(R.string.museum_three_descript), R.drawable.national_gallery, 51.5086, -0.1283, R.drawable.google_maps));
        museums.add(new Item(getString(R.string.museum_four), getString(R.string.museum_four_descript), R.drawable.saatchi_gallery, 51.4906, -0.1589, R.drawable.google_maps));
        museums.add(new Item(getString(R.string.museum_five), getString(R.string.museum_five_descript), R.drawable.tate_modern, 51.507595, -0.099356, R.drawable.google_maps));
        // Create an {@link AttrMusAdapter}, whose data source is a list of {@link Item}s. The
        // adapter knows how to create list items for each item in the list.
        AttrMusAdapter adapter = new AttrMusAdapter(getActivity(), museums, R.color.mus_background);
        // Make the {@link ListView} use the {@link AttrMusAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Item} in the list.
        listView.setAdapter(adapter);

        return rootView;
    }
}

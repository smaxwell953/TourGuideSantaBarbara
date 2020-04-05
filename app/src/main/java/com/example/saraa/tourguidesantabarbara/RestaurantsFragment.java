package com.example.saraa.tourguidesantabarbara;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;

public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
        // Empty public constructor
    }

    private ArrayList<Site> sites;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.site_list, container, false);

        // Create a list of restaurants
        sites = new ArrayList<>();

        Location laSuperRicaTaqueria = new Location(getResources().getString(R.string.restaurants_name_1));
        laSuperRicaTaqueria.setLatitude(34.4279);
        laSuperRicaTaqueria.setLongitude(-119.6873);
        sites.add(new Site(R.drawable.restaurants_1_lasuperirica, getResources().getString(R.string.restaurants_name_1), getResources().getString(R.string.restaurants_phone_1), getResources().getString(R.string.restaurants_address_1), laSuperRicaTaqueria));

        Location theNaturalCafe = new Location(getResources().getString(R.string.restaurants_name_2));
        theNaturalCafe.setLatitude(34.4349);
        theNaturalCafe.setLongitude(-119.7461);
        sites.add(new Site(R.drawable.restaurants_2_thenaturalcafe, getResources().getString(R.string.restaurants_name_2), getResources().getString(R.string.restaurants_phone_2), getResources().getString(R.string.restaurants_address_2), theNaturalCafe));

        Location theHabit = new Location(getResources().getString(R.string.restaurants_name_3));
        theHabit.setLatitude(34.4185);
        theHabit.setLongitude(-119.6975);
        sites.add(new Site(R.drawable.restaurants_3_thehabit, getResources().getString(R.string.restaurants_name_3), getResources().getString(R.string.restaurants_phone_3), getResources().getString(R.string.restaurants_address_3), theHabit));

        Location cajunKitchen = new Location(getResources().getString(R.string.restaurants_name_4));
        cajunKitchen.setLatitude(34.4285);
        cajunKitchen.setLongitude(-119.7164);
        sites.add(new Site(R.drawable.restaurants_4_cajunkitchen, getResources().getString(R.string.restaurants_name_4), getResources().getString(R.string.restaurants_phone_4), getResources().getString(R.string.restaurants_address_4), cajunKitchen));

        Location rustysPizza = new Location(getResources().getString(R.string.restaurants_name_5));
        rustysPizza.setLatitude(34.4134);
        rustysPizza.setLongitude(-119.6910);
        sites.add(new Site(R.drawable.restaurants_5_rustyspizza, getResources().getString(R.string.restaurants_name_5), getResources().getString(R.string.restaurants_phone_5), getResources().getString(R.string.restaurants_address_5), rustysPizza));

        SiteAdapter adapter = new SiteAdapter(getActivity(), sites);

        ListView listView = rootview.findViewById(R.id.list);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                double lat = sites.get(position).getLocation().getLatitude();
                double lon = sites.get(position).getLocation().getLongitude();
                String keyword = sites.get(position).getSiteName();
                Uri uri = Uri.parse("geo:" + lat + "," + lon + "?q=" + Uri.encode(keyword));

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });

        return rootview;
    }
}
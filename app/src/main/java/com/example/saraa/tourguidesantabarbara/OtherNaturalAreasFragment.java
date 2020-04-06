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

public class OtherNaturalAreasFragment extends Fragment {

    public OtherNaturalAreasFragment() {
        // Empty public constructor
    }

    private ArrayList<Site> sites;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.site_list, container, false);

        // Create a list of other natural areas
        sites = new ArrayList<>();

        Location santaBarbaraBotanicGarden = new Location(getResources().getString(R.string.othernaturalareas_name_1));
        santaBarbaraBotanicGarden.setLatitude(34.4565);
        santaBarbaraBotanicGarden.setLongitude(-119.7100);
        sites.add(new Site(R.drawable.othernaturalareas_1_santabarbarabotanicgarden, getResources().getString(R.string.othernaturalareas_name_1), getResources().getString(R.string.othernaturalareas_phone_1), getResources().getString(R.string.othernaturalareas_address_1), santaBarbaraBotanicGarden));

        Location channelIslandsNationalPark = new Location(getResources().getString(R.string.othernaturalareas_name_2));
        channelIslandsNationalPark.setLatitude(34.4040);
        channelIslandsNationalPark.setLongitude(-119.6938);
        sites.add(new Site(R.drawable.othernaturalareas_2_channelislands, getResources().getString(R.string.othernaturalareas_name_2), getResources().getString(R.string.othernaturalareas_phone_2), getResources().getString(R.string.othernaturalareas_address_2), channelIslandsNationalPark));

        Location chumashPaintedCaveStateHistoricPark = new Location(getResources().getString(R.string.othernaturalareas_name_3));
        chumashPaintedCaveStateHistoricPark.setLatitude(34.5042);
        chumashPaintedCaveStateHistoricPark.setLongitude(-119.7876);
        sites.add(new Site(R.drawable.othernaturalareas_3_chumashpaintedcavepark, getResources().getString(R.string.othernaturalareas_name_3), getResources().getString(R.string.othernaturalareas_phone_3), getResources().getString(R.string.othernaturalareas_address_3), chumashPaintedCaveStateHistoricPark));

        Location rattlesnakeCanyonPark = new Location(getResources().getString(R.string.othernaturalareas_name_4));
        rattlesnakeCanyonPark.setLatitude(34.4711);
        rattlesnakeCanyonPark.setLongitude(-119.6861);
        sites.add(new Site(R.drawable.othernaturalareas_4_rattlesnakecanyon, getResources().getString(R.string.othernaturalareas_name_4), getResources().getString(R.string.othernaturalareas_phone_4), getResources().getString(R.string.othernaturalareas_address_4), rattlesnakeCanyonPark));

        Location shorelinePark = new Location(getResources().getString(R.string.othernaturalareas_name_5));
        shorelinePark.setLatitude(34.3964);
        shorelinePark.setLongitude(-119.7068);
        sites.add(new Site(R.drawable.othernaturalareas_5_shorelinepark, getResources().getString(R.string.othernaturalareas_name_5), getResources().getString(R.string.othernaturalareas_phone_5), getResources().getString(R.string.othernaturalareas_address_5), shorelinePark));

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
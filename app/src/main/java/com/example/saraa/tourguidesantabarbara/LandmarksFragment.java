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

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class LandmarksFragment extends Fragment {

    public LandmarksFragment() {
        // Empty public constructor
    }

    private ArrayList<Site> sites;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.site_list, container, false);

        // Create a list of landmarks
        sites = new ArrayList<>();

        Location missionSantaBarbara = new Location(getResources().getString(R.string.landmarks_name_1));
        missionSantaBarbara.setLatitude(34.4381);
        missionSantaBarbara.setLongitude(-119.7136);
        sites.add(new Site(R.drawable.landmarks_1_missionsantabarbara, getResources().getString(R.string.landmarks_name_1), getResources().getString(R.string.landmarks_phone_1), getResources().getString(R.string.landmarks_address_1), missionSantaBarbara));

        Location moretonBayFigTree = new Location(getResources().getString(R.string.landmarks_name_2));
        moretonBayFigTree.setLatitude(34.4138);
        moretonBayFigTree.setLongitude(-119.6940);
        sites.add(new Site(R.drawable.landmarks_2_moretonbayfigtree, getResources().getString(R.string.landmarks_name_2), getResources().getString(R.string.landmarks_phone_2), getResources().getString(R.string.landmarks_address_2), moretonBayFigTree));

        Location santaBarbaraCountyCourthouse = new Location(getResources().getString(R.string.landmarks_name_4));
        santaBarbaraCountyCourthouse.setLatitude(34.4242);
        santaBarbaraCountyCourthouse.setLongitude(-119.7021);
        sites.add(new Site(R.drawable.landmarks_4_santabarbaracountycourthouse, getResources().getString(R.string.landmarks_name_4), getResources().getString(R.string.landmarks_phone_4), getResources().getString(R.string.landmarks_address_4), santaBarbaraCountyCourthouse));

        Location stearnsWharf = new Location(getResources().getString(R.string.landmarks_name_5));
        stearnsWharf.setLatitude(34.4100);
        stearnsWharf.setLongitude(-119.6856);
        sites.add(new Site(R.drawable.landmarks_5_stearnswharf, getResources().getString(R.string.landmarks_name_5), getResources().getString(R.string.landmarks_phone_5), getResources().getString(R.string.landmarks_address_5), stearnsWharf));

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
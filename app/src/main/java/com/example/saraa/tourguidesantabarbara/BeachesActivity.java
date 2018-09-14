package com.example.saraa.tourguidesantabarbara;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class BeachesActivity extends AppCompatActivity {
    private ArrayList<Site> sites;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.site_list);

        // Create a list of beaches
        sites = new ArrayList<>();

        Location eastBeach = new Location(getResources().getString(R.string.beaches_name_1));
        eastBeach.setLatitude(34.4153);
        eastBeach.setLongitude(-119.6764);
        sites.add(new Site(R.drawable.beaches_1_eastbeach, getResources().getString(R.string.beaches_name_1), getResources().getString(R.string.beaches_phone_1), getResources().getString(R.string.beaches_address_1), eastBeach));

        Location westBeach = new Location(getResources().getString(R.string.beaches_name_2));
        westBeach.setLatitude(34.4103);
        westBeach.setLongitude(-119.6901);
        sites.add(new Site(R.drawable.beaches_2_westbeach, getResources().getString(R.string.beaches_name_2), getResources().getString(R.string.beaches_phone_2), getResources().getString(R.string.beaches_address_2), westBeach));

        Location arroyoBurroBeach = new Location(getResources().getString(R.string.beaches_name_3));
        arroyoBurroBeach.setLatitude(34.4028);
        arroyoBurroBeach.setLongitude(-119.7432);
        sites.add(new Site(R.drawable.beaches_3_arroyoburrobeach, getResources().getString(R.string.beaches_name_3), getResources().getString(R.string.beaches_phone_3), getResources().getString(R.string.beaches_address_3), arroyoBurroBeach));

        Location leadbetterBeach = new Location(getResources().getString(R.string.beaches_name_4));
        leadbetterBeach.setLatitude(34.4024);
        leadbetterBeach.setLongitude(-119.6992);
        sites.add(new Site(R.drawable.beaches_4_leadbetterbeach, getResources().getString(R.string.beaches_name_4), getResources().getString(R.string.beaches_phone_4), getResources().getString(R.string.beaches_address_4), leadbetterBeach));

        SiteAdapter adapter = new SiteAdapter(this, sites);

        ListView listView = (ListView) findViewById(R.id.list);

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
    }
}

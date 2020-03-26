package com.example.saraa.tourguidesantabarbara;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class HotelsActivity extends AppCompatActivity {
    private ArrayList<Site> sites;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.site_list);

        // Create a list of hotels
        sites = new ArrayList<>();

        Location brisasDelMar = new Location(getResources().getString(R.string.hotels_name_1));
        brisasDelMar.setLatitude(34.4099);
        brisasDelMar.setLongitude(-119.6973);
        sites.add(new Site(R.drawable.hotels_1_brisasdelmar, getResources().getString(R.string.hotels_name_1), getResources().getString(R.string.hotels_phone_1), getResources().getString(R.string.hotels_address_1), brisasDelMar));

        Location hotelSantaBarbara = new Location(getResources().getString(R.string.hotels_name_2));
        hotelSantaBarbara.setLatitude(34.4175);
        hotelSantaBarbara.setLongitude(-119.6967);
        sites.add(new Site(R.drawable.hotels_2_hotelsantabarbara, getResources().getString(R.string.hotels_name_2), getResources().getString(R.string.hotels_phone_2), getResources().getString(R.string.hotels_address_2), hotelSantaBarbara));

        Location innbytheHarbor = new Location(getResources().getString(R.string.hotels_name_3));
        innbytheHarbor.setLatitude(34.4098);
        innbytheHarbor.setLongitude(-119.6983);
        sites.add(new Site(R.drawable.hotels_3_innbytheharbor, getResources().getString(R.string.hotels_name_3), getResources().getString(R.string.hotels_phone_3), getResources().getString(R.string.hotels_address_3), innbytheHarbor));

        Location lavenderInn = new Location(getResources().getString(R.string.hotels_name_4));
        lavenderInn.setLatitude(34.4103);
        lavenderInn.setLongitude(-119.6966);
        sites.add(new Site(R.drawable.hotels_4_lavenderinn, getResources().getString(R.string.hotels_name_4), getResources().getString(R.string.hotels_phone_4), getResources().getString(R.string.hotels_address_4), lavenderInn));

        Location theWayfarer = new Location(getResources().getString(R.string.hotels_name_5));
        theWayfarer.setLatitude(34.4150);
        theWayfarer.setLongitude(-119.6924);
        sites.add(new Site(R.drawable.hotels_5_wayfarer, getResources().getString(R.string.hotels_name_5), getResources().getString(R.string.hotels_phone_5), getResources().getString(R.string.hotels_address_5), theWayfarer));

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
package com.example.saraa.tourguidesantabarbara;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SiteAdapter extends ArrayAdapter<Site> {

    public SiteAdapter(Context context, ArrayList<Site> sites) {
        super(context, 0, sites);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Site currentSite = getItem(position);

        TextView nameTextView = listItemView.findViewById(R.id.name);
        nameTextView.setText(currentSite.getSiteName());

        TextView phoneTextView = listItemView.findViewById(R.id.phone);
        if("".equals(currentSite.getSitePhone()))
            phoneTextView.setVisibility(View.GONE);
        else {
            phoneTextView.setVisibility(View.VISIBLE);
            phoneTextView.setText(currentSite.getSitePhone());
        }

        TextView addressTextView = listItemView.findViewById(R.id.address);
        addressTextView.setText(currentSite.getSiteAddress());

        ImageView imageView = listItemView.findViewById(R.id.image_view);
        imageView.setImageResource(currentSite.getImageResourceId());

        return listItemView;
    }
}
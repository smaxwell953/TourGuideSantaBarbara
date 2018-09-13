package com.example.saraa.tourguidesantabarbara;

import android.location.Location;

public class Site  {
    private String mSiteName;
    private String mSitePhone;
    private String mSiteAddress;
    private String mImageResourceUrl;
    private Location mSiteLocation;

    public Site(String name, String phone, String address, String imageUrl, Location location) {
        mSiteName = name;
        mSitePhone = phone;
        mSiteAddress = address;
        mImageResourceUrl = imageUrl;
        mSiteLocation = location;
    }

    public String getSiteName() {
        return mSiteName;
    }

    public String getSitePhone() {
        return mSitePhone;
    }

    public Location getLocation() {
        return mSiteLocation;
    }

    public String getSiteAddress() {
        return mSiteAddress;
    }

    public String getImageResourceUrl(){
        return mImageResourceUrl;
    }
}
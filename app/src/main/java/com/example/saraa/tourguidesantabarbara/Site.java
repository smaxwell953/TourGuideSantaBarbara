package com.example.saraa.tourguidesantabarbara;

import android.location.Location;

public class Site  {
    private int mImageResourceId;
    private String mSiteName;
    private String mSitePhone;
    private String mSiteAddress;
    private Location mSiteLocation;

    public Site(int imageResourceId, String name, String phone, String address, Location location) {
        mImageResourceId = imageResourceId;
        mSiteName = name;
        mSitePhone = phone;
        mSiteAddress = address;
        mSiteLocation = location;
    }

    public int getImageResourceId() { return mImageResourceId; }

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
}
package com.example.saraa.tourguidesantabarbara;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

class MyViewPager extends FragmentPagerAdapter {

    private Context mContext;


    public MyViewPager(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                BeachesFragment beachesFragment = new BeachesFragment();
                return beachesFragment;

            case 1:
                HotelsFragment hotelsFragment = new HotelsFragment();
                return hotelsFragment;

            case 2:
                LandmarksFragment landmarksFragment = new LandmarksFragment();
                return landmarksFragment;

            case 3:
                OtherNaturalAreasFragment othernaturalareasFragment = new OtherNaturalAreasFragment();
                return othernaturalareasFragment;

            case 4:
                RestaurantsFragment restaurantsFragment = new RestaurantsFragment();
                return restaurantsFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_beaches);
        } else if (position == 1) {
            return mContext.getString(R.string.category_hotels);
        } else if (position == 2) {
            return mContext.getString(R.string.category_landmarks);
        } else if (position == 3) {
            return mContext.getString(R.string.category_othernaturalareas);
        } else {
            return mContext.getString(R.string.category_restaurants);
        }
    }
}
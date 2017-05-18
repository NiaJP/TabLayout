package com.bswfx.wings.android.tablayout20161117;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExampleFragmentPagerAdapter extends FragmentPagerAdapter {
    public ExampleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            //NEWS
            case 0:
                return ExampleFragment.newInstance(android.R.color.holo_green_dark);
            //MATOME
            case 1:
                return ExampleFragment.newInstance(android.R.color.holo_blue_dark);
            //BLOG
            case 2:
                return ExampleFragment.newInstance(android.R.color.darker_gray);
            //NPB ALL
            case 3:
                return ExampleFragment.newInstance(android.R.color.background_light);
            //RANGING
            case 4:
                return ExampleFragment.newInstance(android.R.color.holo_orange_dark);
            //NAVER
            case 5:
                return ExampleFragment.newInstance(android.R.color.background_dark);
            //CENTRAL LEAGUE
            case 6:
                return ExampleFragment.newInstance(android.R.color.holo_purple);
        }
        return null;
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        String Ret = "";

        switch (position) {
            //NEWS
            case 0:
                Ret = "NEWS";
                break;
            //MATOME
            case 1:
                Ret = "MATOME";
                break;
            //BLOG
            case 2:
                Ret = "BLOG";
                break;
            //NPB ALL
            case 3:
                Ret = "NPB ALL";
                break;
            //RANKING
            case 4:
                Ret = "RANKING";
                break;
            //NAVER
            case 5:
                Ret = "NAVER";
                break;
            //CENTRAL LEAGUE
            case 6:
                Ret = "CENTRAL LEAGUE";
        }
        return Ret;

/*
        return "ページ" + (position + 1);
*/
    }
}
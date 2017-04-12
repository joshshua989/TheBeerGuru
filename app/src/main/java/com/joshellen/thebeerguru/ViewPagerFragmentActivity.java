package com.joshellen.thebeerguru;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;
import java.util.Vector;

/**
 * Created by Josh on 4/11/2017.
 */

public class ViewPagerFragmentActivity extends FragmentActivity {
    /** maintains the pager adapter*/
    private PagerAdapter mPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.viewpager_layout);
        // initialize the pager
        this.initializePaging();
    }

    /**
     * Initialize the fragments to be paged
     */
    private void initializePaging() {

        List<Fragment> fragments = new Vector<>();
        fragments.add(Fragment.instantiate(this, FragmentStyleSubCatLeft.class.getName()));
        fragments.add(Fragment.instantiate(this, FragmentStyleSubCatMain.class.getName()));
        fragments.add(Fragment.instantiate(this, FragmentStyleSubCatRight.class.getName()));
        this.mPagerAdapter  = new PagerAdapter(super.getSupportFragmentManager(), fragments);
        //
        ViewPager pager = (ViewPager)super.findViewById(R.id.vp_pager);
        pager.setAdapter(this.mPagerAdapter);
    }

    // create inner CustomAdapter class for pageViewer swipe design
    private class PagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments;

        public PagerAdapter(FragmentManager supportFragManager, List<Fragment> fragments) {
            super(supportFragManager);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case -1:
                    return new FragmentStyleSubCatLeft();
                case 0:
                    return new FragmentStyleSubCatMain();
                case 1:
                    return new FragmentStyleSubCatRight();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }
}


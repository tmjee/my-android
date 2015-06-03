package com.tmjee.android1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

/**
 * Created by tmjee on 26/05/15.
 */
public class ViewPagerActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager_activity);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }


    private static class MyPagerAdapter extends FragmentStatePagerAdapter {

        private FragmentManager fragmentManager;

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
            this.fragmentManager = fragmentManager;
        }

        @Override
        public Fragment getItem(int i) {
            if (0 == i) {
                return ViewPagerFragment1Fragment.newInstance();
            } else if (1 == i) {
                return ViewPagerFragment2Fragment.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }
}

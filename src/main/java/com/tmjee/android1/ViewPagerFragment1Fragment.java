package com.tmjee.android1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tmjee on 30/05/15.
 */
public class ViewPagerFragment1Fragment extends Fragment {

    public static ViewPagerFragment1Fragment newInstance() {
        Bundle bundle = new Bundle();
        ViewPagerFragment1Fragment fragment = new ViewPagerFragment1Fragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.view_pager_fragment1_fragment, container, false);
    }
}

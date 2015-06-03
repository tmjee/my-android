package com.tmjee.android1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by tmjee on 30/05/15.
 */
public class ViewPagerFragment2Fragment extends Fragment {


    public static ViewPagerFragment2Fragment newInstance() {
        Bundle bundle = new Bundle();
        ViewPagerFragment2Fragment fragment = new ViewPagerFragment2Fragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.view_pager_fragment2_fragment, container, false);
    }
}

package com.tmjee.android1;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HelloAndroidFragment extends Fragment {

    public static HelloAndroidFragment newInstance() {
        Bundle bundle = new Bundle();
        HelloAndroidFragment fragment = new HelloAndroidFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.hello_android_fragment, container, false);

    }
}

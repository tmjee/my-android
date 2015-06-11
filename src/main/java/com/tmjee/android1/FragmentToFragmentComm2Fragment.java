package com.tmjee.android1;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by tmjee on 7/06/15.
 */
public class FragmentToFragmentComm2Fragment  extends Fragment {

    public static FragmentToFragmentComm2Fragment newInstance(String message) {
        Bundle bundle = new Bundle();
        bundle.putString("Message", message);
        FragmentToFragmentComm2Fragment f = new FragmentToFragmentComm2Fragment();
        f.setArguments(bundle);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_to_fragment_comm_2_fragment, container, false);
        TextView textView = (TextView) v.findViewById(R.id.f2_message);
        textView.setText(getArguments().getString("Message"));

        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Intent i = new Intent();
        i.putExtra("timestamp", System.currentTimeMillis());

        getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, i);
    }
}

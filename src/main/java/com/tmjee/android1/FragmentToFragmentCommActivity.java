package com.tmjee.android1;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;

/**
 * Created by tmjee on 7/06/15.
 */
public class FragmentToFragmentCommActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View v = getLayoutInflater().inflate(R.layout.fragment_to_fragment_comm_activity, null);
        setContentView(v);

        Fragment f1 = getFragmentManager().findFragmentById(R.id.f1);
        if (f1 == null || f1.isRemoving()) {
            f1 = FragmentToFragmentComm1Fragment.newInstance();
        }
        Fragment f2 = getFragmentManager().findFragmentById(R.id.f2);
        if (f2 == null || f2.isRemoving()) {
            f2 = FragmentToFragmentComm2Fragment.newInstance("");
        }
        f2.setTargetFragment(f1, FragmentToFragmentComm1Fragment.REQ_CODE);

        getFragmentManager().beginTransaction()
                .replace(R.id.f1, f1)
                .replace(R.id.f2, f2)
                .commit();
    }
}

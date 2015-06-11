package com.tmjee.android1;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by tmjee on 7/06/15.
 */
public class FragmentToFragmentComm1Fragment extends Fragment {

    public static final int REQ_CODE = 1;

    public static FragmentToFragmentComm1Fragment newInstance() {
        Bundle bundle = new Bundle();
        FragmentToFragmentComm1Fragment f = new FragmentToFragmentComm1Fragment();
        f.setArguments(bundle);
        return f;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_to_fragment_comm_1_fragment, container, false);

        final EditText editText = (EditText) view.findViewById(R.id.f1_message);
        Button button = (Button) view.findViewById(R.id.f1_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String message = editText.getText().toString();
                Fragment f2 = FragmentToFragmentComm2Fragment.newInstance(message);
                f2.setTargetFragment(FragmentToFragmentComm1Fragment.this, REQ_CODE);
                getFragmentManager().beginTransaction()
                        .replace(R.id.f2, f2)
                        .commit();

            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == FragmentToFragmentComm1Fragment.REQ_CODE) {
            TextView tv = (TextView) getView().findViewById(R.id.f1_text);
            tv.setText("Updated at " + data.getLongExtra("timestamp", 0L));
        }
    }
}

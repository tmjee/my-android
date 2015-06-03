package com.tmjee.android1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import java.util.Date;

/**
 * Created by tmjee on 30/05/15.
 */
public class HelloDialogActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_dialog_activity);
        findViewById(R.id.alertDialogButton).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HelloDialogFragment f = HelloDialogFragment.newInstance();
                f.addListener(
                        new HelloDialogFragment.HelloDialogFragmentListener() {
                            public void onDateChange(Date date) {
                                System.out.println("*** Date is "+date);
                            }
                        });
                f.show(getFragmentManager(), "tag");
            }
        });
    }
}

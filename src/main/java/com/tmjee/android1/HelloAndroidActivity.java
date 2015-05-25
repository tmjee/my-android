package com.tmjee.android1;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.Menu;

public class HelloAndroidActivity extends Activity {

    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after 
     * previously being shut down then this Bundle contains the data it most 
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_android_activity);
        Fragment fragment = getFragmentManager().findFragmentById(R.id.details);
        if (fragment == null || fragment.isRemoving()) {
            fragment = HelloAndroidFragment.newInstance();

            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.details, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(com.tmjee.android1.R.menu.main, menu);
	return true;
    }

}


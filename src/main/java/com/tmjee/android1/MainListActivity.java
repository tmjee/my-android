package com.tmjee.android1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainListActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_list_activity);
        Log.e("ddd", "Activity onCreate");
    }
}

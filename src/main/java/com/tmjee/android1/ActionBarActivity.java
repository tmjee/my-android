package com.tmjee.android1;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author tmjee
 */
public class ActionBarActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.action_bar_activity);
        Fragment f = getFragmentManager().findFragmentById(R.id.f1);
        if (f == null || f.isRemoving()) {
            f = ActionBarFragment.newInstance();
        }
        Log.w("tag", "****** f1=" + f);

        Fragment f2 = getFragmentManager().findFragmentById(R.id.f2);
        if (f2 == null || f2.isRemoving()) {
            f2 = ActionBarAnotherFragment.newInstance();
        }
        Log.w("tag", "****** f2=" + f2);
        getFragmentManager().beginTransaction()
                .replace(R.id.f1, f)
                .replace(R.id.f2, f2)
                .commit();
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {

        View v =super.onCreateView(name, context, attrs);
        if (NavUtils.getParentActivityName(this) != null) {
            //getActionBar().setDisplayHomeAsUpEnabled(true);
            //getActionBar().setDisplayShowHomeEnabled(true);
        }
        return v;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (NavUtils.getParentActivityName(this) != null) {
                    NavUtils.navigateUpFromSameTask(this);
                }
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }
}
